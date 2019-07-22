package com.socgen.employeeportal.controller;

import com.socgen.employeeportal.exception.ValidationException;
import com.socgen.employeeportal.validation.EmployeeValidator;
import com.socgen.employeeportal.model.Employee;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.socgen.employeeportal.service.EmployeeService;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rajnalla on 7/19/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Mock
    private EmployeeValidator employeeValidator;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;


    @Test
    public void testGetEmployees() {
        //given
        Employee employee = new Employee(1, "F", "L", "M", LocalDate.now(), "D");
        List<Employee> expected = Arrays.asList(employee);

        when(employeeService.getEmployees()).thenReturn(expected);

        //when
        List<Employee> result = employeeController.getEmployees();

        //then
        assertEquals(expected, result);
    }

    @Test
    public void testGetEmployee() {
        //given
        Employee expected = new Employee(1, "F", "L", "M", LocalDate.now(), "D");
        int id = 1;

        when(employeeService.getEmployee(id)).thenReturn(expected);

        //when
        Employee result = employeeController.getEmployee(id);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void testSaveEmployee() {
        //given
        Employee employee = new Employee(0, "F", "L", "M", LocalDate.now(), "D");
        int id = 1;

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        ResponseEntity<Object> expected = ResponseEntity.created(location).build();

        when(employeeService.saveEmployee(employee)).thenReturn(id);

        //when
        ResponseEntity<Object> result = employeeController.saveEmployee(employee);

        //then
        verify(employeeValidator).validate(employee);
        verify(employeeService).saveEmployee(employee);
        assertEquals(expected, result);
    }

    @Test
    public void testSaveEmployee_Validate() {
        //given
        Employee employee = new Employee(1, "", "L", "M", LocalDate.now(), "D");

        when(employeeValidator.validate(employee)).thenThrow(new ValidationException("Application Exception: First Name should not be empty"));

        expectedException.expect(ValidationException.class);

        //when
        employeeController.saveEmployee(employee);

        //then
        expectedException.expectMessage("Application Exception: First Name should not be empty");
    }

}
