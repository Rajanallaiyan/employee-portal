package com.socgen.employeeportal.controller;

import com.socgen.employeeportal.model.Employee;
import com.socgen.employeeportal.service.EmployeeService;
import com.socgen.employeeportal.validation.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rajnalla on 7/19/2019.
 */
@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping(value = "/employeeportal")
public class EmployeeController {

    @Autowired
    private EmployeeValidator employeeValidator;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees", produces = "application/json")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping(value = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> saveEmployee(@RequestBody  Employee employee) {
        employeeValidator.validate(employee);
        int id = employeeService.saveEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

}
