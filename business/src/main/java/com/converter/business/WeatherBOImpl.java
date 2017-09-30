package com.converter.business;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.convert.service.WeatherClient;
import com.converter.domain.service.Weather;

@Component
public class WeatherBOImpl implements WeatherBO {

    @Resource
    private WeatherClient weatherClient;

    @Override
    public Weather findWeather(final String city, final String units) {
        return weatherClient.getWeather(city, units);
    }
}
