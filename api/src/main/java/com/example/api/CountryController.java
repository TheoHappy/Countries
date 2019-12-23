package com.example.api;




import com.example.domain.Country;
import com.example.domain.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(
            CountryService countryService
    ) {
        this.countryService = countryService;
    }

    @GetMapping("eu")
    public List<String> getAllEuropeanCountries() throws Throwable {
        List<Country> countriesByEuRegion = countryService.getCountriesByRegion();
        List<String> europeanCountries;
        europeanCountries = new ArrayList<>(countriesByEuRegion.stream().map(Country::getName).collect(Collectors.toList()));
        return europeanCountries;
    }

    @GetMapping("all")
    public List<String> getAllCountries() throws Throwable {
        List<Country> countries = countryService.getAllCountries();
        List<String> allCountries;
        allCountries = new ArrayList<>(countries.stream().map(Country::getName).collect(Collectors.toList()));
        return allCountries;
    }

    @GetMapping("ue")
    public List<String> getEuropeanUnionCountries() throws Throwable {
        List<Country> countries = countryService.getEuropeanUnionCountries();
        List<String> europeanUnionCountries;
        europeanUnionCountries = new ArrayList<>(countries.stream().map(Country::getName).collect(Collectors.toList()));
        return europeanUnionCountries;
    }

}