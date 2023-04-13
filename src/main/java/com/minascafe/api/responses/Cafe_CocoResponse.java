package com.minascafe.api.responses;

import java.util.ArrayList;
import java.util.List;
//Resposta...
public class Cafe_CocoResponse <T>{ //'T'- Na instanciação da Classe, permite que você passe qualquer classe para ela. É genérica.

    private T data; //data (dados) do tipo 'T'. Será sempre o retorno do tipo de response que eu estou trabalhando.--Será usado para casos de sucesso
    private List<String> errors; //É uma lista de erros. Será usada para salvar os erros que possam vir a ocorrer.

    public Cafe_CocoResponse() { //Construtor padrão
    }

    public T getData() { //Acessores getters e setters
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors(){
        if(this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        return errors;
    }
}
