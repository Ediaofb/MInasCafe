package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeBeneficiado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CafeBeneficiadoRepository extends JpaRepository<CafeBeneficiado, Integer>{

    CafeBeneficiado findByLote(int Lote);//SELECT * FROM CafeBeneficiado WHERE Lote = this.Lote
    List<CafeBeneficiado> findByProdutor(String produtor); //SELECT * FROM CafeBeneficiado WHERE Produtor = produtor
    Page<CafeBeneficiado> findAllByAtivoTrue(Pageable paginacao); //SELECT * FROM CafeBeneficiado WHERE ativo = true
    Page<CafeBeneficiado> findAllByAtivoFalse(Pageable paginacao); //SELECT * FROM CafeBeneficiado WHERE ativo = false (café benefiado "baixado")
    List<CafeBeneficiado> findByLoteAndAtivoTrue(int lote); // Consulta por lotes ativos - SELECT * FROM CafeBeneficiado c WHERE c.lote = lote AND ativo = true

}