package br.com.jtech.services.doctor.application.core.exceptions;

public class DoctorDuplicateException extends RuntimeException {
    public DoctorDuplicateException() {
    }

    public DoctorDuplicateException(String message) {
        super(message);
    }

    public DoctorDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorDuplicateException(Throwable cause) {
        super(cause);
    }
}
