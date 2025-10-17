package com.busmate.ticketing_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BusmateLK Ticket Management API")
                        .version("1.0.0")
                        .description("API for managing ticket issuance, validation, QR code generation, and scan history tracking " +
                                "within the BusmateLK platform. Use the Authorize button to enter a JWT token obtained from Supabase login."))
                .addServersItem(new Server().url("http://54.91.217.117:8083").description("AWS EC2 Production"))
                .addServersItem(new Server().url("http://localhost:8083").description("Local Development"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
//                        .addSecuritySchemes("bearerAuth",
//                                new SecurityScheme()
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")
//                                        .description("Enter JWT token obtained from Supabase login")
//                        )
                );
    }
}
