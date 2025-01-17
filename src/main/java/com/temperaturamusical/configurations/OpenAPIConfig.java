package com.temperaturamusical.configurations;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  @Value("${temperaturamusical.openapi.dev-url}")
  private String devUrl;

  @Value("${temperaturamusical.openapi.prod-url}")
  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("URL do servidor no ambiente de desenvolvimento.");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("URL do servidor no ambiente de produção.");

    Contact contact = new Contact();
    contact.setEmail("mathgunz@gmail.com");
    contact.setName("Matheus Graciano");
    contact.setUrl("https://www.temperatura-musical.com");

    Info info = new Info()
        .title("Temperatura Musical API")
        .version("1.0")
        .contact(contact)
        .description("Essa API expõe endpoints que sugere músicas com base na temperatura da cidade fornecida.")
        .termsOfService("https://www.temperatura-musical.com/terms");

    return new OpenAPI()
        .info(info)
        .servers(List.of(devServer, prodServer))
        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                    .addSecuritySchemes("bearerAuth", new SecurityScheme()
                        .name("bearerAuth")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
  }
}