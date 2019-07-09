package org.ajou.realcoding.weathercrawler.weathercrawler.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.weathercrawler.weathercrawler.api.OpenWeatherMapApiClient;
import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.ajou.realcoding.weathercrawler.weathercrawler.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j //클래스 안에서 lombok을 사용가능하게 하는 annotation
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

    public CurrentWeather getCurrentWeatherByCityName(String cityName){
        return currentWeatherRepository.findCurrentWeather(cityName);

    }


    LinkedList<String> citiesQueue = new LinkedList<>();

    @Autowired
    CurrentWeatherRepository currentWeatherRepository;

    @Scheduled(fixedDelay = 2000L) //2초마다 메소드가 실행되도록
    public void getCurrentWeatherPeriodically() throws IOException {
        if(citiesQueue.isEmpty()){
            citiesQueue.addAll(loadAvailableCityNamesFromFile());
        }

        String targetCity = citiesQueue.pop();
        citiesQueue.addLast(targetCity);

        CurrentWeather currentWeather = openWeatherMapApiClient.requestCurrentWeather(targetCity);
        currentWeatherRepository.insertCurrentWeather(currentWeather);

        //Lombok Library 기능
        log.info("Current weather has been inserted successfully. {}",currentWeather);
    }
}