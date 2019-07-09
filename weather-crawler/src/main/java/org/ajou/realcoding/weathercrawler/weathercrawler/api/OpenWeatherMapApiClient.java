package org.ajou.realcoding.weathercrawler.weathercrawler.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    private final String appid = "75551f12e1faa0a0e93591a6d7ac1d8a"; //Api Key
    private final String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={appid}";

    @Autowired
    RestTemplate restTemplate;

    public String requestCurrentWeather(String cityName) {
        //exchange method
        return restTemplate.exchange(openWeatherUrl, HttpMethod.GET,null, String.class, cityName, appid)
                .getBody(); //응답받은 response의 body를 꺼내서 리턴
    }
}
