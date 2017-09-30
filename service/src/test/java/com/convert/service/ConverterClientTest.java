package com.convert.service;
import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tempuri.GetConversionRate;
import org.tempuri.GetConversionRateResponse;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConverterTestConfig.class })
public class ConverterClientTest {

    @Resource
    private ConverterClient<GetConversionRate, GetConversionRateResponse> converterClient;

    @Test
    public void convert() throws Exception {
        final GetConversionRate request = new GetConversionRate();
        request.setCurrencyFrom("EUR");
        request.setCurrencyTo("INR");
        request.setRateDate(DateTime.now());
        final GetConversionRateResponse response = converterClient.convert(request);
        assertNotNull(response);
    }

}