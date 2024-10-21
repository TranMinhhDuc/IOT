document.addEventListener("DOMContentLoaded", function() {
    fetch('/fe/data/measureHistory.json')
    .then(response => response.json())  // Corrected this line
    .then(data => {
        const xValue = data.Labels;
        const temperatureData = data.temperature;
        const humidityData = data.humidity;
        const brightnessData = data.brightness;

        console.log(xValue);

        const chartData = {
            labels: xValue,
            datasets: [
                {
                    label: "Temperature (℃)",
                    data: temperatureData,
                    borderColor: "rgb(255, 99, 132)",
                    backgroundColor: "rgba(255, 99, 132, 0.2)",
                    yAxisID: 'y',
                },
                {
                    label: "Humidity (%)",
                    data: humidityData,
                    borderColor: "rgb(54, 162, 235)",
                    backgroundColor: "rgba(54, 162, 235, 0.2)",
                    yAxisID: 'y1',
                },
                {
                    label: "Brightness (lux)",
                    data: brightnessData,
                    borderColor: "rgb(255, 206, 86)",
                    backgroundColor: "rgba(255, 206, 86, 0.2)",
                    yAxisID: 'y',
                }
            ]
        };

        const config = {
            type: 'line',
            data: chartData,
            options: {
                scales: {
                    y: {
                        beginAtZero: true,
                        type: 'linear',
                        position: 'left',
                        ticks: {
                            callback: function(value) {
                                return value + '℃'; // Adding unit to the left y-axis
                            }
                        }
                    },
                    y1: {
                        beginAtZero: true,
                        type: 'linear',
                        position: 'right',
                        grid: {
                            drawOnChartArea: false, // Only y-axis1 has grid lines
                        },
                        ticks: {
                            callback: function(value) {
                                return value + '%'; // Adding unit to the right y-axis
                            }
                        }
                    },
                    x: {
                        beginAtZero: true,
                        ticks: {
                            autoSkip: false, // Disable auto skip for more control over labels
                        }
                    }
                },
                plugins: {
                    legend: {
                        display: true
                    }
                }
            }
        };

        const myChart = new Chart(
            document.getElementById('measurementChart'),
            config
        );
    })
    .catch(error => console.error('Error fetching the JSON data:', error));

});