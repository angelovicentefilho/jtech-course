
/*
*  @(#)ScheduleController.java
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
package br.com.jtech.services.schedule.adapters.input.controllers;

import br.com.jtech.services.schedule.adapters.input.protocols.ScheduleRequest;
import br.com.jtech.services.schedule.application.ports.input.CreateScheduleInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.jtech.services.schedule.application.core.domains.Schedule.of;

/**
* class ScheduleController
* 
* user angelo
*/
@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class CreateScheduleController {

    private final CreateScheduleInputGateway createScheduleInputGateway;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ScheduleRequest request) {
        createScheduleInputGateway.create(of(request));
        return ResponseEntity.noContent().build();
     }
 }