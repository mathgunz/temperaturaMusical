package com.temperaturamusical.applications.dtos;

public class Musica {

    private String artista;
    private String nome;
    private String album;

    public Musica(String artista, String nome, String album) {
        this.artista = artista;
        this.nome = nome;
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public String getNome() {
        return nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlbum(String album) {
        this.album = album;
    } 
}
