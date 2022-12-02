package com.a3f.building.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Person {
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    private String line;
    private String city;
    private String state;
    private String postalCode;
}