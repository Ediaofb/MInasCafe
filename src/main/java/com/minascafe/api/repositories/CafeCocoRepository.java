package com.minascafe.api.repositories;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeCoco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Transactional
@Repository
public interface CafeCocoRepository extends JpaRepository<CafeCoco, Integer>{//é um objeto que se torna uma ponte entre o banco de dados e a entidade

    CafeCoco findByLote(int Lote);// = SELECT * FROM CafeCoco WHERE Lote = this.Lote
    CafeCoco findByProdutor(String Produtor);// = SELELCT * FROM CafeCoco WHERE Produtor = this.Produtor


    //void atualizarInformacoes(DadosAtualizacaoCafeCoco da);
}
