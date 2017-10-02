package com.converter.business;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.convert.service.WeatherClient;
import com.converter.domain.service.Weather;
import com.converter.domain.web.JSONConverter;

@Component
public class WeatherBOImpl implements WeatherBO {

    @Resource
    private WeatherClient weatherClient;

    @Override
    public JSONConverter findWeather(final String city, final String units) {
        final Weather weather = weatherClient.getWeather(city, units);
        return getJsonConverter(weather, units);
    }

    private JSONConverter getJsonConverter(final Weather weather, final String units) {
        final JSONConverter jsonConverter = new JSONConverter();
        jsonConverter.setCity(weather.getName());
        jsonConverter.setUnit(units);
        jsonConverter.setTemperature(weather.getCurrentWeather().getTemperature());
        jsonConverter.setMaximumTemperature(weather.getCurrentWeather().getMaximumTemperature());
        jsonConverter.setMinimumTemperature(weather.getCurrentWeather().getMinimumTemperature());
        return jsonConverter;
    }
}
