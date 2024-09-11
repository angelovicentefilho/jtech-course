/*
*  @(#)DoctorAdapter.java
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
package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.output.CreateDoctorOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* class DoctorAdapter 
* 
* user angelo  
*/
@Component
@RequiredArgsConstructor
public class CreateDoctorAdapter implements CreateDoctorOutputGateway {

    // private final DoctorRepository repository;

    @Override
    public Doctor create(Doctor doctor) {
       // return this.repository.save(doctor);
          return doctor;
    }

}