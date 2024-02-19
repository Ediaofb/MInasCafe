package com.minascafe.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.minascafe.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    UserDetails findByLogin(String login); //Método para consultar usuário pelo login - retornará um UserDetails
}