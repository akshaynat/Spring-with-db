package com.example.springdataexample.service;

import com.example.springdataexample.dto.DepartmentRequestDTO;
import com.example.springdataexample.dto.DepartmentResponseDTO;
import com.example.springdataexample.entity.Department;

public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO);

    Department getDepartmentById(Long id);

    DepartmentResponseDTO updateDepartment(Long departmentid, DepartmentRequestDTO departmentRequestDTO);
}
