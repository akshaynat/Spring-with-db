package com.example.springdataexample.service;

import com.example.springdataexample.dto.EmployeeRequestDTO;
import com.example.springdataexample.dto.EmployeeResponseDTO;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO getEmployeeById(Long id);
    EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO deleteEmployeeById(Long id);
}
