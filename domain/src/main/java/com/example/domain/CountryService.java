package com.example.domain;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {
    RestTemplate restTemplate = new RestTemplate();

    public List<Country> getCountriesByRegion() {
        String url = "https://restcountries.eu/rest/v2/region/europe";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        return Arrays.asList(response);
    }

    public List<Country> getAllCountries() {
        String url = "https://restcountries.eu/rest/v2/all";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        return Arrays.asList(response);
    }

    public List<Country> getEuropeanUnionCountries() {
        String url = "https://restcountries.eu/rest/v2/regionalbloc/eu";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        return Arrays.asList(response);
    }

}