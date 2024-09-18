
/*
 *  @(#)DoctorController.java
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
package br.com.jtech.services.doctor.adapters.input.controllers;

import br.com.jtech.services.doctor.adapters.input.protocols.DoctorRequest;
import br.com.jtech.services.doctor.application.ports.input.CreateDoctorInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromRequest;

/**
 * class DoctorController
 * <p>
 * user angelo
 */
@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class CreateDoctorController {

    private final CreateDoctorInputGateway createDoctorInputGateway;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DoctorRequest request) {
        createDoctorInputGateway.create(fromRequest(request));
        return ResponseEntity.noContent().build();
    }
}