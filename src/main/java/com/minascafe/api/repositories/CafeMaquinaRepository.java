package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeMaquina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CafeMaquinaRepository extends JpaRepository<CafeMaquina, Integer>{

    CafeMaquina findByLote(int Lote);//SELECT * FROM CafeMaquina WHERE Lote = this.Lote
    CafeMaquina findByProdutor(String Produtor);//SELECT * FROM CafeMaquina WHERE CafeMaquina = this.CafeMaquina
    Page<CafeMaquina> findAllByAtivoTrue(Pageable paginacao); //SELECT * FROM CafeMaquina WHERE ativo = true
    Page<CafeMaquina> findAllByAtivoFalse(Pageable paginacao);

    @Query("from CafeMaquina c where c.lote = :lote") //Linguagem JPQL - SQL orientado a objetos
    List<CafeMaquina> findByloteAndAtivoTrue(int lote, boolean ativo); //Consulta de busca por lote ativo de café máquina
}
