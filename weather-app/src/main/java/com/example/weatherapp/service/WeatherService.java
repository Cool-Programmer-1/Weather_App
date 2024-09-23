// src/main/java/com/example/weatherapp/service/WeatherService.java

package com.example.weatherapp.service;

import com.example.weatherapp.config.WeatherConfig;
import com.example.weatherapp.exception.WeatherServiceException;
import com.example.weatherapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private final WeatherConfig weatherConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherService(WeatherConfig weatherConfig) {
        this.weatherConfig = weatherConfig;
        this.restTemplate = new RestTemplate();
    }

    /**
     * Fetches weather data for the specified city.
     *
     * @param city the name of the city.
     * @return WeatherResponse containing weather data.
     * @throws WeatherServiceException if an error occurs while fetching data.
     */
    public WeatherResponse getWeatherByCity(String city) {
        String uri = UriComponentsBuilder.fromHttpUrl(weatherConfig.getUrl())
                .queryParam("q", city)
                .queryParam("appid", weatherConfig.getKey())
                .queryParam("units", weatherConfig.getUnits())
                .toUriString();

        try {
            ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(uri, WeatherResponse.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                WeatherResponse weather = response.getBody();
                if (weather != null) {
                    return weather;
                } else {
                    throw new WeatherServiceException("Received empty response from weather API.");
                }
            } else {
                throw new WeatherServiceException("Failed to fetch weather data: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new WeatherServiceException("Error while fetching weather data");
        }
    }
}
