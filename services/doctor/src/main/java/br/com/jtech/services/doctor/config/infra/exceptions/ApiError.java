/*
 *  @(#)ApiError.java
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class used for ExceptionHandler to show errors API.
 *
 * @author angelo
 * class ApiError
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    /**
     * Constructor with HTTP Status.
     *
     * @param status HttpStatus for error.
     */
    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    /**
     * Constructor with HTTP error status and a cause.
     *
     * @param status HttpStatus to send away.
     * @param ex     Cause of the error.
     */
    ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    /**
     * Constructor with HTTP status, custom message and cause of error.
     *
     * @param status  HttpStatus to send.
     * @param message Custom message for response error.
     * @param ex      Cause of the error.
     */
    ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}