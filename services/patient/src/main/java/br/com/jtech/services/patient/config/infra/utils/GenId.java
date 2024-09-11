/*
*  @(#)GenId.java
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
package br.com.jtech.services.patient.config.infra.utils;

import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
* class GenId
*
* @author: angelo
*/
@UtilityClass
public class GenId {

    public static String newId() {
        return UUID.randomUUID().toString();
    }

    public static String newId(String id) {
        return (id != null && !id.isEmpty()) ? id : UUID.randomUUID().toString();
    }
}
