package com.example.springdataexample.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class EmployeeRequestDTO {

    private Long id;

    private String name;

    private DepartmentRequestDTO department;
}
