/*
 *  @(#)PatientAdapter.java
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
package br.com.jtech.services.patient.adapters.output;

import br.com.jtech.services.patient.adapters.output.repositories.PatientRepository;
import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.application.ports.output.CreatePatientOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.jtech.services.patient.application.core.domains.Patient.fromEntity;

/**
 * class PatientAdapter
 * <p>
 * user angelo
 */
@Component
@RequiredArgsConstructor
public class CreatePatientAdapter implements CreatePatientOutputGateway {

    private final PatientRepository repository;

    @Override
    public Patient create(Patient patient) {
        return fromEntity(this.repository.save(patient.toEntity()));
    }

}