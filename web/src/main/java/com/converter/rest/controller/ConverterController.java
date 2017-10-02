package com.converter.rest.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.converter.business.CurrencyBO;
import com.converter.business.WeatherBO;
import com.converter.domain.web.JSONConverter;
import com.google.gson.Gson;

@Controller
public class ConverterController {

    @Resource
    private WeatherBO weatherBO;

    @Resource
    private CurrencyBO currencyBO;

    @RequestMapping(value = "/convert/weather", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String weather(@RequestBody final JSONConverter model) {
        final JSONConverter converter = weatherBO.findWeather(model.getCity(), model.getUnit());
        return new Gson().toJson(converter);
    }

    @RequestMapping(value = "/convert/currency", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String currency(@RequestBody final JSONConverter model) {
        final JSONConverter converter = currencyBO.convertCurrency(model.getCurrencyFrom(), model.getCurrencyTo());
        return new Gson().toJson(converter);
    }

}
