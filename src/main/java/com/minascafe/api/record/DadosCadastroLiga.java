package com.minascafe.api.record;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import java.time.LocalDate;
import java.util.List;

public record DadosCadastroLiga(
        @NotNull
        LocalDate data,
        @NotEmpty
        List<String> lotes,
        int somatorio_lotes,
        int somatorio_sacas,
        @Range(min = 0, max = 59, message = "Acima de 60 quilos, considere adicionar mais 1 saco!")
        Float somatorio_quilos,
        String nomeliga) {

}