package com.bree.com.models;

import lombok.Getter;
import lombok.Setter;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data

public abstract class Person {

    @Field(name = "FirstName")
    String firstName;
    @Field(name = "LastName")
    private String lastName;
    @Field(name = "Email")
    private String email;
    @Field(name = "PhoneNumber")
    private String phoneNumber;
    @Field(name = "DateOfBirth")
    private LocalDate dateOfBirth;
    @Field(name = "Position")
    private String position;
    @Field(name = "Username")
    private String username;
    @Field(name = "Password")
    private String password;

}
