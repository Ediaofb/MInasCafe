package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeCoco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Transactional
@Repository
public interface CafeCocoRepository extends JpaRepository<CafeCoco, Integer>{//é um objeto que se torna uma ponte entre o banco de dados e a entidade

    CafeCoco findByLote(int Lote);// = SELECT * FROM CafeCoco WHERE Lote = this.Lote
    
    CafeCoco findByProdutor(String Produtor);// = SELELCT * FROM CafeCoco WHERE Produtor = this.Produtor
    
    Page<CafeCoco> findAllByAtivoTrue(Pageable paginacao);
    
    Page<CafeCoco> findAllByAtivoFalse(Pageable paginacao);
    
    List<CafeCoco> findByLoteAndAtivoTrue(int lote);
    
    List<CafeCoco> findByReferenciaAndAtivoTrue(String referencia);
    
    List <CafeCoco> findAll();

}