package com.example.springdataexample.repository;

import com.example.springdataexample.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {}