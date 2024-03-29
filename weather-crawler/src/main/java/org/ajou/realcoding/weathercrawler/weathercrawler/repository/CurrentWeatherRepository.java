package org.ajou.realcoding.weathercrawler.weathercrawler.repository;


import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {

    @Autowired
    MongoTemplate mongoTemplate;


    public void insertCurrentWeather(CurrentWeather currentWeather) {
        mongoTemplate.insert(currentWeather);
    }

    public CurrentWeather findCurrentWeather(String cityName) {
        Query query = Query.query(Criteria.where("name").is((cityName)));
        return mongoTemplate.findOne(query, CurrentWeather.class);

        /**
         *
         * 추후 과제에 remove와 update를 사용
         *
         * */
        //mongoTemplate.remove()
        //mongoTemplate.update()
        //findOne했을때, 이미 데이터가 있다면 update가 되도록 만들기
    }
}
