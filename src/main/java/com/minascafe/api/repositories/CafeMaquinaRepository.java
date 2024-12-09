package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeMaquina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CafeMaquinaRepository extends JpaRepository<CafeMaquina, Integer> {

    CafeMaquina findByLote(int Lote);//SELECT * FROM CafeMaquina WHERE Lote = this.Lote
    List<CafeMaquina> findByProdutor(String Produtor);//SELECT * FROM CafeMaquina WHERE CafeMaquina = this.CafeMaquina
    Page<CafeMaquina> findAllByAtivoTrue(Pageable paginacao); //SELECT * FROM CafeMaquina WHERE ativo = true
    Page<CafeMaquina> findAllByAtivoFalse(Pageable paginacao); //SELECT * FROM CafeMaquina WHERE ativo = false (café máquina baixado)
    List<CafeMaquina> findByLoteAndAtivoTrue(int lote);
    List<CafeMaquina> findByProdutorContains(String produtor);
    List<CafeMaquina> findByMeieiroContains(String meieiro);
    List<CafeMaquina> findAll();
}