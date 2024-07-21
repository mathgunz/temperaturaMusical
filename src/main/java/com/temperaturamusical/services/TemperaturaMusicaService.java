package com.temperaturamusical.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.temperaturamusical.externals.apis.CidadeWeatherDTO;
import com.temperaturamusical.externals.apis.WeatherapiServiceClient;
import com.temperaturamusical.repositories.MusicaRepository;
import com.temperaturamusical.repositories.entities.MusicaEntity;
import com.temperaturamusical.services.models.GeneroEnumType;
import com.temperaturamusical.services.models.Musica;
import com.temperaturamusical.services.models.TemperaturaMusica;

@Service
public class TemperaturaMusicaService {

    private final WeatherapiServiceClient weatherapiServiceClient;
    private final MusicaRepository musicaRepository;

    public TemperaturaMusicaService(WeatherapiServiceClient weatherapiServiceClient, MusicaRepository musicaRepository) {
        this.weatherapiServiceClient = weatherapiServiceClient;
        this.musicaRepository = musicaRepository;
    }

    public TemperaturaMusica getMusicasByCidade(String nome) throws Exception {

        CidadeWeatherDTO cidadeInmetDto = this.weatherapiServiceClient.getCidadeByNome(nome);

        if (cidadeInmetDto == null) {
            throw new NotFoundException();
        }
        
        TemperaturaMusica temperaturaMusica= new TemperaturaMusica();
        temperaturaMusica.temperatura(cidadeInmetDto.getCurrent().getTemp_c());
        temperaturaMusica.setGenero(GeneroEnumType.determinarPorTemperatura(cidadeInmetDto.getCurrent().getTemp_c()));

        temperaturaMusica.setPlaylist(this.musicaRepository.findByGenero(temperaturaMusica.getGenero()).stream().map(musica -> new Musica(musica.getArtista(), musica.getNome(), musica.getAlbum())).toList());

        return temperaturaMusica;
    }



}
