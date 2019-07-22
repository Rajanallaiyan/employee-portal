package com.socgen.employeeportal.validation;

import com.socgen.employeeportal.exception.ValidationException;
import com.socgen.employeeportal.model.Employee;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by rajnalla on 7/20/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeValidatorImplTest  {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @InjectMocks
    private EmployeeValidatorImpl employeeValidator;

    @Test
    public void testValidate() {
        //given
        Employee employee = new Employee(1, "F", "L", "M", LocalDate.now(), "D");

        //when
        boolean result = employeeValidator.validate(employee);

        //then
        assertTrue(result);
    }

    @Test
    public void testValidate_FirstName() {
        //given
        Employee employee = new Employee(1, "", "L", "M", LocalDate.now(), "D");

        expectedException.expect(ValidationException.class);

        //when
        employeeValidator.validate(employee);

        //then
        expectedException.expectMessage("Application Exception: First Name should not be empty");
    }

    @Test
    public void testValidate_LastName() {
        //given
        Employee employee = new Employee(1, "F", "", "M", LocalDate.now(), "D");

        expectedException.expect(ValidationException.class);

        //when
        employeeValidator.validate(employee);

        //then
        expectedException.expectMessage("Application Exception: Last Name should not be empty");
    }

    @Test
    public void testValidate_Gender() {
        //given
        Employee employee = new Employee(1, "F", "L", "", LocalDate.now(), "D");

        expectedException.expect(ValidationException.class);

        //when
        employeeValidator.validate(employee);

        //then
        expectedException.expectMessage("Application Exception: Last Name should not be empty");
    }

    @Test
    public void testValidate_Dof() {
        //given
        Employee employee = new Employee(1, "F", "L", "", null, "D");

        expectedException.expect(ValidationException.class);

        //when
        employeeValidator.validate(employee);

        //then
        expectedException.expectMessage("Application Exception: Date of birth should not be empty");
    }

    @Test
    public void testValidate_Department() {
        //given
        Employee employee = new Employee(1, "F", "L", "", LocalDate.now(), "");

        expectedException.expect(ValidationException.class);

        //when
        employeeValidator.validate(employee);

        //then
        expectedException.expectMessage("Application Exception: Department should not be empty");
    }

}
