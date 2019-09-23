package com.learning.tdd.tddlearning.business.api;

import com.learning.tdd.tddlearning.domain.Car;

public interface CarService {
    Car getCarDetails(String name);
}
