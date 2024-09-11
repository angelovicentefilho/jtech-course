/*
*  @(#)Patient.java
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
package br.com.jtech.services.patient.application.core.domains;

import br.com.jtech.services.patient.adapters.input.protocols.PatientRequest;
import br.com.jtech.services.patient.adapters.output.repositories.entities.PatientEntity;
import lombok.*;

import java.util.UUID;
import java.util.List;


/**
* class Patient 
* 
* user angelo 
*/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    private String id;

    public static List<Patient> of(List<PatientEntity> entities) {
        return entities.stream().map(Patient::of).toList();
     }

    public PatientEntity toEntity() {
        return PatientEntity.builder()
            .id(UUID.fromString(getId()))
            .build();
     }

    public static Patient of(PatientEntity entity) {
        return Patient.builder()
            .id(entity.getId().toString())
            .build();
     }

    public static Patient of(PatientRequest request) {
        return Patient.builder()
            .id(request.getId())
            .build();
     }
 }