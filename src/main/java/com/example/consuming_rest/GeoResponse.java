package com.example.consuming_rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// This is the POJO that will map the response from the
// open weather lat lon api
@JsonIgnoreProperties(ignoreUnknown = true)
public record GeoResponse(String name, double lat, double lon) {}
