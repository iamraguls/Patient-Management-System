package com.project.PatientManagementSystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(PatientNotFoundException.class)
    public Map<String,String> handlePatientNotFoundException(PatientNotFoundException ex){
        log.warn("Patient Not Found {}",ex.getMessage());
        return Map.of("message","Patient Not Found");
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public Map<String, String> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex){
        log.warn("Email already exists {}",ex.getMessage());
        return Map.of("message","Email already exists");
    }

}
