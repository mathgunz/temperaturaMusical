package com.temperaturamusical.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temperaturamusical.services.TemperaturaMusicaService;
import com.temperaturamusical.services.models.TemperaturaMusica;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Playlist Musicas", description = "APIs de playlist de músicas por temperatura.")
@RestController
@RequestMapping("api/v1/cidades")
public class TemperaturaMusicaController {

    private final TemperaturaMusicaService temperaturaMusicaApplication;

    public TemperaturaMusicaController(TemperaturaMusicaService temperaturaMusicaApplication) {
        this.temperaturaMusicaApplication = temperaturaMusicaApplication;
    };

    @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TemperaturaMusica.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("{nome}/musicas")
    public TemperaturaMusica getMusicasByCidade(@RequestParam(required = false) String nome) throws BadRequestException {

        TemperaturaMusica temperaturaMusica = this.temperaturaMusicaApplication.getMusicasByCidade(nome);
        return temperaturaMusica;
    }

}
