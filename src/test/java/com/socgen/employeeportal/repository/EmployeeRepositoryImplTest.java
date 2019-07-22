package com.socgen.employeeportal.repository;

import com.socgen.employeeportal.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by rajnalla on 7/20/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryImplTest {

    @Mock
    private HibernateTemplate hibernateTemplate;

    @InjectMocks
    private EmployeeRepositoryImpl employeeRepository;

    @Test
    public void testGetEmployees() {
        //given
        Employee employee = new Employee(1, "F", "L", "M", LocalDate.now(), "D");
        List<Employee> expected = Arrays.asList(employee);

        when(hibernateTemplate.loadAll(Employee.class)).thenReturn(expected);

        //when
        List<Employee> result = employeeRepository.getEmployees();

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSaveEmployee() {
        //given
        Employee employee = new Employee(0, "F", "L", "M", LocalDate.now(), "D");

        int expected = 1;

        when(hibernateTemplate.save(employee)).thenReturn(expected);

        //when
        int result = employeeRepository.saveEmployee(employee);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void testGetEmployee() {
        //given
        int id = 1;
        Employee expected = new Employee(0, "F", "L", "M", LocalDate.now(), "D");

        when(hibernateTemplate.get(Employee.class, id)).thenReturn(expected);

        //when
        Employee result = employeeRepository.getEmployee(id);

        //then
        assertEquals(expected, result);
    }
}
