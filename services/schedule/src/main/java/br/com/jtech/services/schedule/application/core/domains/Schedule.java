/*
*  @(#)Schedule.java
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
package br.com.jtech.services.schedule.application.core.domains;

import br.com.jtech.services.schedule.adapters.input.protocols.ScheduleRequest;
import br.com.jtech.services.schedule.adapters.output.repositories.entities.ScheduleEntity;
import lombok.*;

import java.util.UUID;
import java.util.List;


/**
* class Schedule 
* 
* user angelo 
*/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    private String id;

    public static List<Schedule> of(List<ScheduleEntity> entities) {
        return entities.stream().map(Schedule::of).toList();
     }

    public ScheduleEntity toEntity() {
        return ScheduleEntity.builder()
            .id(UUID.fromString(getId()))
            .build();
     }

    public static Schedule of(ScheduleEntity entity) {
        return Schedule.builder()
            .id(entity.getId().toString())
            .build();
     }

    public static Schedule of(ScheduleRequest request) {
        return Schedule.builder()
            .id(request.getId())
            .build();
     }
 }