package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.Ficha_Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Ficha_ProdutorRepository extends JpaRepository<Ficha_Produtor, Integer>{

    Ficha_Produtor findById(int Id);//SELECT * FROM Ficha_Produtor WHERE Id = this.Id
    Ficha_Produtor findByNome(String nome); //SELECT * FROM Ficha_Produtor WHERE nome = this.nome
    Ficha_Produtor findByApelido(String apelido); //SELECT * FROM Ficha_Produtor WHERE apelido = this.apelido
    Ficha_Produtor findByCpf(String cpf); //SELECT * FROM Ficha_Produtor WHERE cpf = this.cpf
}
