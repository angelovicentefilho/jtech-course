/*
*  @(#)DoctorUseCase.java
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
package br.com.jtech.services.doctor.application.core.usecases;


import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.input.CreateDoctorInputGateway;
import br.com.jtech.services.doctor.application.ports.output.CreateDoctorOutputGateway;

/**
* class DoctorUseCase  
* 
* user angelo  
*/
public class CreateDoctorUseCase implements CreateDoctorInputGateway {

    private final CreateDoctorOutputGateway createDoctorOutputGateway;

    public CreateDoctorUseCase(CreateDoctorOutputGateway createDoctorOutputGateway) {
        this.createDoctorOutputGateway = createDoctorOutputGateway;
     }

    public Doctor create(Doctor doctor) {
        return createDoctorOutputGateway.create(doctor);
     }
 }