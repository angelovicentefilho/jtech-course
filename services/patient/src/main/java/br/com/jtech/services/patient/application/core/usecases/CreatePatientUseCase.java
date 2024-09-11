/*
*  @(#)PatientUseCase.java
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
package br.com.jtech.services.patient.application.core.usecases;


import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.application.ports.input.CreatePatientInputGateway;
import br.com.jtech.services.patient.application.ports.output.CreatePatientOutputGateway;

/**
* class PatientUseCase  
* 
* user angelo  
*/
public class CreatePatientUseCase implements CreatePatientInputGateway {

    private final CreatePatientOutputGateway createPatientOutputGateway;

    public CreatePatientUseCase(CreatePatientOutputGateway createPatientOutputGateway) {
        this.createPatientOutputGateway = createPatientOutputGateway;
     }

    public Patient create(Patient patient) {
        return createPatientOutputGateway.create(patient);
     }
 }