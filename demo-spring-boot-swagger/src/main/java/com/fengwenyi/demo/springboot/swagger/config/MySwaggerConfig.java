package com.fengwenyi.demo.springboot.swagger.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-03-28
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Demo",
                version = "3.0.x",
                description = "a spring boot project demo"
        ),
        externalDocs = @ExternalDocumentation(
                description = "参考文档",
                url = "https://github.com/fengwenyi/spring-boot-demo"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Dev"),
                @Server(url = "https://www.example.com", description = "Prod")
        })
public class MySwaggerConfig {
}
