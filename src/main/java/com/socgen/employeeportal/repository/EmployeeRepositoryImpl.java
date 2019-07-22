package com.socgen.employeeportal.repository;

import com.socgen.employeeportal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rajnalla on 7/20/2019.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Employee> getEmployees() {
        return hibernateTemplate.loadAll(Employee.class);
    }

    @Override
    public int saveEmployee(Employee employee) {
        return (int)hibernateTemplate.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return hibernateTemplate.get(Employee.class, id);
    }
}
