package com.workintech.springfundamentals.controller;


import com.workintech.springfundamentals.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {

    @Value("${instructor.name}")
    private String name;

    @Value("${instructor.surname}")
    private String surname;

    private Map<Integer, Animal> animalMap;

    //post Construct
    @PostConstruct
    public void init(){
         animalMap=new HashMap<>();
    }

    //public AnimalController() {
    // animalMap=new HashMap<>();
    //}

     @GetMapping("/")
     public List<Animal> get(){
        return  animalMap.values().stream().toList();
     }

     @GetMapping("/{id}")
     public Animal get(@PathVariable int id){
        if(id<0){
            //TODO id is not valid.
        }
        if(!animalMap.containsKey(id)){
            //TODO map didnt contains id.
        }
        return animalMap.get(id);

     }
     @PostMapping("/")
     public Animal save(@RequestBody Animal animal){
          if(animalMap.containsKey(animal.getId())){
              //TODO item already exist.
          }
          if(animal.getId()<0 || animal.getName()==null || animal.getName().isEmpty()){
              //TODO animal credentials are not valid.
          }

           animalMap.put(animal.getId(), animal);
          return animalMap.get(animal.getId());
     }







    @GetMapping("/welcome")
    public String welcome(){
        return name + " - " + surname + "says hi";

    }
}
