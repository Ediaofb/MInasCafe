package com.minascafe.api.infra.security;

import com.minascafe.api.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component //Carrega um componente genérico - ñ é serviço, nem interface, nem repository, nem tratamento de erros, nem configuração
public class SecurityFilter extends OncePerRequestFilter { // Filtro que acontece uma vez a cada requisição p/ tirar as
                                                           // informações do token
    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;

    @Override // Filtro que será chamado antes de UserNamePasswordAuthenticationFilter na
              // classe SecurityConfigurations
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) { // Caso o token não esteja vazio
            var login = tokenService.validateToken(token); // Valida o token e recebe o login (usuário)
            UserDetails user = userRepository.findByLogin(login); // Encontra o usuário

            // Verificações do usuário: Pega todas as infos. q o Spring Security precisará
            // p/ fazer as validações dos próxs. EndPoints, se tem role 'Admin' ou se está
            // autenticado, conforme SecutityConfiguration
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            // Gerou o token q salvará no contexto da requisição p/ q/ o Spring Security
            // possa utilizar depois:
            SecurityContextHolder.getContext().setAuthentication(authentication);// Considere este usuário já logado
        } // Caso não encontre token nenhum, ñ salvará nada nessa autenticação só chamará o próximo filtro
        filterChain.doFilter(request, response); // Chama o próximo filtro -> UserNamePasswordAuthenticationFilter em SecurityConfigurations
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization"); // Pega o cabeçalho Authorization q está dentro do
                                                             // HttpServletRequest request
        if (authHeader == null){
           // Se não tem nenhum token nessa requisição
           //throw new RuntimeException("Token JWT nao enviado no cabecalho Authorization!"); 
           return null;
        }
            
        return authHeader.replace("Bearer ", ""); 
        // Ou se houver token, substitui o valor no Authorization, de "Bearer" para vazio p/ pegarmos só o valor do token
    }
}