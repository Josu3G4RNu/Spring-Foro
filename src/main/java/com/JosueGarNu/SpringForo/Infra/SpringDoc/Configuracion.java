package com.JosueGarNu.SpringForo.Infra.SpringDoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class Configuracion {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components()
            .addSecuritySchemes("jwtToken",
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
        .info(new Info()
            .title("SpringForo API")
            .description(
                """
                    Es una API REST sobre un foro de discusion de temas diversos de tecnología.
                    Cuenta con las operaciones básicas de CRUD par los Topicos y Respuestas de estos.
                    Además de lograr listar los datos del usuario (Respuestas dadas y Topicos en los que ha participado).
                    """)
            .contact(new Contact()
                .name("Josué García Núñez")
                .email("di_josue88@outlook.com")
                .url("https://www.linkedin.com/in/josue-garnu/"))
            .version("1.0.0")
            .license(new License()
                .name("MIT License")
                .url("https://github.com/Josu3G4RNu/Spring-Foro/blob/main/LICENSE")));
  }

}
