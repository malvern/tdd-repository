package com.learning.tdd.tddlearning;

import com.learning.tdd.tddlearning.domain.Car;
import com.learning.tdd.tddlearning.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRespositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCar_returnsCarDetails(){
        Car savedCar = entityManager.persistFlushFind(new Car("benz","mercedes"));
        Car car = carRepository.findByName("benz");
        assertThat(car.getName()).isEqualTo(savedCar.getName());
    }
}
