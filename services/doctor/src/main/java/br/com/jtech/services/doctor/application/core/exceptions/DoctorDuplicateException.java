package br.com.jtech.services.doctor.application.core.exceptions;

/**
 * Exception thrown when a duplicate doctor entry is encountered.
 */
public class DoctorDuplicateException extends RuntimeException {

    /**
     * Constructs a new DoctorDuplicateException with {@code null} as its detail message.
     */
    public DoctorDuplicateException() {
    }

    /**
     * Constructs a new DoctorDuplicateException with the specified detail message.
     *
     * @param message the detail message
     */
    public DoctorDuplicateException(String message) {
        super(message);
    }

    /**
     * Constructs a new DoctorDuplicateException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause of the exception
     */
    public DoctorDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DoctorDuplicateException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public DoctorDuplicateException(Throwable cause) {
        super(cause);
    }
}