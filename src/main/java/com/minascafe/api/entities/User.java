package com.minascafe.api.entities;
// @author Edson Ferreira Barbosa

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor //Criando um construtor que ñ recebe nenhum argumento
@AllArgsConstructor //Criando um construtor nessa classe que receba todos os parâmetros
@EqualsAndHashCode
public class User implements UserDetails { // É usada para identificar uma classe que represente um usuário que vai ser
                                           // autenticado na aplicação

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera valores de maneira crescente iniciando pelo valor 1
    private Integer id;
    private String login;
    private String senha;
    private UserRole role; // Enum para enunciar todos os tipos de roles que podem ter dentro da aplicação

    public User(String login, String senha, UserRole role){
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {// Qdo o Spring Secutiry for consultar uma entidade
                                                                    // para ver quais as 'roles' que esse usuário
                                                                    // possui, p/ bloquear ou ñ um post, por exemplo.
                                                                    // Espera receber uma coleção de roles. Um usuário
                                                                    // pode possuir + de 1
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")); // Se for
                                                                                                               // Admin
                                                                                                               // receberá
                                                                                                               // as
                                                                                                               // permissões
                                                                                                               // de
                                                                                                               // Admin
                                                                                                               // e de
                                                                                                               // usuário
                                                                                                               // normal.
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));// Se ñ possuir a role de admin retornará apenas a
                                                                    // role de user
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return login; // Retorna o login do nosso usuário
    }

    @Override
    public boolean isAccountNonExpired() { // Verifica se o usuário não está bloqueado
        return true; // Como se o usuário nunca estivesse bloqueado
    }

    @Override
    public boolean isAccountNonLocked() { // Verifica se o usuário não está bloqueado
        return true; // Como se a credencial nunca tivesse espirado
    }

    @Override
    public boolean isCredentialsNonExpired() { // Verifica se a credencial não está espirada
        return true; // Como se acredencial nunca tivesse espirado
    }

    @Override
    public boolean isEnabled() { // Verifica se o usuário está ativo
        return true; // Como se o usuário estivesse sempre ativo
    }
}