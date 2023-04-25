package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CafeMaquinaRepository extends JpaRepository<CafeMaquina, Integer>{

    CafeMaquina findByLote(int Lote);//SELECT * FROM CafeMaquina WHERE Lote = this.Lote
    CafeMaquina findByProdutor(String Produtor);//SELECT * FROM CafeMaquina WHERE Produtor = this.Produtor
}
