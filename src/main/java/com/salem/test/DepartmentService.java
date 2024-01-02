package com.salem.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo repo;


    @Transactional
    public List<Response> getAllDepartments() {
        return repo.findAll()
                .stream()
                .map(department -> Response.builder()
                        .departmentId(department.getId())
                        .departmentName(department.getName())
                        .build())
                .collect(Collectors.toList());
    }


    @Transactional
    public List<Response> getAllDepartmentEmployees() {
        return repo.findAll()
                .stream()
                .map(department -> Response.builder()
                        .departmentId(department.getId())
                        .departmentName(department.getName())
                        .employees(
                                department.getEmployees()
                                        .stream()
                                        .map(employee -> EmployeeDTO.builder()
                                                .id(employee.getId())
                                                .name(employee.getName()).build())
                                        .collect(Collectors.toList())
                        )
                        .build())
                .collect(Collectors.toList());
    }


}
