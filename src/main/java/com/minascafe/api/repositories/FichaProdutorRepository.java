package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.FichaProdutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface FichaProdutorRepository extends JpaRepository<FichaProdutor, Integer>{

    FichaProdutor findById(int Id);//SELECT * FROM FichaProdutor WHERE Id = this.Id
    FichaProdutor findByNome(String nome); //SELECT * FROM FichaProdutor WHERE nome = this.nome
    FichaProdutor findByApelido(String apelido); //SELECT * FROM FichaProdutor WHERE apelido = this.apelido
    FichaProdutor findByCpf(String cpf); //SELECT * FROM FichaProdutor WHERE cpf = this.cpf
    List<FichaProdutor> findByNomeContains(String nome);
    void deleteByNome(String nome);
}