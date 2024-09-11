/*
*  @(#)ScheduleAdapter.java
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
package br.com.jtech.services.schedule.adapters.output;

import br.com.jtech.services.schedule.application.core.domains.Schedule;
import br.com.jtech.services.schedule.application.ports.output.CreateScheduleOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* class ScheduleAdapter 
* 
* user angelo  
*/
@Component
@RequiredArgsConstructor
public class CreateScheduleAdapter implements CreateScheduleOutputGateway {

    // private final ScheduleRepository repository;

    @Override
    public Schedule create(Schedule schedule) {
       // return this.repository.save(schedule);
          return schedule;
    }

}