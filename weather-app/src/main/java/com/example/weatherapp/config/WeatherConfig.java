// src/main/java/com/example/weatherapp/config/WeatherConfig.java

package com.example.weatherapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weather.api")
public class WeatherConfig {
    private String url;
    private String key;
    private String units;

    // Getters and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    } 

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    } 

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
