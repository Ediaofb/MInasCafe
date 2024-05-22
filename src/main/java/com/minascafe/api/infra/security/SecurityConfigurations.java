package com.minascafe.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity // "Habilite a configuração do WebSecurity e eu vou configurar dentro dessa classe"
public class SecurityConfigurations {
    // Corrente de filtro de segurança - métodos para fazer validações no usuário e
    // validar se ele está apto a fazer as requisições

    @Value("${app.frontend.url}")
    private String frontend;

    @Autowired
    SecurityFilter securityFilter;

    @Bean // Para que o Spring consiga instanciar a classe automaticamente
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity                
                .csrf(csrf -> csrf.disable()) // desabilita o tratamento contra ataques Cross site request forgery (Falsificação de solicitação entre sites)
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // autenticação via
                // token.Ñ armazena infs. da sessão no servidor
                //.and()
                .authorizeHttpRequests(authorize -> authorize // Quais são as requisições http que serão autorizadas
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // permite q/ qualquer pessoa faça requisições para tela de login
                        .requestMatchers(HttpMethod.OPTIONS, "/auth/login").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/auth/register").hasRole("ADMIN") //.permitAll() ** Só para testar. Deve ser bloqueado. Permissão só para Admins **
                        .requestMatchers(HttpMethod.OPTIONS, "/auth/register").permitAll() //.authenticated()
                        .requestMatchers(HttpMethod.OPTIONS, "/cafecoco/**").permitAll() //.permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/cafemaquina/**").permitAll() //.authenticated()
                        .requestMatchers(HttpMethod.OPTIONS, "/cafebeneficiado/**").permitAll() //.authenticated()
                        .requestMatchers(HttpMethod.OPTIONS, "/produtor/**").permitAll() //.authenticated()
                        .requestMatchers(HttpMethod.POST, "/cafecoco/**").hasRole("ADMIN") //.permitAll()
                        .requestMatchers(HttpMethod.POST, "/cafemaquina/**").hasRole("ADMIN") //.permitAll()
                        .requestMatchers(HttpMethod.POST, "/cafebeneficiado/**").hasRole("ADMIN") //.permitAll()
                        .requestMatchers(HttpMethod.POST, "/produtor/**").hasRole("ADMIN") //.permitAll()
                        .requestMatchers(HttpMethod.GET, "/cafecoco/**").authenticated() //.permitAll()
                        .requestMatchers(HttpMethod.GET, "/cafemaquina/**").authenticated() //.permitAll()  //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/cafebeneficiado/**").authenticated() //.permitAll()
                        .requestMatchers(HttpMethod.GET, "/produtor/**").authenticated() //.permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/cafecoco/**").hasRole("ADMIN") //.authenticated() //.permitAll()
                        .requestMatchers(HttpMethod.PUT, "/cafemaquina/**").hasRole("ADMIN")//.permitAll() //.authenticated()
                        .requestMatchers(HttpMethod.PUT, "/cafebeneficiado/**").hasRole("ADMIN") //.permitAll() //.authenticated()
                        .requestMatchers(HttpMethod.PUT, "/produtor/**").hasRole("ADMIN") //.permitAll()  //.authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/cafecoco/**").hasRole("ADMIN") //.permitAll()  //.authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/cafemaquina/**").hasRole("ADMIN") //.permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/cafebeneficiado/**").hasRole("ADMIN") //.permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/produtor/**").hasRole("ADMIN") //.permitAll() //.hasRole("ADMIN")
                        .anyRequest().authenticated() // o restante, deve estar autenticado apenas
                )
                // Fará um filtro em todas as reqs. com base nas regras q estaremos
                // implementando. Fará antes dos filtros acima
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) //1° o securityFilter, depois UserNamePasswordAuthenticationFilter
                .build(); // Cria o objeto SecurityFilterChain
    }

    @Bean // Para q o Spring identifique essa classe e consiga fazer a injeção de dependência
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // Para pegar a instância de um
                                                                       // authenticationManager do SpringSecurity

    }

    @Bean // Para que o Spring faça a injeção correta deste método quando for necessário
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();// Classe q o Spring Security fornece para fazer criptografia das nossas senhas
        // Faz o hash dos dados e faz decode também - com a mesma entrada ao 'hashear' sempre gera a mesma saída
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        var configs = new CorsConfiguration();
        String[] allowedOrigins = frontend.split(",");
        for (String origin : allowedOrigins){
            configs.addAllowedOrigin(origin.trim());
        }
        configs.addAllowedHeader("*");
        configs.addAllowedMethod("*");
        //configs.addAllowedOrigin(frontend);


        var url = new UrlBasedCorsConfigurationSource();
        url.registerCorsConfiguration("/**", configs);

        return url;
    }
}