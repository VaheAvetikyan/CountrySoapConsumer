package com.xyz.countrysoapconsumer;

import com.xyz.countrysoapconsumer.wsdl.GetCountryRequest;
import com.xyz.countrysoapconsumer.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class CountryClientService extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CountryClientService.class);

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting location for " + country);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback("http://localhost:8080/GetCountryRequest"));
    }
}
