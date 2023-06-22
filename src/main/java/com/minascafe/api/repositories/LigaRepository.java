package com.minascafe.api.repositories;

import com.minascafe.api.entities.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
public interface LigaRepository extends JpaRepository<Liga, Integer> {
    Liga findById(int Id);
    @Query("SELECT l FROM Liga l JOIN l.lotes lotes WHERE lotes.codigo = :codigo")
    Liga findByLote(String codigo);

    Liga findByNomeliga(String nomeliga);
    Liga findByData(LocalDate data);
}
