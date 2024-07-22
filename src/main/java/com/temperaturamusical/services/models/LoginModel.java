package com.temperaturamusical.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginModel {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String type;

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
