package com.convert.service;
import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.tempuri.GetConversionRate;
import org.tempuri.GetConversionRateResponse;

@Component
public class CurrencyConverter implements ConverterClient<GetConversionRate, GetConversionRateResponse> {

    private static final String SOAP_ACTION = "http://tempuri.org/GetConversionRate";
    @Resource
    private WebServiceTemplate ccWebServiceTemplate;

    @Cacheable(value = "convertCache")
    public GetConversionRateResponse convert(final GetConversionRate request) {
        return (GetConversionRateResponse) ccWebServiceTemplate
                .marshalSendAndReceive(request, new SoapActionCallback(SOAP_ACTION));
    }
}
