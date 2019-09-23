package com.learning.tdd.tddlearning.config;

import com.learning.tdd.tddlearning.business.impl.CarServiceImpl;
import com.learning.tdd.tddlearning.repository.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    public CarServiceImpl carService(final CarRepository carRepository){
        return new CarServiceImpl(carRepository);
    }


}
