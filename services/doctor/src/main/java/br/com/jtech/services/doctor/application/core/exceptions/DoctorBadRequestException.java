package br.com.jtech.services.doctor.application.core.exceptions;

/**
 * Exception thrown when a bad request is made related to doctor operations.
 */
public class DoctorBadRequestException extends RuntimeException {

    /**
     * Constructs a new DoctorBadRequestException with {@code null} as its detail message.
     */
    public DoctorBadRequestException() {
    }

    /**
     * Constructs a new DoctorBadRequestException with the specified detail message.
     *
     * @param message the detail message
     */
    public DoctorBadRequestException(String message) {
        super(message);
    }

    /**
     * Constructs a new DoctorBadRequestException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause of the exception
     */
    public DoctorBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DoctorBadRequestException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public DoctorBadRequestException(Throwable cause) {
        super(cause);
    }
}