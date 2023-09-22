package com.springmart.springmartbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springMartApi() {
        return new OpenAPI().info(new Info().title("Spring Mart API")
                .description("Spring Mart Application API").version("v1.0.0"));
    }

}
