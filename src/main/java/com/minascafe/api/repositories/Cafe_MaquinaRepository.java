package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.Cafe_Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Cafe_MaquinaRepository extends JpaRepository<Cafe_Maquina, Integer>{

    Cafe_Maquina findByLote(int Lote);//SELECT * FROM Cafe_Maquina WHERE Lote = this.Lote
    Cafe_Maquina findByProdutor(String Produtor);//SELECT * FROM Cafe_Maquina WHERE Produtor = this.Produtor
}
