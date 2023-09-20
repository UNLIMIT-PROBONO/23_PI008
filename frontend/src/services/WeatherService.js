import axios from "axios";

export const getTodayWeather = async () => {
  const cityName = "seoul";
  const apiKey = process.env.REACT_APP_OPEN_WEATHER_MAP_API_KEY;

  const url = `https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=${apiKey}`;
  
  return await axios
    .get(url)
    .then((res) => {
      if (res.status === 200) {
        const body = res.data;
        return {
          temp: transferTemperature(body.main.temp),
          tempMax: transferTemperature(body.main.temp_max),
          tempMin: transferTemperature(body.main.temp_min),
          humidity: body.main.humidity,
          desc: body.weather[0].description,
          icon: body.weather[0].icon,
          loading: false,
          imgSrc: `https://openweathermap.com/img/w/${body.weather[0].icon}.png`,
        };
      }
    })
    .catch((error) => {
      console.log(error);
    });
};

const transferTemperature = (temp) => {
  return Math.round(temp - 273.15);
}