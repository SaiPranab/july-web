package com.tastytown.backend.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI openAPI(){
        return new OpenAPI().info(getInfo());
    }
    public Info getInfo(){
        Info info = new Info()
                .title("Tasty Town")
                .description("A e-commerce web-application for ordering food ")
                .version("v2");
        return  info;
    }
}

