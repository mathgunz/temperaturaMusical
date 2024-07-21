package com.temperaturamusical.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/musicas")
public class TemperaturaMusicaController {

    @GetMapping("")
    public String saudacao() {
        return "Olá, mundo!";
    }

}
