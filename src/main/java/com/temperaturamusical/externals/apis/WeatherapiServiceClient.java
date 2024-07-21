package com.temperaturamusical.externals.apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherapiServiceClient {

@   Value("${temperaturamusical.weather.api.url}")
    private String url = "";

    @Value("${temperaturamusical.weather.api.apiKey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherapiServiceClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public CidadeWeatherDTO getCidadeByNome(String nome) {
        url = url + "?key="+apiKey+"&q="+nome+"";
        return restTemplate.getForObject(url, CidadeWeatherDTO.class);
    }

}
