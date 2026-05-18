package com.example.consuming_rest.service;

import com.example.consuming_rest.GeoResponse;
import com.example.consuming_rest.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {
    private final RestClient restClient;

    public WeatherService(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://api.openweathermap.org").build();
    }
    public WeatherResponse getCityWeather (String city, String apiKey) {
        // Get Lat and Lon from City
        GeoResponse[] geoResponse = restClient.get()
                .uri("/geo/1.0/direct?q={city}&limit=1&appid={key}", city, apiKey)
                .retrieve()
                .body(GeoResponse[].class);

        if (geoResponse == null || geoResponse.length == 0 ) throw new RuntimeException("City not found!");

        return restClient.get()
                .uri("/data/2.5/weather?lat={lat}&lon={lon}&appid={key}&units=metric",
                     geoResponse[0].lat(), geoResponse[0].lon(), apiKey)
                .retrieve()
                .body(WeatherResponse.class);
    }
}

// URL checks for sanity!
//https://api.openweathermap.org/data/2.5/weather?q=Perth&appid={apiKey}}&units=metric
//https://api.openweathermap.org/geo/1.0/direct?q=Perth&limit=1&appid={apiKey}