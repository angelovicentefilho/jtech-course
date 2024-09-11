/*
*  @(#)ScheduleRepository.java
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
package br.com.jtech.services.schedule.adapters.output.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.jtech.services.schedule.adapters.output.repositories.entities.ScheduleEntity;

import java.util.UUID;

/**
* class ScheduleRepository 
* 
* @author angelo
*/
@Repository
public interface ScheduleRepository extends MongoRepository<ScheduleEntity, UUID> {

}