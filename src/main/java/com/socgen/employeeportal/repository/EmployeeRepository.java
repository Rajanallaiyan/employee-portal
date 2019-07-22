package com.socgen.employeeportal.repository;

import com.socgen.employeeportal.model.Employee;

import java.util.List;

/**
 * Created by rajnalla on 7/20/2019.
 */
public interface EmployeeRepository {
    List<Employee> getEmployees();

    int saveEmployee(Employee employee);

    Employee getEmployee(int id);
}
