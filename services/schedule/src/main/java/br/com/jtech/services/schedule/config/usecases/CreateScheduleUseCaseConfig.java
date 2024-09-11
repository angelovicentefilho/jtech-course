/*
*  @(#)ScheduleUseCaseConfig.java
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
package br.com.jtech.services.schedule.config.usecases;

import br.com.jtech.services.schedule.adapters.output.CreateScheduleAdapter;
import br.com.jtech.services.schedule.application.core.usecases.CreateScheduleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* class ScheduleUseCaseConfig
* 
* user angelo
*/
@Configuration
public class CreateScheduleUseCaseConfig {

    @Bean
    public CreateScheduleUseCase useCase(CreateScheduleAdapter createScheduleAdapter) {
        return new CreateScheduleUseCase(createScheduleAdapter);
     }

 }