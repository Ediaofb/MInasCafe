package com.minascafe.api.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// @EnableWebMvc // Substitui as configurações padrão fornecidas pelo Spring
// Boot, permitindo
// personalização da configuração
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost",  "http://localhost:3000" )
                .allowedMethods("GET", "POST", "PUT", "DELETE"/*, "OPTIONS"*/)
                .allowedHeaders("*") // indica quais cabeçalhos HTTP são permitidos na solicitação CORS.
                .exposedHeaders("Authorization")// Permitirá que o cabeçalho Authorization seja acessado pelo código
                                                // JavaScript do cliente
                .allowCredentials(true) // permitindo credenciais (como cookies ou cabeçalhos de autenticação) nas
                                        // solicitações
                .maxAge(3600);
    }
}

// @Configuration
// public class CorsConfig {

// @Bean
// public CorsConfigurationSource corsConfigurationSource() {
// CorsConfiguration configuration = new CorsConfiguration();
// configuration.setAllowedOrigins(Arrays.asList("*"));
// configuration.setAllowedMethods(Arrays.asList("*")); ------> Ivan Kaiser
// configuration.setAllowedHeaders(Arrays.asList("*"));

// UrlBasedCorsConfigurationSource source = new
// UrlBasedCorsConfigurationSource();
// source.registerCorsConfiguration("/**", configuration);

// return source;
// }
// }

// @Configuration
// @EnableWebMvc // Habilita a configuração do MVC para a aplicação,
// substituindo as
// // configurações padrão do Spring Boot.
// public class CorsConfig implements WebMvcConfigurer {

// @Override
// public void addCorsMappings(CorsRegistry registry) {// Configuração do CORS.
// No seu caso, está permitindo
// // solicitações de qualquer caminho ("/**") vindo da origem
// // específica http://localhost:3000.
// registry.addMapping("/**")
// .allow edOriginPatterns("*") // (*) Permitindo requisições de todas as
// origens
// .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")// está permitindo
// os métodos HTTP GET, POST,
// // PUT, DELETE, e OPTIONS.
// .allowCredentials(true)
// .maxAge(3600);
// }
// }