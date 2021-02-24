package com.example.springdataexample.controller;

import com.example.springdataexample.dto.DepartmentRequestDTO;
import com.example.springdataexample.dto.DepartmentResponseDTO;
import com.example.springdataexample.entity.Department;
import com.example.springdataexample.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return departmentService.createDepartment(departmentRequestDTO);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(@PathVariable("id") Long departmentid, @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return departmentService.updateDepartment(departmentid, departmentRequestDTO);
    }
}
