package com.learning.tdd.tddlearning.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Person> person;

    public Car() {
    }

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }
}
