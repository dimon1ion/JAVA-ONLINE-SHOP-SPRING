package com.itstep.springapp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="firstname")
    @NotEmpty(message = "First Name should not be empty")
    @Size(min = 3, max = 30, message = "First Name should be between 3 and 30 characters")
    private String firstname;

    @Column(name="lastname")
    @NotEmpty(message = "Last Name should not be empty")
    @Size(min = 3, max = 30, message = "Last Name should be between 3 and 30 characters")
    private String lastname;

    @Column(name="age")
    @Min(value = 1, message = "Age should be greater than 1")
    private int age;

    public Person() {}

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
