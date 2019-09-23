package com.learning.tdd.tddlearning.business.impl;

import com.learning.tdd.tddlearning.business.api.CarService;
import com.learning.tdd.tddlearning.domain.Car;
import com.learning.tdd.tddlearning.repository.CarRepository;
import com.learning.tdd.tddlearning.utils.exception.CarNotFoundException;

public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name){
        final Car car = carRepository.findByName(name);
        if(car == null)
            throw new CarNotFoundException();
        return car;
    }
}
