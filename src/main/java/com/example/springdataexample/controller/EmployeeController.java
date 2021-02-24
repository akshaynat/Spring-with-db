package com.example.springdataexample.controller;

import com.example.springdataexample.dto.EmployeeRequestDTO;
import com.example.springdataexample.dto.EmployeeResponseDTO;
import com.example.springdataexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //POST - /employee
    @PostMapping
    public EmployeeResponseDTO createEmployee (@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.createEmployee(employeeRequestDTO);
    }
        //GET - /employee/{id}

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);

    }
    //PUT - /employee/{id}

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployeeById(@PathVariable("id") Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.updateEmployeeById(id, employeeRequestDTO);
    }
    //DELETE - /employee/{id}

    @DeleteMapping("/{id}")
    public EmployeeResponseDTO deleteEmployeeById(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/department/{id}")
    public List<EmployeeResponseDTO> getEmployeeListByDepartment(@PathVariable("id") Long departmentid) {
        return employeeService.getEmployeeListByDepartment(departmentid);
    }
}
