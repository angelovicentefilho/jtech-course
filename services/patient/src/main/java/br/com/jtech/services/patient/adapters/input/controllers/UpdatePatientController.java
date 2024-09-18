
/*
 *  @(#)PatientController.java
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
package br.com.jtech.services.patient.adapters.input.controllers;

import br.com.jtech.services.patient.adapters.input.protocols.PatientRequest;
import br.com.jtech.services.patient.adapters.input.protocols.PatientResponse;
import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.application.ports.input.CreatePatientInputGateway;
import br.com.jtech.services.patient.application.ports.input.UpdatePatientInputGateway;
import br.com.jtech.services.patient.config.infra.annotations.JtechController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static br.com.jtech.services.patient.adapters.input.protocols.PatientResponse.fromDomain;
import static br.com.jtech.services.patient.config.infra.utils.Response.createdOrBadRequest;

/**
 * class PatientController
 * <p>
 * user angelo
 */
@JtechController("/api/v1/patients")
@RequiredArgsConstructor
public class UpdatePatientController {

    private final UpdatePatientInputGateway updatePatientInputGateway;

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(
            @PathVariable String id,
            @RequestBody @Valid PatientRequest request) {
        request.setId(id);
        var patient = updatePatientInputGateway.update(Patient.fromRequest(request));
        return createdOrBadRequest("/{id}", fromDomain(patient), patient.getId());
    }
}