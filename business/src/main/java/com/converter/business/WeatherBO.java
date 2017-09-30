package com.converter.business;
import com.converter.domain.service.Weather;

public interface WeatherBO {

    Weather findWeather(final String city, final String units);
}
