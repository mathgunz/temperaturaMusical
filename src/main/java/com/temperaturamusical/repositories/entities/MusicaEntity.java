package com.temperaturamusical.repositories.entities;


import com.temperaturamusical.services.models.GeneroEnumType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class MusicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String artista;
    private String nome;
    private String album;
    @Enumerated(EnumType.STRING)
    private GeneroEnumType genero;

    public MusicaEntity() {
    }

    public MusicaEntity(String artista, String nome, String album) {
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

    public GeneroEnumType getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnumType genero) {
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
