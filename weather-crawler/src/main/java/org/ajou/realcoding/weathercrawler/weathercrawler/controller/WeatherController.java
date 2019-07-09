package org.ajou.realcoding.weathercrawler.weathercrawler.controller;

import org.ajou.realcoding.weathercrawler.weathercrawler.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/whether-crawler/available-cities")
    public List<String> getAvailableCities() throws IOException {

        return weatherService.loadAvailableCityNamesFromFile();

    }
}
