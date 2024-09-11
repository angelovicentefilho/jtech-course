/*
 *  @(#)ApiValidationError.java
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
package br.com.jtech.services.doctor.config.infra.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * An implementation from {@link ApiSubError} to show errors by jakarta validation.
 *
 * @author angelo
 * class ApiValidationError
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    /**
     * Constructor with field and message error.
     *
     * @param object  Field error.
     * @param message Custom message on annotation.
     */
    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}