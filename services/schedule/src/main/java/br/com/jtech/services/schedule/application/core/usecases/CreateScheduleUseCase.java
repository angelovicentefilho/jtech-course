/*
*  @(#)ScheduleUseCase.java
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
package br.com.jtech.services.schedule.application.core.usecases;


import br.com.jtech.services.schedule.application.core.domains.Schedule;
import br.com.jtech.services.schedule.application.ports.input.CreateScheduleInputGateway;
import br.com.jtech.services.schedule.application.ports.output.CreateScheduleOutputGateway;

/**
* class ScheduleUseCase  
* 
* user angelo  
*/
public class CreateScheduleUseCase implements CreateScheduleInputGateway {

    private final CreateScheduleOutputGateway createScheduleOutputGateway;

    public CreateScheduleUseCase(CreateScheduleOutputGateway createScheduleOutputGateway) {
        this.createScheduleOutputGateway = createScheduleOutputGateway;
     }

    public Schedule create(Schedule schedule) {
        return createScheduleOutputGateway.create(schedule);
     }
 }