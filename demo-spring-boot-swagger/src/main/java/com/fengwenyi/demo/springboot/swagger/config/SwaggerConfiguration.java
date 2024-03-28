package com.fengwenyi.demo.springboot.swagger.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-03-25
 */
//@Configuration
public class SwaggerConfiguration {

    @Value("${openapi.dev-url:}")
    private String devUrl;

    @Value("${openapi.prod-url:}")
    private String prodUrl;

    @Bean
    public OpenAPI openApi() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Development");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Production");

        Contact contact = new Contact();
        contact.setEmail("xfsy2014@gmail.com");
        contact.setName("Erwin Feng");
        contact.setUrl("https://www.fengwenyi.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Spring Boot Demo")
                .version("3.2.X")
                .contact(contact)
                .description("a spring boot project demo").termsOfService("https://github.com/fengwenyi/spring-boot-demo")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
