package com.minascafe.api.record;

public class TotalAtivosResponse {
    private int totalSacas;
    private float quilosRestantes;
    
    public TotalAtivosResponse(int totalSacas, float quilosRestantes) {
        this.totalSacas = totalSacas;
        this.quilosRestantes = quilosRestantes;
    }

    public int getTotalSacas() {
        return totalSacas;
    }

    public void setTotalSacas(int totalSacas) {
        this.totalSacas = totalSacas;
    }

    public float getQuilosRestantes() {
        return quilosRestantes;
    }

    public void setQuilosRestantes(int quilosRestantes) {
        this.quilosRestantes = quilosRestantes;
    }    
}
