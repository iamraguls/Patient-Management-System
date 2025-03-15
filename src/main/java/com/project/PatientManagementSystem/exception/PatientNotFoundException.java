package com.project.PatientManagementSystem.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
