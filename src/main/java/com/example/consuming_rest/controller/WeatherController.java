package com.example.consuming_rest.controller;

import com.example.consuming_rest.WeatherResponse;
import com.example.consuming_rest.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class WeatherController {

    @Value("${apiKey}")
    private String apiKey;

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {

        return weatherService.getCityWeather(city, apiKey);
    }


    @PostMapping("/weather")
    public String getWeather(@RequestParam(name="city") String city, Model model) {
        String apiKey = this.apiKey;
        WeatherResponse response = weatherService.getCityWeather(city, apiKey);

        model.addAttribute("weather", response);
        return "weather";
    }
}
