/*
 *  @(#)DoctorUseCaseConfig.java
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
package br.com.jtech.services.doctor.config.usecases;

import br.com.jtech.services.doctor.adapters.output.CreateDoctorAdapter;
import br.com.jtech.services.doctor.adapters.output.FindDoctorByIdAdapter;
import br.com.jtech.services.doctor.application.core.usecases.CreateDoctorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class DoctorUseCaseConfig
 * <p>
 * user angelo
 */
@Configuration
public class CreateDoctorUseCaseConfig {

    @Bean
    public CreateDoctorUseCase createDoctorUseCase(CreateDoctorAdapter createDoctorAdapter,
                                                   FindDoctorByIdAdapter findDoctorByDoctorIdAdapter) {
        return new CreateDoctorUseCase(createDoctorAdapter, findDoctorByDoctorIdAdapter);
    }

}