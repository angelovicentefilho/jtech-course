package br.com.jtech.services.patient.application.core.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        super("Patient not found");
    }

    public PatientNotFoundException(String message) {
        super(message);
    }

    public PatientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientNotFoundException(Throwable cause) {
        super(cause);
    }
}
