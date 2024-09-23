// src/main/java/com/example/weatherapp/exception/WeatherServiceException.java

package com.example.weatherapp.exception;

/**
 * Custom exception for Weather Service errors.
 */
public class WeatherServiceException extends RuntimeException {
    
    /**
     * Constructs a new WeatherServiceException with the specified detail message.
     *
     * @param message the detail message.
     */
    public WeatherServiceException(String message) {
        super(message);
    }

    /**
     * Constructs a new WeatherServiceException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public WeatherServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
