package com.minascafe.api.repositories;

import com.minascafe.api.entities.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface LigaRepository extends JpaRepository<Liga, Integer> {//é um objeto que se torna uma ponte entre o banco de dados e a entidade


    Liga findByLotes(String Lote); // SELECT * FROM Liga WHERE Lote = this.Lote

    Liga findById(int Id); // SELECT * FROM Liga WHERE Id = this.Id

    Liga findByNomeliga(String nomeliga);
    
    List<Liga> findAll();

    List<Liga> findBydata(LocalDate data);

    /*@Query("Select li FROM Liga li WHERE li.lotes IN (:lote)")
    List<Liga> buscarPorLote(String lote);*/
}