package com.xyz.countrysoapconsumer;

import com.xyz.countrysoapconsumer.wsdl.GetCountryRequest;
import com.xyz.countrysoapconsumer.wsdl.GetCountryResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    private final CountryClientService countryClientService;

    public CountryController(CountryClientService countryClientService) {
        this.countryClientService = countryClientService;
    }

    @PostMapping("/getCountry")
    public GetCountryResponse getCountryResponse(@RequestBody GetCountryRequest request) {
        String country = request.getName();
        return countryClientService.getCountry(country);
    }
}
