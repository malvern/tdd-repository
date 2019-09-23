package com.learning.tdd.tddlearning;

import com.learning.tdd.tddlearning.business.impl.CarServiceImpl;
import com.learning.tdd.tddlearning.controller.CarController;
import com.learning.tdd.tddlearning.domain.Car;
import com.learning.tdd.tddlearning.utils.exception.CarNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarServiceImpl carService;

    @Test
    public void getCar_ShouldReturnCar() throws Exception {
        when(carService.getCarDetails(anyString())).
                thenReturn(new Car("benz", "mercedes"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/car/benz").
                contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).
                andExpect(jsonPath("name").value("benz")).
                andExpect(jsonPath("type").value("mercedes"));

    }

    @Test
    public void getCar_ShouldThrowExceptionIfCarNotFound() throws Exception{
        when(carService.getCarDetails(anyString())).thenThrow(new CarNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/car/benz").
                contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isNotFound());

    }
}
