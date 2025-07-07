package org.example.rpl.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API для управления футбольными командами и игроками")
                        .version("1.0")
                        .description("API позволяет управлять футбольными командами и их игроками")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}