package com.minascafe.api.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost",  "http://localhost:3000", "http://localhost:8080")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("*") // indica quais cabeçalhos HTTP são permitidos na solicitação CORS.
                .exposedHeaders("Authorization")// Permitirá que o cabeçalho Authorization seja acessado pelo código
                                                // JavaScript do cliente
                .allowCredentials(true) // permitindo credenciais (como cookies ou cabeçalhos de autenticação) nas
                                        // solicitações
                .maxAge(3600);
    }
}

// public class CorsConfig {
//     @Bean
//     public CorsConfigurationSource corsConfigurationSource(){
//       CorsConfiguration configuration = new CorsConfiguration();
//       configuration.setAllowCredentials(true);
//       configuration.addAllowedOrigin("*");
//       configuration.addAllowedMethod("*");
//       configuration.addAllowedMethod("OPTIONS");
//       configuration.addAllowedHeader("*");
//       configuration.addExposedHeader("Authorization");
//       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//       source.registerCorsConfiguration("/**", configuration);
//       return source;
// }
// }