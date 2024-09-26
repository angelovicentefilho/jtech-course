package br.com.jtech.services.doctor.application.core.validators;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.core.exceptions.DoctorBadRequestException;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class DoctorValidator {

    /**
     * Validates if the given doctor object is valid.
     *
     * @param doctor the doctor domain object to validate
     * @throws DoctorBadRequestException if the doctor is null
     */
    public static void isDoctorValid(Doctor doctor) {
        if (doctor == null) {
            throw new DoctorBadRequestException("Doctor cannot be null!");
        }
    }

    /**
     * Validates if the given doctor ID is valid.
     *
     * @param doctorId the ID of the doctor to validate
     * @throws DoctorBadRequestException if the doctor ID is invalid
     */
    public static void isDoctorIdValid(String doctorId) {
        try {
            UUID.fromString(doctorId);
        } catch (RuntimeException e) {
            throw new DoctorBadRequestException("DoctorId invalid!");
        }
    }
}