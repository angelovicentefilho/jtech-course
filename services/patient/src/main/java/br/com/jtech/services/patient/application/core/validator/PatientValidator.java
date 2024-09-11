package br.com.jtech.services.patient.application.core.validator;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientValidator {

    public static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
    }
}
