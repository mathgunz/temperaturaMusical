package com.temperaturamusical.applications.dtos;

import java.util.List;

public class TemperaturaMusica {

    private GeneroEnumType genero;
    private Double temperatura;
    private List<Musica> playlist;

    public void setGenero(GeneroEnumType generoEnumType) {
        this.genero = generoEnumType;
    }

    public void temperatura(Double temperatura) {
       this.temperatura = temperatura;
    }


    public void setPlaylist(List<Musica> musicas) {
        this.playlist = musicas;
    }

    public GeneroEnumType getGenero() {
        return genero;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public List<Musica> getPlaylist() {
        return playlist;
    }
}
