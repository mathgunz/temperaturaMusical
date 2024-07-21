package com.temperaturamusical.applications.dtos;

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

}
