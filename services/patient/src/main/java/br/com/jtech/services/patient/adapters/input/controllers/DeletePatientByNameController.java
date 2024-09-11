
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
import br.com.jtech.services.patient.application.ports.input.DeletePatientByNameInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * class PatientController
 * <p>
 * user angelo
 */
@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class DeletePatientByNameController {

    private final DeletePatientByNameInputGateway deletePatientByNameInputGateway;

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteByName(@PathVariable String name) {
        deletePatientByNameInputGateway.delete(name);
        return ResponseEntity.noContent().build();
    }
}