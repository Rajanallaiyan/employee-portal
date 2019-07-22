package com.socgen.employeeportal.validation;

import com.socgen.employeeportal.model.Employee;

/**
 * Created by rajnalla on 7/20/2019.
 */
public interface EmployeeValidator {
    boolean validate(Employee employee);
}
