package com.pureIntegrationExam.pureIntegrationSolution.controller;

import com.pureIntegrationExam.pureIntegrationSolution.model.DogTypeWithBreeds;
import com.pureIntegrationExam.pureIntegrationSolution.service.DogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/breeds/list")
public class DogTypeController {
    @Autowired
    DogDataService dogDataService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllDogType(){
        if(dogDataService.getDogData().equals(null)){
            return new ResponseEntity<>("There is no Dog Data", HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(dogDataService.getDogData(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveDogData(@RequestBody DogTypeWithBreeds dog){
        if(dog.equals(null)){
            return new ResponseEntity<>("Dog data mus not be null",HttpStatus.BAD_REQUEST);
        }
        else {
            return  new ResponseEntity<>(dogDataService.saveDog(dog),HttpStatus.OK);
        }
    }



}
