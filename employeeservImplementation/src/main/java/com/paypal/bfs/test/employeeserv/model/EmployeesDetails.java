package com.paypal.bfs.test.employeeserv.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class EmployeesDetails {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String addessLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}
