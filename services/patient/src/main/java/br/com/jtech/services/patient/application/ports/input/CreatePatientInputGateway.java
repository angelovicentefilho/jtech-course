/*
*  @(#)PatientInputGateway.java
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
package br.com.jtech.services.patient.application.ports.input;

import br.com.jtech.services.patient.application.core.domains.Patient;

/**
* class PatientInputGateway 
* 
* user angelo 
*/
public interface CreatePatientInputGateway {
    Patient create(Patient patient);
}