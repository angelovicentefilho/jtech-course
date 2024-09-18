package br.com.jtech.services.patient.application.core.validator;

import br.com.jtech.services.patient.application.core.domains.Patient;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientValidator {

    public static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
    }

    public static void validateForUpdate(Patient patient) {
        if (patient.getId() == null) {
            throw new IllegalArgumentException("Id is required");
        }
        validateName(patient.getName());
    }

    public static void isNotNull(Patient localized) {
        if (localized == null) {
            throw new IllegalArgumentException("Patient not found");
        }
    }
}
