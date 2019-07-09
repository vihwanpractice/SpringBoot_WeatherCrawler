package org.ajou.realcoding.weathercrawler.weathercrawler;


import org.ajou.realcoding.weathercrawler.weathercrawler.controller.DogController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    @Autowired
    DogController dogController;

}
