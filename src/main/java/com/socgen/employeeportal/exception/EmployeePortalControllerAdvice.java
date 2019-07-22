package com.socgen.employeeportal.exception;

import com.socgen.employeeportal.controller.EmployeeController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by rajnalla on 7/19/2019.
 */
@ControllerAdvice(assignableTypes = EmployeeController.class)
public class EmployeePortalControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleException(Exception exception) throws Exception {
        return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
