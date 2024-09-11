/*
 *  @(#)ReadyEventListener.java
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

package br.com.jtech.services.doctor.config.infra.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * class ReadyEventListener
 * @author angelo
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class ReadyEventListener {


    @Value("${application.environment:LOCAL}")
    private String environment;

    /**
     * The method executed after Spring Boot is ready to be used.
     *
     * @param event Ready event.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void start(ApplicationReadyEvent event) {
        log.info(">>> Connector Ready");
        show();
    }

    private void show() {
        log.info("======================================================");
        log.info("== Execute mode:.....................'{}'", environment);
        log.info("======================================================");
    }
}