package com.example.springdataexample.service.impl;

import com.example.springdataexample.dto.DepartmentRequestDTO;
import com.example.springdataexample.dto.DepartmentResponseDTO;
import com.example.springdataexample.dto.EmployeeResponseDTO;
import com.example.springdataexample.entity.Department;
import com.example.springdataexample.repository.DepartmentRepository;
import com.example.springdataexample.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO) {
        Department department = new Department();

        BeanUtils.copyProperties(departmentRequestDTO, department);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(savedDepartment, departmentResponseDTO);

        return departmentResponseDTO;
    }
}
