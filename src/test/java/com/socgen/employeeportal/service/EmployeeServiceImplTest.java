package com.socgen.employeeportal.service;

import com.socgen.employeeportal.model.Employee;
import com.socgen.employeeportal.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by rajnalla on 7/20/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void testGetEmployees() {
        //given
        Employee employee = new Employee(1, "F", "L", "M", LocalDate.now(), "D");

        List<Employee> expected = Arrays.asList(employee);

        when(employeeRepository.getEmployees()).thenReturn(expected);

        //when
        List<Employee> result = employeeService.getEmployees();

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSaveEmployee() {
        //given
        Employee employee = new Employee(0, "F", "L", "M", LocalDate.now(), "D");
        int expected = 1;

        when(employeeRepository.saveEmployee(employee)).thenReturn(expected);

        //when
        int result = employeeService.saveEmployee(employee);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testGetEmployee() {
        //given
        Employee expected = new Employee(1, "F", "L", "M", LocalDate.now(), "D");
        int id = 1;

        when(employeeRepository.getEmployee(id)).thenReturn(expected);

        //when
        Employee result = employeeService.getEmployee(id);

        //then
        assertEquals(expected, result);

    }
}
