package com.minascafe.api.repositories;

import com.minascafe.api.entities.AmostraSemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AmostraRepository extends JpaRepository<AmostraSemEstoque, Integer> {// é um objeto que se torna uma
                                                                                      // ponte entre o banco de dados e
                                                                                      // a entidade

    AmostraSemEstoque findById(int id); // = SELECT * FROM AmostraSemEstoque WHERE id = this.id

    List<AmostraSemEstoque> findByProdutor(String produtor);

    List<AmostraSemEstoque> findByApelido(String apelido);

    List<AmostraSemEstoque> findByData(LocalDate data);

}