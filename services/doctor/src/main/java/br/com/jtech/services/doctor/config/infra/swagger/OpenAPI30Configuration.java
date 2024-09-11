/*
*  @(#)OpenAPI30Configuration.java
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
package br.com.jtech.services.doctor.config.infra.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "Jtech Solucoes em Informatica",
                email = "helder.puia@veolia.com"), title = "???",
                termsOfService = "www.jtech.com.br/terms-and-condition",
                description = "${api.description}",
                version = "${api.version}"),
        servers = {
                @Server(url = "http://localhost:8081/${spring.application.name}", description = "Development"),
                @Server(url = "${api.url.homologation}/${spring.application.name}", description = "Homologation"),
                @Server(url = "${api.url.production}", description = "Production")
        }
)
/**
* class OpenAPI30Configuration
*
* @author: angelo
*/
public class OpenAPI30Configuration {
    @Bean
    public OpenAPI customizeOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .description(
                                        "Provide the JWT token.")
                                .bearerFormat("JWT")));
    }

}