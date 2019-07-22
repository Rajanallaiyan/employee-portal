package com.socgen.employeeportal.logger;

/**
 * Created by rajnalla on 7/19/2019.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoggingAspectTest {

    @Test
    public void testLogBefore() {
        //given
        JoinPoint joinPoint = mock(JoinPoint.class);
        Signature signature = mock(Signature.class);

        when(joinPoint.getSignature()).thenReturn(signature);

        LoggingAspect loggingAspect = new LoggingAspect();

        //when
        loggingAspect.logBefore(joinPoint);

        //then
        verify(signature).getName();
        verify(signature).getDeclaringTypeName();
    }

    @Test
    public void testLogAfterReturning() {
        //given
        Object val = new Object();
        JoinPoint joinPoint = mock(JoinPoint.class);
        Signature signature = mock(Signature.class);
        when(joinPoint.getSignature()).thenReturn(signature);

        LoggingAspect loggingAspect = new LoggingAspect();

        //when
        loggingAspect.logAfterReturning(joinPoint, val);

        //then
        verify(signature).getName();
        verify(signature).getDeclaringTypeName();
    }

    @Test
    public void testLogAfter() {
        //given
        JoinPoint joinPoint = mock(JoinPoint.class);
        Signature signature = mock(Signature.class);
        when(joinPoint.getSignature()).thenReturn(signature);

        LoggingAspect loggingAspect = new LoggingAspect();

        //when
        loggingAspect.logAfter(joinPoint);

        //then
        verify(signature).getName();
        verify(signature).getDeclaringTypeName();
    }

    @Test
    public void testLogAfterThrowing() {
        //given
        Throwable error = null;
        JoinPoint joinPoint = mock(JoinPoint.class);
        Signature signature = mock(Signature.class);
        when(joinPoint.getSignature()).thenReturn(signature);

        LoggingAspect loggingAspect = new LoggingAspect();

        //when
        loggingAspect.logAfterThrowing(joinPoint, error);

        //then
        verify(signature).getName();
        verify(signature).getDeclaringTypeName();
    }

}

