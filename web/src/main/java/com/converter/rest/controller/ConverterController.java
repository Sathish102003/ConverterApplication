package com.converter.rest.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.converter.business.WeatherBO;
import com.converter.domain.service.Weather;
import com.converter.rest.model.JSONConverter;
import com.google.gson.Gson;

@Controller
public class ConverterController {

    @Resource
    private WeatherBO weatherBO;

    @RequestMapping(value = "/convert/weather", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String weather(@RequestBody final JSONConverter model) {
        final Weather weather = weatherBO.findWeather(model.getCity(), model.getUnit());
        return new Gson().toJson(getJsonConverter(weather, model));
    }

    private JSONConverter getJsonConverter(final Weather weather, final JSONConverter model) {
        final JSONConverter jsonConverter = new JSONConverter();
        jsonConverter.setCity(weather.getName());
        jsonConverter.setUnit(model.getUnit());
        jsonConverter.setTemperature(weather.getCurrentWeather().getTemperature());
        jsonConverter.setMaximumTemperature(weather.getCurrentWeather().getMaximumTemperature());
        jsonConverter.setMinimumTemperature(weather.getCurrentWeather().getMinimumTemperature());
        return jsonConverter;
    }
}
