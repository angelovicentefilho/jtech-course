/*
*  @(#)DoctorRepository.java
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
package br.com.jtech.services.doctor.adapters.output.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.jtech.services.doctor.adapters.output.repositories.entities.DoctorEntity;

import java.util.UUID;

/**
* class DoctorRepository 
* 
* @author angelo
*/
@Repository
public interface DoctorRepository extends MongoRepository<DoctorEntity, UUID> {

}