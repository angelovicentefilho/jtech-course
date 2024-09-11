/*
*  @(#)PatientEntity.java
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
package br.com.jtech.services.patient.adapters.output.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;


/**
* class PatientEntity 
* 
* @author angelo
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias(value = "Patient")
@Document(collection = "patients")
public class PatientEntity implements Serializable {

    @Id
    private UUID id;

    //Others parameters...

}