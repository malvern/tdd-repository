package com.learning.tdd.tddlearning.domain;

import javax.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
