package com.minascafe.api.services;

import com.minascafe.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //É um serviço da aplicação
public class AuthorizationService implements UserDetailsService { //UserDetailsService representa um serviço de autenticação    

    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);//Dessa forma o SpringSecurity será capaz de consultar os nossos usuários no nosso
        //banco de dados na tabela que criamos
    }
}
// Toda vez que alguém tentar se autenticar nessa aplicação, o SpringSecurity terá que ter uma forma de consultar esses usuários.
// Dentro de 'loadUserByUsername' será onde faremos a consulta dos nossos usuários pro SpringSecurity. Aqui agente abstrai isso
// para ele.
