package com.temperaturamusical.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temperaturamusical.applications.dtos.GeneroEnumType;
import com.temperaturamusical.applications.dtos.Musica;
import com.temperaturamusical.applications.dtos.TemperaturaMusica;

@RestController
@RequestMapping("v1/api/cidades")
public class TemperaturaMusicaController {

    @GetMapping("{nomeCidade}/musicas")
    public TemperaturaMusica getMusicasByCidade(@RequestParam(required = false) String nome) {

        TemperaturaMusica temperaturaMusica = new TemperaturaMusica();
        temperaturaMusica.setGenero(GeneroEnumType.ROCK);
        temperaturaMusica.setPlaylist(Arrays.asList(new Musica("Charlie Brown Junior", "Papo Reto", "Bocas Ordinarias")));
        temperaturaMusica.temperatura(1.50);

        return temperaturaMusica;
    }

}
