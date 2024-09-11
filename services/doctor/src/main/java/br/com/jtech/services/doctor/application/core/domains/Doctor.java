/*
*  @(#)Doctor.java
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
package br.com.jtech.services.doctor.application.core.domains;

import br.com.jtech.services.doctor.adapters.input.protocols.DoctorRequest;
import br.com.jtech.services.doctor.adapters.output.repositories.entities.DoctorEntity;
import lombok.*;

import java.util.UUID;
import java.util.List;


/**
* class Doctor 
* 
* user angelo 
*/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private String id;

    public static List<Doctor> of(List<DoctorEntity> entities) {
        return entities.stream().map(Doctor::of).toList();
     }

    public DoctorEntity toEntity() {
        return DoctorEntity.builder()
            .id(UUID.fromString(getId()))
            .build();
     }

    public static Doctor of(DoctorEntity entity) {
        return Doctor.builder()
            .id(entity.getId().toString())
            .build();
     }

    public static Doctor of(DoctorRequest request) {
        return Doctor.builder()
            .id(request.getId())
            .build();
     }
 }