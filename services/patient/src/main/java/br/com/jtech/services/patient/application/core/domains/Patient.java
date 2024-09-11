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
import br.com.jtech.services.patient.config.infra.utils.GenId;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;
import java.util.List;


/**
 * class Patient
 * <p>
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
    private String name;
    private String email;
    private String phone;
    private String password;
    private String username;
    private Integer age;

    public static List<Patient> fromRequest(List<PatientEntity> entities) {
        return entities.stream().map(Patient::fromRequest).toList();
    }

    public static Patient fromEntity(PatientEntity entity) {
        return Patient.builder()
                .id(entity.getId().toString())
                .name(entity.getName())
                .age(entity.getAge())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .username(entity.getUsername())
                .build();
    }

    public PatientEntity toEntity() {
        return PatientEntity.builder()
                .id(UUID.fromString(getId()))
                .name(getName())
                .age(getAge())
                .email(getEmail())
                .password(getPassword())
                .phone(getPhone())
                .username(getUsername())
                .build();
    }

    public static Patient fromRequest(PatientEntity entity) {
        return Patient.builder()
                .id(entity.getId().toString())
                .build();
    }

    public static Patient fromRequest(PatientRequest request) {
        return Patient.builder()
                .id(GenId.newId(request.getId()))
                .name(request.getName())
                .age(request.getAge())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .username(request.getUsername())
                .build();
    }
}