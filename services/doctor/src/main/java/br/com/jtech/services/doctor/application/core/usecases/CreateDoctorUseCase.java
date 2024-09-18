/*
 *  @(#)DoctorUseCase.java
 *
 *  Copyright (c) J-Tech Solucoes em Informatica.
 *  All Rights Reserved.
 *
 *  This software is the confidential and proprietary information of J-Tech.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with J-Tech.
 *
 */
package br.com.jtech.services.doctor.application.core.usecases;


import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.core.exceptions.DoctorDuplicateException;
import br.com.jtech.services.doctor.application.core.exceptions.DoctorNotFoundException;
import br.com.jtech.services.doctor.application.ports.input.CreateDoctorInputGateway;
import br.com.jtech.services.doctor.application.ports.output.CreateDoctorOutputGateway;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorByDoctorIdOutputGateway;

import static br.com.jtech.services.doctor.application.core.validators.DoctorValidator.isDoctorValid;
import static java.util.Objects.nonNull;

/**
 * class DoctorUseCase
 * <p>
 * user angelo
 */
public class CreateDoctorUseCase implements CreateDoctorInputGateway {

    private final CreateDoctorOutputGateway createDoctorOutputGateway;
    private final FindDoctorByDoctorIdOutputGateway findDoctorByDoctorIdOutputGateway;

    public CreateDoctorUseCase(CreateDoctorOutputGateway createDoctorOutputGateway,
                               FindDoctorByDoctorIdOutputGateway findDoctorByDoctorIdOutputGateway) {
        this.createDoctorOutputGateway = createDoctorOutputGateway;
        this.findDoctorByDoctorIdOutputGateway = findDoctorByDoctorIdOutputGateway;
    }

    public Doctor create(Doctor doctor) {
        isDoctorValid(doctor);
        try {
            var other = findDoctorByDoctorIdOutputGateway.findByDoctorId(doctor.getId());
            if (nonNull(other)) {
                throw new DoctorDuplicateException("Doctor already exists!");
            }
        } catch (DoctorNotFoundException exception) {
            return createDoctorOutputGateway.create(doctor);
        }
        throw new IllegalArgumentException("Doctor not found");
    }
}