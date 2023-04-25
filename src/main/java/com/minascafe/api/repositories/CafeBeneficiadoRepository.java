package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeBeneficiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CafeBeneficiadoRepository extends JpaRepository<CafeBeneficiado, Integer>{

    CafeBeneficiado findByLote(int Lote);//SELECT * FROM CafeBeneficiado WHERE Lote = this.Lote
    CafeBeneficiado findByProdutor(String produtor);
}
