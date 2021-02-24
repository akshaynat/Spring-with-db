package com.example.springdataexample.service.impl;

import com.example.springdataexample.dto.DepartmentResponseDTO;
import com.example.springdataexample.dto.EmployeeRequestDTO;
import com.example.springdataexample.dto.EmployeeResponseDTO;
import com.example.springdataexample.entity.Department;
import com.example.springdataexample.entity.Employee;
import com.example.springdataexample.repository.DepartmentRepository;
import com.example.springdataexample.repository.EmployeeRepository;
import com.example.springdataexample.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        //copy fields from dto to employee
        BeanUtils.copyProperties(employeeRequestDTO,employee);

        //fetch department from db
        Optional<Department> departmentOptional = departmentRepository.findById(employeeRequestDTO.getDepartment().getId());
        if(departmentOptional.isPresent()) {
            employee.setDepartment(departmentOptional.get());
        }

        //save employee to db
        Employee savedEmployee = employeeRepository.save(employee);

        //copy from employee to response dto
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        BeanUtils.copyProperties(savedEmployee,responseDTO);

        responseDTO.setDepartmentFromEntity(savedEmployee.getDepartment());

        return responseDTO;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){

            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employeeOptional.get(),responseDTO);

            return  responseDTO;
        }
        return null;
    }

    @Override
    public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO employeeRequestDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()) {
            Employee employeeFromDb = employeeOptional.get();
            employeeFromDb.setName(employeeRequestDTO.getName());

            //fetch department from db
            Optional<Department> departmentOptional = departmentRepository.findById(employeeRequestDTO.getDepartment().getId());
            if(departmentOptional.isPresent()) {
                employeeFromDb.setDepartment(departmentOptional.get());
            }

            //save in db
            Employee savedEmployee = employeeRepository.save(employeeFromDb);

            //copy from employee to response dto
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(savedEmployee, responseDTO);

            responseDTO.setDepartmentFromEntity(savedEmployee.getDepartment());

            return responseDTO;
        }
        return null;
    }

    @Override
    public EmployeeResponseDTO deleteEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()) {
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employeeOptional.get(), responseDTO);
            employeeRepository.deleteById(id);

            return  responseDTO;
        }
        return null;
    }
}
