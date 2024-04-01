package com.minascafe.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") //Aplica a configuração CORS a todos os endpoints do aplicativo
                //especifica as origens que têm permissão para fazer solicitações de origem cruzada        
                .allowedOrigins("http://localhost", "http://localhost:3000", "http:localhost:8080", "http://193.203.183.215",
                "http://193.203.183.215:3000", "http://193.203.183.215:8080", "www.comerciominascafe.com", "www.comerciominascafe.com:3000",
                "www.comerciominascafe.com:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", 
                        "Access-Control-Request-Headers", "Access-Control-Allow-Origin","Authorization")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials") // Expor o cabeçalho Access-Control-Allow-Origin
                .allowCredentials(false) //(Cookies, cabeçalhos de autorização, etc.)
                .maxAge(3600);
            }
        };
    }
}


// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class CorsConfig {

//     @Bean
//     public CorsFilter corsFilter() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowCredentials(true);
//         config.addAllowedOrigin("*");
//         config.addAllowedHeader("*");
//         config.addAllowedMethod("*");
//         source.registerCorsConfiguration("/**", config);
//         return new CorsFilter(source);
//     }
// }


// import java.util.Arrays;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class CorsConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//                 .allowedOrigins("*")
//                 .allowedMethods("GET", "POST", "OPTIONS", "PUT")
//                 .allowedHeaders("*") // indica quais cabeçalhos HTTP são permitidos na solicitação CORS.
//                 .exposedHeaders("Authorization")// Permitirá que o cabeçalho Authorization seja acessado pelo código
//                                                 // JavaScript do cliente
//                 .allowCredentials(true) // permitindo credenciais (como cookies ou cabeçalhos de autenticação) nas
//                                         // solicitações
//                 .maxAge(3600);
//     }
// }