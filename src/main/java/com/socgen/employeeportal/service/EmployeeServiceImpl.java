package com.socgen.employeeportal.service;

import com.socgen.employeeportal.model.Employee;
import com.socgen.employeeportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rajnalla on 7/20/2019.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    @Transactional
    public int saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }
}
