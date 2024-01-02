package com.salem.test;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @GetMapping("/listAll")
    public ResponseEntity<?> getAllDepartments() {
        return new ResponseEntity<>(service.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/listAllDepEmployees")
    public ResponseEntity<?> getAllDepartmentEmployees() {
        return new ResponseEntity<>(service.getAllDepartmentEmployees(), HttpStatus.OK);
    }


}
