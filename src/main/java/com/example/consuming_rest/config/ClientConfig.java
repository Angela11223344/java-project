package com.example.consuming_rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Value("${https://api.openweathermap.org}")
    private String baseUrl;

    @Bean
    public RestClient weatherClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}