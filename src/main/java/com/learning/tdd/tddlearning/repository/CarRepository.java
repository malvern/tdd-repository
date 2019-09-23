package com.learning.tdd.tddlearning.repository;

import com.learning.tdd.tddlearning.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
    Car findByName(String name);
}
