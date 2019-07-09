package org.ajou.realcoding.weathercrawler.weathercrawler.controller;


import org.ajou.realcoding.weathercrawler.weathercrawler.domain.Dog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {

    List<Dog> dogs = new ArrayList<>();


    @PostMapping("/dogs") // https://localhost:8080/dogs
    public Dog createDog(@RequestBody Dog dog){
        dogs.add(dog);
        return dog;
    }

    @GetMapping("/dogs/{name}") // https://localhost:8080/dogs/ian
    public Dog findDog(@PathVariable String name){
        for (Dog dog : dogs) {

            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        return null;
    }
    
//    /**
//     * Request Params
//     * */
//    @GetMapping("/dogs") // /dogs?name=ian&kind=martiz
//    public Dog findDog(@RequestParam String name, @RequestParam String kind){
//        for (Dog dog : dogs) {
//            if (dog.getName().equals(name)) {
//                return dog;
//            }
//        }
//        return null;
//    }


    @PutMapping("/dogs/{name}") //
    public Dog putDog(@PathVariable String name){
        for (int i = 0; i < dogs.size(); i++){
            if(dogs.get(i).getName().equals(name)){
                dogs.get(i).setName(name);
            }
        }
        return null;
    }

    @DeleteMapping("/dogs")
    public void deleteDog(@RequestParam String name){
        for (int i = 0; i < dogs.size(); i++){
            if(dogs.get(i).getName().equals(name)){
                dogs.remove(i);
            }
        }
    }
}
