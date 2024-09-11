/*
*  @(#)ScheduleResponse.java
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
package br.com.jtech.services.schedule.adapters.input.protocols;

import br.com.jtech.services.schedule.application.core.domains.Schedule;
import br.com.jtech.services.schedule.adapters.output.repositories.entities.ScheduleEntity;
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
* class ScheduleResponse 
* 
* user angelo 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleResponse implements Serializable {
    private String id;
    List<ScheduleResponse> responses;

    public static ScheduleResponse of(Schedule schedule) {
        return ScheduleResponse.builder()
                .id(schedule.getId())
                .build();
    }

    public static ScheduleResponse of(List<ScheduleEntity> entities) {
        var list = entities.stream().map(ScheduleResponse::of).toList();
        return ScheduleResponse.builder()
                .responses(list)
                .build();
    }

    public static ScheduleResponse of(ScheduleEntity entity) {
        var response = new ScheduleResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}