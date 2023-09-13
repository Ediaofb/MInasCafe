package com.minascafe.api.record;

import java.util.List;

public class AtualizacaoStatusRequest {
    private List<String> referenciaLotes;
    private String novoStatus;

    public List<String> getReferenciaLotes() {
        return referenciaLotes;
    }

    public void setReferenciaLotes (List<String> referenciaLotes) {
        this.referenciaLotes = referenciaLotes;
    }

    public String getNovoStatus(){
        return novoStatus;
    }

    public void setNovoStatus(String novoStatus) {
        this.novoStatus = novoStatus;
    }
}