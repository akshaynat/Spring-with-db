package com.example.springdataexample.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter

public class EmployeeRequestDTO {

    @Id
    private Long id;

    private String name;

    private String departmentName;
}
