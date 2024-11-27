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

}

let temperature = 30;
let humidity = 79;
let brightness = 400;
updateMeasurementDisplay(temperature, humidity, brightness);


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

document.addEventListener("DOMContentLoaded", function () {
    // Đèn thứ nhất
    const buldOnButton1 = document.querySelector('.buldOn');
    const buldOffButton1 = document.querySelector('.buldOff');
    const buldIcon1 = document.getElementById('buldIcon');
    buldOffButton1.classList.add('active');

    buldOnButton1.addEventListener('click', function () {
        buldOnButton1.classList.add('active');
        buldOffButton1.classList.remove('active');
        buldIcon1.style.color = "rgba(192, 192, 33, 0.801)";
    });

    buldOffButton1.addEventListener('click', function () {
        buldOffButton1.classList.add('active');
        buldOnButton1.classList.remove('active');
        buldIcon1.style.color = "black";
    });

    // Đèn thứ hai
    const buldOnButton2 = document.querySelector('.buldOn2');
    const buldOffButton2 = document.querySelector('.buldOff2');
    const buldIcon2 = document.getElementById('buldIcon2');
    buldOffButton2.classList.add('active');

    buldOnButton2.addEventListener('click', function () {
        buldOnButton2.classList.add('active');
        buldOffButton2.classList.remove('active');
        buldIcon2.style.color = "rgba(192, 192, 33, 0.801)";
    });

    buldOffButton2.addEventListener('click', function () {
        buldOffButton2.classList.add('active');
        buldOnButton2.classList.remove('active');
        buldIcon2.style.color = "black";
    });
});
