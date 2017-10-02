package com.converter.business;
import com.converter.domain.web.JSONConverter;

public interface WeatherBO {

    JSONConverter findWeather(final String city, final String units);

}
