package com.socgen.employeeportal.exception;

import com.socgen.employeeportal.controller.EmployeeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by rajnalla on 7/19/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeePortalControllerAdviceTest {


    @Test
    public  void testHandleException() throws Exception {
        //given
        ResponseEntity<Object> expected = new ResponseEntity<Object>("exception", HttpStatus.BAD_REQUEST);
        Exception exception = mock(Exception.class);
        when(exception.getMessage()).thenReturn("exception");

        EmployeePortalControllerAdvice employeePortalControllerAdvice = new EmployeePortalControllerAdvice();

        //when
        ResponseEntity<Object> result = employeePortalControllerAdvice.handleException(exception);

        //then
        assertEquals(expected, result);
    }
}
