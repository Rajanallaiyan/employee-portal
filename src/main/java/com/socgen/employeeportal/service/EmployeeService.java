package com.socgen.employeeportal.service;

import com.socgen.employeeportal.model.Employee;

import java.util.List;

/**
 * Created by rajnalla on 7/20/2019.
 */
public interface EmployeeService {
    List<Employee> getEmployees() ;

    int saveEmployee(Employee employee);

    Employee getEmployee(int id);
}
