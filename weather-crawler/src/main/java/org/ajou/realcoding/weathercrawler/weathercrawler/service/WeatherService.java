package org.ajou.realcoding.weathercrawler.weathercrawler.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ajou.realcoding.weathercrawler.weathercrawler.api.OpenWeatherMapApiClient;
import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class WeatherService {

    List<String> cities = null;

    /**Spring boot의 라이브러리인 ObjectMapper를 사용
    */
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    OpenWeatherMapApiClient openWeatherMapApiClient;

    @PostConstruct
    public List<String> loadAvailableCityNamesFromFile() throws IOException {
        File file = new File("availableCityNames");

        return objectMapper.readValue(file, new TypeReference<List<String>>(){});
    }

    public CurrentWeather getCurrentWeatherByCities(String cityName){
        return openWeatherMapApiClient.requestCurrentWeather(cityName);

    }
}