package com.test.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Proyecto Test Cliente",
                version = "1.0.0",
                description = "Documentación interactiva generada con Springdoc OpenAPI y Swagger."
        )
)
public class SwaggerConfig {
}
