package br.com.jtech.services.doctor.application.core.validators;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import lombok.experimental.UtilityClass;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

@UtilityClass
public class DoctorValidator {
    public static void isDoctorValid(Doctor doctor) {
        checkArgument(doctor.getId() != null, "DoctorId cannot be null!");
        checkArgument(doctor.getName() != null, "Doctor name cannot be null!");
        checkArgument(doctor.getSpeciality() != null, "Doctor speciality cannot be null!");
    }

    public static void isDoctorIdValid(String doctorId) {
        try {
            UUID.fromString(doctorId);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("DoctorId invalid!");
        }
    }
}