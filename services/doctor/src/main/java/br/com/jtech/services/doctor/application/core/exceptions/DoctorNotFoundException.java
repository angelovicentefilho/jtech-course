package br.com.jtech.services.doctor.application.core.exceptions;

/**
 * Exception thrown when a doctor is not found.
 */
public class DoctorNotFoundException extends RuntimeException {

    /**
     * Constructs a new DoctorNotFoundException with {@code null} as its detail message.
     */
    public DoctorNotFoundException() {
    }

    /**
     * Constructs a new DoctorNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public DoctorNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new DoctorNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause of the exception
     */
    public DoctorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DoctorNotFoundException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public DoctorNotFoundException(Throwable cause) {
        super(cause);
    }
}