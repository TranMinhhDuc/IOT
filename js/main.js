function updateMeasurementDisplay(temp, humidity, brightness) {
    // temperature
    const temperatureIcon = document.getElementById("temperature-icon");
    const temperatureValue = document.getElementById("temperature-value");
    temperatureValue.textContent = `${temp}`;
    if (temp >= 35) {
        temperatureIcon.style.color = "red";
        temperatureIcon.className = "fas fa-thermometer-full";
    } else if (temp >= 25) {
        temperatureIcon.style.color = "orange";
        temperatureIcon.className = "fas fa-thermometer-three-quarters";
    } else if (temp >= 15) {
        temperatureIcon.style.color = "yellow";
        temperatureIcon.className = "fas fa-thermometer-half";
    } else {
        temperatureIcon.style.color = "blue";
        temperatureIcon.className = "fas fa-thermometer-quarter";
    }

    //humidity
    const humidityIcon = document.getElementById("humidity-icon");
    const humidityValue = document.getElementById("humidity-value");
    humidityValue.textContent = `${humidity}`;
    humidityIcon.style.color = humidity >= 80 ? "blue" : "lightblue";

    //brightness
    const brightnessIcon = document.getElementById("brightness-icon");
    const brightnessValue = document.getElementById("brightness-value");
    brightnessValue.textContent = `${brightness}`;
    brightnessIcon.style.color = brightness >= 300 ? "gold" : "gray";
}

let temperature = 30;
let humidity = 79;
let brightness = 400;
updateMeasurementDisplay(temperature, humidity, brightness);

// Chart

document.addEventListener("DOMContentLoaded", function(){
    fetch('/data/measurementsHistory.json')
    .then(response => response.json())
    .then(data => {
        const xValues = data.Labels;
        const temperatureData = data.temperature;
        const humidityData = data.humidity;
        const brightnessData = data.brightness;

        console.log(brightnessData)
        new Chart("measurementChart", {
            type: "line",
            data: {
            labels: xValues,
            datasets: [{ 
                label: "Nhiệt độ (℃)",
                data: temperatureData,
                borderColor: "red",
                fill: false
            }, { 
                label: "Độ ẩm (%)",
                data: humidityData,
                borderColor: "blue",
                fill: false
            }, { 
                label: "Độ sáng (lux)",
                data: brightnessData,
                borderColor: "rgb(150, 156, 0)",
                fill: false
            }]
            },
            options: {
            legend: {
                display: true, 
                position: 'bottom'
            }
            }
        });
    })
})

//controller
document.addEventListener("DOMContentLoaded", function () {
    const buldOnButton = document.querySelector('.buldOn');
    const buldOffButton = document.querySelector('.buldOff');
    buldOffButton.classList.add('active');

    buldOnButton.addEventListener('click', function () {
        buldOnButton.classList.add('active');
        buldOffButton.classList.remove('active');
        buldIcon.style.color = "rgba(192, 192, 33, 0.801)";
    });

    buldOffButton.addEventListener('click', function () {
        buldOffButton.classList.add('active');
        buldOnButton.classList.remove('active');
        buldIcon.style.color = "black";
    });

    const fanOnButton = document.querySelector('.fanOn');
    const fanOffButton = document.querySelector('.fanOff');
    fanOffButton.classList.add('active');

    fanOnButton.addEventListener('click', function () {
        fanOnButton.classList.add('active');
        fanOffButton.classList.remove('active');
        fanIcon.style.color = "green";
        fanIcon.classList.add('spin');
    });

    fanOffButton.addEventListener('click', function () {
        fanOffButton.classList.add('active');
        fanOnButton.classList.remove('active');
        fanIcon.style.color = "black";
        fanIcon.classList.remove('spin');
    });

    const airOnButton = document.querySelector('.airOn');
    const airOffButton = document.querySelector('.airOff');
    airOffButton.classList.add('active');

    airOnButton.addEventListener('click', function () {
        airOnButton.classList.add('active');
        airOffButton.classList.remove('active');
        airIcon.style.color = "lightblue";
    });

    airOffButton.addEventListener('click', function () {
        airOffButton.classList.add('active');
        airOnButton.classList.remove('active');
        airIcon.style.color = "black";
    });
});