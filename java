function getWeather() {
  var cityInput = document.getElementById("cityInput").value;
  var apiKey = "YOUR_API_KEY"; // Replace with your OpenWeatherMap API key

  // Make a GET request to OpenWeatherMap API
  fetch(`https://api.openweathermap.org/data/2.5/weather?q=${cityInput}&appid=${apiKey}`)
    .then(response => response.json())
    .then(data => {
      displayWeather(data);
    })
    .catch(error => {
      console.log(error);
    });
}

function displayWeather(data) {
  var weatherData = document.getElementById("weatherData");
  weatherData.innerHTML = "";

  var cityName = document.createElement("h2");
  cityName.textContent = data.name;

  var temperature = document.createElement("p");
  temperature.textContent = "Temperature: " + data.main.temp + "°C";

  var description = document.createElement("p");
  description.textContent = "Description: " + data.weather[0].description;

  weatherData.appendChild(cityName);
  weatherData.appendChild(temperature);
  weatherData.appendChild(description);
}
