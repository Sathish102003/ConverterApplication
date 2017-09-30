package com.convert.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.converter.domain.service.Weather;

@Component
public class WeatherClient {

    @Value("${weather.endpoint.url}")
    private String endpointUrl;

    public Weather getWeather(final String city, final String units) {
        final RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(endpointUrl.replace("{City}", city).replace("{Units}", units), Weather.class);
    }
}
