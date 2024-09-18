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
package br.com.jtech.services.doctor.adapters.output.protocols;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * class DoctorResponse
 * <p>
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
    private String name;
    private String speciality;
    private String email;
    private List<DoctorResponse> responses;

    public static DoctorResponse fromDomain(Doctor doctor) {
        return DoctorResponse.builder()
                .id(doctor.getId().toString())
                .name(doctor.getName())
                .speciality(doctor.getSpeciality())
                .email(doctor.getEmail())
                .build();
    }


    public static DoctorResponse fromDomains(List<Doctor> doctors) {
        var list = doctors.stream().map(DoctorResponse::fromDomain).toList();
        return DoctorResponse.builder()
                .responses(list)
                .build();
    }
}