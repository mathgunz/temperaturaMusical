package com.temperaturamusical.services.models;

public enum GeneroEnumType {

    POP("Pop"),
    ROCK("Rock"),
    CLASSICA("Clássica");

    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

    GeneroEnumType(String descricao) {
        this.descricao = descricao;
    }

    public static GeneroEnumType determinarPorTemperatura(double temperatura) {
        if (temperatura > 25) {
            return POP;
        } else if (temperatura >= 10 && temperatura <= 25) {
            return ROCK;
        } else {
            return CLASSICA;
        }
    }

}
