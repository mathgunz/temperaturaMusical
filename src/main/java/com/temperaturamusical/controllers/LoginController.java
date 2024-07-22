package com.temperaturamusical.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temperaturamusical.services.LoginService;
import com.temperaturamusical.services.models.LoginModel;
import com.temperaturamusical.services.models.LoginRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Login", description = "APIs de login para gerar um token de acesso.")
@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    };

    @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = LoginRequest.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("token")
    public LoginModel getToken(@RequestParam() String username, @RequestParam() String password) throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);
        
        LoginModel login = this.loginService.getToken(loginRequest);
        return login;
    }
}