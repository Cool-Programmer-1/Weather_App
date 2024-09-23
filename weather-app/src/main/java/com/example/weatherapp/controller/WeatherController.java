// src/main/java/com/example/weatherapp/controller/WeatherController.java

package com.example.weatherapp.controller;

import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Get weather information by city name.
     *
     * @param city the name of the city
     * @return WeatherResponse containing weather data
     */
    @GetMapping("/{city}")
    public WeatherResponse getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeatherByCity(city);
    }
}
