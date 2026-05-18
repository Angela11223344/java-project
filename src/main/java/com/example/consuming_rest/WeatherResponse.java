package com.example.consuming_rest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// This is the POJO that will map the response from the
// open weather API
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(Main main, String name, List<Weather> weather, Wind wind, Sys sys) {
    public record Main(double temp, double feels_like, int humidity, double temp_min, double temp_max) {}
    public record Weather(String description, String icon) {}
    public record Wind(double speed) {}
    public record Sys(String country) {}
}
