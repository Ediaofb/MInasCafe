package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeBaixado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CafeBaixadoRepository extends JpaRepository<CafeBaixado, Integer>{ //seu foco (Repository) também é a camada de persistência de dados de uma aplicação.

    CafeBaixado findByLote(int Lote);//SELECT * FROM CafeBaixado WHERE Lote = this.Lote
    CafeBaixado findByProdutor(String produtor);
}