package com.temperaturamusical.services;

import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.temperaturamusical.services.models.LoginModel;
import com.temperaturamusical.services.models.LoginRequest;

@Service
public class LoginService {

    private final KeycloakService keycloakService;

    public LoginService(KeycloakService keycloakService){
        this.keycloakService = keycloakService;
    }

    public LoginModel getToken(LoginRequest loginRequest) throws NotFoundException {
        
        LoginModel tokenMap = new LoginModel();
        try {
            tokenMap = this.keycloakService.getToken(loginRequest.getUsername(), loginRequest.getPassword());
        } catch (Exception e) {
            throw new NotFoundException();
        }
        return tokenMap;
    }

}
