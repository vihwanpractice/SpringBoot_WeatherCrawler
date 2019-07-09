package org.ajou.realcoding.weathercrawler.weathercrawler.domain;

import lombok.Data;
import java.util.List;


/**
 * 응답받은 Body String을 그냥 돌려준다..? 담을 그릇을 하나 만드는게 좋지 않을까?
 * domain 패키지에 CurrentWeather 클래스를 정의해서 데이터를 한 그릇에 담기
 * */

@Data
public class CurrentWeather {

    private String name;
    private int dt;
    private String base;
    private int visibility;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Others sys;

    @Data
    public static class Weather {
        private String main;
        private String description;
        private String icon;
    }

    @Data
    public static class Main {
        private double temp;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;
    }

    @Data
    public static class Wind {
        private double speed;
        private int deg;
    }

    @Data
    public static class Clouds {
        private int all;
    }

    @Data
    public static class Others {
        private String country;
        private double message;
        private long sunrise;
        private long sunset;
    }
}