package com.minascafe.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.minascafe.api.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {    // ***** Classe para geração dos Tokens *****

    @Value("${api.security.token.secret}") //Variavel de ambiente - Está no application.properties
    private String secret;

     public String generateToken(User user){ // **** Gerador de token ****
         //Qdo us. fizer req. e env. token, averiguar quem é e se possui role necessária p/ fazer aquela requisição
         //O token fica transitando entre o cliente e o servidor
         try{
             var algorithm = Algorithm.HMAC256(secret); //Secret (HMAC256) torna os nossos Hashs únicos
             return JWT.create()
                     .withIssuer("MinasCafe") //Nome da aplicação
                     .withSubject(user.getLogin()) //Salvando o usuário no token p/ qdo usu. estiver fazendo 1 requ. consiga identificar quem é esse usuário
                     .withExpiresAt(genExpirationDate()) //tempo de expiração para o token - recebe um tipo Instant criado abaixo
                     .sign(algorithm); //para fazer a assinatura e a geração final
         } catch (JWTCreationException exception){// Pode lançar exceção qdo um dos parâmetros acima ñ estiver no formato esperado
             throw new RuntimeException("Erro ao gerar token JWT!"+ exception.getMessage()); //Lança a excessão
         }
    }

    //Método para verificar se o token ainda está válido p/ qdo usuário fizer uma nova requisição
    public String validateToken(String token) { // Descriptografa e pega o "subject": usuário
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("MinasCafe") //Quem foi o emissor - "nome da aplicação"
                    .build() //construindo novamente o nosso token
                    .verify(token)//descriptografando o token
                    .getSubject(); //pegando o usuário que foi adicionado no token
        } catch (JWTVerificationException exception) { //Qdo o token ñ for gerado por nós ou esteja expirado
            System.out.println("Erro ao obter usuário do token: " +token);
            exception.printStackTrace();
            return ""; //O método q precisar desse usuário e receber a string vazia irá notar q não possui usuário e retornará erro 'Usuário ñ autorizado'
        }
    }

        private Instant genExpirationDate(){ //Instant = instante de tempo. É um tipo do Java
        //Pega o tempo atual, adiciona 2 horas (prazo para expiração), transforma em um "Instant" e coloca no timezone de Brasília
         return LocalDateTime.now()
                 .plusHours(2)
                 .toInstant(ZoneOffset.of("-03:00"));
    }

}
