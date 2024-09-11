/*
*  @(#)PatientResponse.java
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
package br.com.jtech.services.patient.adapters.input.protocols;

import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.adapters.output.repositories.entities.PatientEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
* class PatientResponse 
* 
* user angelo 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientResponse implements Serializable {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String username;
    private Integer age;
    List<PatientResponse> responses;

    public static PatientResponse fromDomain(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .password(patient.getPassword())
                .username(patient.getUsername())
                .age(patient.getAge())
                .build();
    }

    public static PatientResponse fromDomain(List<PatientEntity> entities) {
        var list = entities.stream().map(PatientResponse::fromDomain).toList();
        return PatientResponse.builder()
                .responses(list)
                .build();
    }

    public static PatientResponse fromDomain(PatientEntity entity) {
        var response = new PatientResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}