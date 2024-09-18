/*
 *  @(#)DoctorRequest.java
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

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * class DoctorRequest
 * <p>
 * user angelo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorRequest implements Serializable {
    private String id;
    @NotBlank(message = "Name cannot be null!")
    private String name;
    @NotBlank(message = "Speciality cannot be null!")
    private String speciality;
    @NotBlank(message = "Email cannot be null!")
    @Email(message = "Invalid email!")
    private String email;
    private List<DoctorRequest> requests;
}