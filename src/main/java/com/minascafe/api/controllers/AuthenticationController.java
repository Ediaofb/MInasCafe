package com.minascafe.api.controllers;

import com.minascafe.api.entities.User;
import com.minascafe.api.record.AuthenticationDTO;
import com.minascafe.api.record.RegisterDTO;
import com.minascafe.api.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Para indicar que é um controller Rest
@RequestMapping("auth")//Para mapear o endpoint a qual esse controller vai ser chamado
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login") //Método de login
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){ //vai receber as infos. passadas pelo usuário no corpo da requisição
                              //RequestBody p pegar o Body através de um parâmetro
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());//Spring Security usa uma instância do Repository p/ realizar a consulta
        var auth = this.authenticationManager.authenticate(usernamePassword); //o método authenticate recebe o lgin e a senha como um token

        return ResponseEntity.ok().build(); //.body("Login autorizado!");
    }

    @PostMapping("/register") //EndPoint para criação de um novo usuário
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) //Caso já exista alguém no banco com esse login
            return ResponseEntity.badRequest().build(); //.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado!"); //Retorna um status de BadRequest e a mensagem no corpo da resposta
        //ou se ñ encontrar ninguém no banco de dados com esse login, aí posso registrar um novo usuário - salva o '"hash"' da senha e ñ a senha
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha()); //salva na String o hash da senha do usuário
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser); //Salva de vez o novo usuário no banco de dados

        return ResponseEntity.ok().build(); //status(HttpStatus.OK).body("Usuário cadastrado com sucesso!"); //cria uma resposta HTTP com o status 200 (OK) e nenhum conteúdo no corpo da resposta
        //Somente indica que a operação foi realizada com sucesso
    }
}