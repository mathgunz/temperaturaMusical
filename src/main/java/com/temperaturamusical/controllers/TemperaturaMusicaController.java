package com.temperaturamusical.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("api/v1")
public class TemperaturaMusicaController {

    private final TemperaturaMusicaService temperaturaMusicaApplication;

    public TemperaturaMusicaController(TemperaturaMusicaService temperaturaMusicaApplication) {
        this.temperaturaMusicaApplication = temperaturaMusicaApplication;
    };

    @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TemperaturaMusica.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("cidades/{nome}/musicas-por-temperatura")
    public TemperaturaMusica getMusicasByCidade(@PathVariable(name = "nome") String nome) throws Exception {

        TemperaturaMusica temperaturaMusica = this.temperaturaMusicaApplication.getMusicasByCidade(nome);
        return temperaturaMusica;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello");
    }
}