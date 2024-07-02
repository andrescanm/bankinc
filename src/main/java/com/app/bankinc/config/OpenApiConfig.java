package com.app.bankinc.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("BankInc API")
                        .description("BankInc API Documentation")
                        .version("1.0")
                        .contact(new Contact().name("Support Team").email("support@bankinc.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("BankInc Wiki Documentation")
                        .url("https://bankinc.com/docs"));
    }
}
