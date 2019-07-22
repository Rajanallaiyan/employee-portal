package com.socgen.employeeportal.validation;

import com.socgen.employeeportal.exception.ValidationException;
import com.socgen.employeeportal.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by rajnalla on 7/20/2019.
 */
@Component
public class EmployeeValidatorImpl implements EmployeeValidator {
    @Override
    public boolean validate(Employee employee) {
        if(employee == null) {
            throw new ValidationException("Employee data should not be empty");
        }

        if(isNullOrEmpty(employee.getFirstName())) {
            throw new ValidationException("First Name should not be empty");
        }

        if(isNullOrEmpty(employee.getLastName())) {
            throw new ValidationException("Last Name should not be empty");
        }

        if(isNullOrEmpty(employee.getGender())) {
            throw new ValidationException("Gender should not be empty");
        }

        if(isNullOrEmpty(employee.getDepartment())) {
            throw new ValidationException("Department should not be empty");
        }

        if(employee.getDateOfBirth() == null) {
            throw new ValidationException("Date of birth should not be empty");
        } else {
            if(employee.getDateOfBirth().isAfter(LocalDate.now())) {
                throw new ValidationException("Date of birth cannot be a future date");
            }
        }
        return true;
    }

    private boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
