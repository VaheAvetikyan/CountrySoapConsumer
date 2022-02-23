package com.xyz.countrysoapconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfig {

    private final CountryClientService client;

    public CountryConfig(CountryClientService client) {
        this.client = client;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.xyz.countrysoapconsumer.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClientService countryClient(Jaxb2Marshaller marshaller) {
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
