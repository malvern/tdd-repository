package com.learning.tdd.tddlearning;

import com.learning.tdd.tddlearning.business.impl.CarServiceImpl;
import com.learning.tdd.tddlearning.domain.Car;
import com.learning.tdd.tddlearning.repository.CarRepository;
import com.learning.tdd.tddlearning.utils.exception.CarNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceUnitTest {

    @Mock
    private CarRepository carRepository;

    private CarServiceImpl carService;

    @Before
    public void setup() {
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    public void getCarDetails_ReturnsCarInfo() {
        given(carRepository.findByName("benz")).
                willReturn(new Car("benz", "mercedes"));
        Car car = carService.getCarDetails("benz");
        assertThat(car.getName()).isEqualTo("benz");
        assertThat(car.getType()).isEqualTo("mercedes");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() throws Exception{
        given(carRepository.findByName("benz")).
                willReturn(null);
        carService.getCarDetails("benz");
    }
}
