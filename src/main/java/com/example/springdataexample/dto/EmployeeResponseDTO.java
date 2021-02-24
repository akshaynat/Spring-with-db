package com.example.springdataexample.dto;

import com.example.springdataexample.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {

    private Long id;

    private String name;

    private DepartmentResponseDTO department;

    private String code;

    public void setDepartmentFromEntity(Department departmentFromEntity) {
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        departmentResponseDTO.setId(departmentFromEntity.getId());
        departmentResponseDTO.setName(departmentFromEntity.getName());
        this.department = departmentResponseDTO;
    }
}
