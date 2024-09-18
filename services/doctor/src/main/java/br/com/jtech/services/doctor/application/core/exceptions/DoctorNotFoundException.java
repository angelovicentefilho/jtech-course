package br.com.jtech.services.doctor.application.core.exceptions;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException() {
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }

    public DoctorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorNotFoundException(Throwable cause) {
        super(cause);
    }
}
