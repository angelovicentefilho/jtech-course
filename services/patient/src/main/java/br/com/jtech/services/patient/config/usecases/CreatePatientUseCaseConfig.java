/*
*  @(#)PatientUseCaseConfig.java
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
package br.com.jtech.services.patient.config.usecases;

import br.com.jtech.services.patient.adapters.output.CreatePatientAdapter;
import br.com.jtech.services.patient.application.core.usecases.CreatePatientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* class PatientUseCaseConfig
* 
* user angelo
*/
@Configuration
public class CreatePatientUseCaseConfig {

    @Bean
    public CreatePatientUseCase useCase(CreatePatientAdapter createPatientAdapter) {
        return new CreatePatientUseCase(createPatientAdapter);
     }

 }