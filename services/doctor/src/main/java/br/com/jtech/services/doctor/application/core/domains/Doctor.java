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
import br.com.jtech.services.patient.config.infra.utils.GenId;
import lombok.*;

import java.util.UUID;
import java.util.List;


/**
 * class Doctor
 * <p>
 * user angelo
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private UUID id;
    private String name;
    private String speciality;
    private String email;

    public static List<Doctor> fromEntities(List<DoctorEntity> entities) {
        return entities.stream().map(Doctor::fromEntity).toList();
    }

    public DoctorEntity toEntity() {
        return DoctorEntity.builder()
                .id(getId())
                .name(getName())
                .speciality(getSpeciality())
                .email(getEmail())
                .build();
    }

    public static Doctor fromEntity(DoctorEntity document) {
        return Doctor.builder()
                .id(document.getId())
                .name(document.getName())
                .speciality(document.getSpeciality())
                .email(document.getEmail())
                .build();
    }

    public static Doctor fromRequest(DoctorRequest request) {
        return Doctor.builder()
                .id(GenId.newUuid(request.getId()))
                .name(request.getName())
                .speciality(request.getSpeciality())
                .email(request.getEmail())
                .build();
    }
}