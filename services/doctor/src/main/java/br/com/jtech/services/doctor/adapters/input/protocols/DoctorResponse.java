/*
*  @(#)DoctorResponse.java
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
package br.com.jtech.services.doctor.adapters.input.protocols;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.adapters.output.repositories.entities.DoctorEntity;
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
* class DoctorResponse 
* 
* user angelo 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorResponse implements Serializable {
    private String id;
    List<DoctorResponse> responses;

    public static DoctorResponse of(Doctor doctor) {
        return DoctorResponse.builder()
                .id(doctor.getId())
                .build();
    }

    public static DoctorResponse of(List<DoctorEntity> entities) {
        var list = entities.stream().map(DoctorResponse::of).toList();
        return DoctorResponse.builder()
                .responses(list)
                .build();
    }

    public static DoctorResponse of(DoctorEntity entity) {
        var response = new DoctorResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}