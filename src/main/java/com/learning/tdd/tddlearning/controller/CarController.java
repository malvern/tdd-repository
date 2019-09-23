package com.learning.tdd.tddlearning.controller;


import com.learning.tdd.tddlearning.business.impl.CarServiceImpl;
import com.learning.tdd.tddlearning.domain.Car;

import com.learning.tdd.tddlearning.utils.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CarController {

    private CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/car/{name}")//,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public Car getCar(@PathVariable String name){
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException carNotException){
        //we can add response in the exception class @ResponseStatus

    }
}
