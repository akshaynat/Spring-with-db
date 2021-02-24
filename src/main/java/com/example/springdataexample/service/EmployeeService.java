package com.example.springdataexample.service;

import com.example.springdataexample.dto.EmployeeRequestDTO;
import com.example.springdataexample.dto.EmployeeResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO getEmployeeById(Long id);
    EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO deleteEmployeeById(Long id);
    List<EmployeeResponseDTO> getEmployeeListByDepartment(Long id);
}
