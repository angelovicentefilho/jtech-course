
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
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.jtech.services.patient.application.core.domains.Patient.fromRequest;

/**
* class PatientController
* 
* user angelo
*/
@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class CreatePatientController {

    private final CreatePatientInputGateway createPatientInputGateway;

    @PostMapping
    public ResponseEntity<PatientResponse> create(@RequestBody @Valid PatientRequest request) {
        var patient = createPatientInputGateway.create(Patient.fromRequest(request));
        return ResponseEntity.ok(PatientResponse.fromDomain(patient));
     }
 }