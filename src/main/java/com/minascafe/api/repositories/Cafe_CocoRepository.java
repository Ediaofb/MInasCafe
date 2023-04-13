package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.Cafe_Coco;
import org.springframework.data.jpa.repository.JpaRepository;

//@Transactional
public interface Cafe_CocoRepository extends JpaRepository<Cafe_Coco, Integer>{//é um objeto que se torna uma ponte entre o banco de dados e a entidade

    Cafe_Coco findByLote(int Lote);// = SELECT * FROM Cafe_Coco WHERE Lote = this.Lote
    Cafe_Coco findByProdutor(String Produtor);// = SELELCT * FROM Cafe_Coco WHERE Produtor = this.Produtor
}
