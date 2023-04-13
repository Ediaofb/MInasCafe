package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.Cafe_Beneficiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Cafe_BeneficiadoRepository extends JpaRepository<Cafe_Beneficiado, Integer>{

    Cafe_Beneficiado findByLote(int Lote);//SELECT * FROM Cafe_Beneficiado WHERE Lote = this.Lote
    Cafe_Beneficiado findByProdutor(String produtor);
}
