#include <WiFi.h>
#include <PubSubClient.h>
#include <DHT.h>

// Replace with your WiFi and MQTT details
const char* ssid = "Thuy Xuan";
const char* password = "1234567899tx";

// Địa chỉ của MQTT broker (Mosquitto)
const char* mqtt_server = "192.168.1.2";  // Địa chỉ IP của broker

// mqtt port
const char* mqtt_port = "1885";

// Tài khoản và mật khẩu cho MQTT
const char* mqtt_user = "client";
const char* mqtt_pass = "00000";
const char* mqtt_topic = "sensor/esp32";
const char* mqtt_subscribe_topic = "control/esp32"; // Topic để nhận dữ liệu

// DHT11 setup
#define DHTPIN 4  // Pin connected to the DHT sensor
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

// Quang trở setup
#define LDRPIN 34  // Pin connected to the photoresistor (GPIO 2)

// LED setup
#define LED1 18  // Pin connected to led1
#define LED2 19  // Pin connected to led2
#define LED3 21  // Pin connected to led3

const int R_fixed = 10000;

// WiFi and MQTT setup
WiFiClient espClient;
PubSubClient client(espClient);

// Hàm callback khi nhận dữ liệu từ MQTT
void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  String message;
  
  for (unsigned int i = 0; i < length; i++) {
    message += (char)payload[i]; // Ghép các byte thành chuỗi
  }
  
  Serial.println(message);
  
  // Thực hiện các hành động dựa trên message nhận được
  if (message == "ON1") {
    onLed1();
  } else if (message == "OFF1") {
    offLed1();
  } else if (message == "ON2") {
    onLed2();
  } else if (message == "OFF2") {
    offLed2();
  } else if (message == "ON3") {
    onLed3();
  } else if (message == "OFF3") {
    offLed3();
  }
}

  // xử lý led
void onLed1() {
  digitalWrite(LED1, HIGH);
}
void offLed1() {
  digitalWrite(LED1, LOW);
}

void onLed2() {
  digitalWrite(LED2, HIGH);
}
void offLed2() {
  digitalWrite(LED2, LOW);
}

void onLed3() {
  digitalWrite(LED3, HIGH);
}
void offLed3() {
  digitalWrite(LED3, LOW);
}

void setup_wifi() {
  delay(10);
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print("can't connect");
  }
  Serial.println("");
  Serial.println("WiFi connected");
}

void reconnect() {
  // Loop until we're reconnected
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    // Attempt to connect with username and password
    if (client.connect("ESP32Client", mqtt_user, mqtt_pass)) {
      Serial.println("connected");
      // Subscribe to a topic
      client.subscribe(mqtt_subscribe_topic); // Đăng ký nhận dữ liệu từ topic này
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 5 seconds");
      delay(5000);
    }
  }
}

float convertLDRToLux(int adcValue) {
  if (adcValue > 3500) return 0;
  if (adcValue < 50) return 3000;
  float light = 500000 / adcValue;
  return light;
}

void setup() {
  Serial.begin(115200);
  dht.begin();
  setup_wifi();
  client.setServer(mqtt_server, 1885);
  client.setCallback(callback); // Cấu hình hàm callback để nhận dữ liệu
  pinMode(LDRPIN, INPUT); // Cấu hình chân quang trở

  // Cấu hình các chân cho LED
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
}

void loop() {
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  // Reading temperature and humidity
  float h = dht.readHumidity();
  float t = dht.readTemperature();

  // Reading photoresistor value
  int ldrValue = analogRead(LDRPIN);
  // Check if any reads failed
  int light = (int)convertLDRToLux(ldrValue);
  if (isnan(h) || isnan(t)) {
    Serial.println("Failed to read from DHT sensor!");
    return;
  }

  // Publish data to MQTT
  String payload = String(t) + ", " + String(h) + ", " + String(light);
  Serial.println(payload);
  client.publish(mqtt_topic, payload.c_str());

  delay(2000);
}
