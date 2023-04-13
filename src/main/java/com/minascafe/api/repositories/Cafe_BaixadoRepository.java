package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.Cafe_Baixado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Cafe_BaixadoRepository extends JpaRepository<Cafe_Baixado, Integer>{ //seu foco (Repository) também é a camada de persistência de dados de uma aplicação.

    Cafe_Baixado findByLote(int Lote);//SELECT * FROM Cafe_Baixado WHERE Lote = this.Lote
    Cafe_Baixado findByProdutor(String produtor);
}