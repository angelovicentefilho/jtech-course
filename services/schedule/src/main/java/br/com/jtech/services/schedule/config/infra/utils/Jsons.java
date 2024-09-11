/*
*  @(#)Jsons.java
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
package br.com.jtech.services.schedule.config.infra.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
* class Jsons
*
* user angelo
*/
@Slf4j
@UtilityClass
public class Jsons {

    private static final ObjectMapper mapper;

    private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    static {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializerByType(Long.class, ToStringSerializer.instance);
        builder.serializerByType(Long.TYPE, ToStringSerializer.instance);
        builder.serializerByType(long.class, ToStringSerializer.instance);
        builder.simpleDateFormat(DEFAULT_DATETIME_PATTERN);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN);
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
        builder.timeZone("America/Sao_Paulo");

        builder.modules(new ParameterNamesModule(), new Jdk8Module(), javaTimeModule);

        builder.featuresToEnable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
                DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        mapper = builder.build();
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static String toJsonString(Object object) {
        if (Objects.nonNull(object)) {
            try {
                return mapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                log.error("::: Failed to write value as json string.", e);
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static <T> T parseJsonString(String json, Class<T> clazz) {
        if (StringUtils.isNotBlank(json) && Objects.nonNull(clazz)) {
            try {
                return mapper.readValue(json, clazz);
            } catch (IOException e) {
                log.error("::: Failed to convert json string to java bean.", e);
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static <T> T parseJsonString(String json, TypeReference<T> reference) {
        if (StringUtils.isNotBlank(json) && Objects.nonNull(reference)) {
            try {
                return mapper.readValue(json, reference);
            } catch (JsonProcessingException e) {
                log.error("::: Failed to read json string value.", e);
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}