package com.convert.service;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.converter.domain.service.Weather;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConverterTestConfig.class })
public class WeatherClientTest {
    @Resource
    private WeatherClient weatherClient;

    @Test
    public void getWeather() throws Exception {
        final Weather weather = weatherClient.getWeather("Utrecht", "Metric");
        System.out.println(weather);
    }

}