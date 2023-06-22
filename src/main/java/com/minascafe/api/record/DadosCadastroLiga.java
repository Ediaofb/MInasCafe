package com.minascafe.api.record;

import com.fasterxml.jackson.databind.JsonNode;
import com.minascafe.api.entities.Lote;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;


public record DadosCadastroLiga(
        @NotBlank //verifica se não é nulo e não é vazio = @NotNull + verificação de vazio
        LocalDate data,
        @NotEmpty
        List<Lote> lotes,
        int sacas,
        Float quilos,
        String produtor,
        String bebida,
        int somatorio_lotes,
        int somatorio_quilos,
        int somatorio_sacas,
        String nomeliga
) {
}
