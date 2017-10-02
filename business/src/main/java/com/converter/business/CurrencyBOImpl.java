package com.converter.business;
import java.math.BigDecimal;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.tempuri.GetConversionRate;
import org.tempuri.GetConversionRateResponse;

import com.convert.persistence.CurrencyDO;
import com.convert.persistence.CurrencyImpl;
import com.convert.service.ConverterClient;
import com.converter.domain.persistence.Currency;
import com.converter.domain.persistence.CurrencyCode;
import com.converter.domain.web.JSONConverter;

@Component
public class CurrencyBOImpl implements CurrencyBO {

    private static final DateTime NOW = DateTime.now();
    @Resource
    private ConverterClient<GetConversionRate, GetConversionRateResponse> converterClient;

    @Resource
    private CurrencyDO currencyDO;

    @Override
    @Transactional(value = "convertTxManager")
    public JSONConverter convertCurrency(final String currencyFrom, final String currencyTo) {
        final Currency currency =
                currencyDO.getCurrency(CurrencyCode.valueOf(currencyFrom), CurrencyCode.valueOf(currencyTo));
        if (NOW.minusMinutes(30).isBefore(currency.getConversionDate())) {
            return getJsonConverter(currencyFrom, currencyTo, currency.getConversionRate());
        }

        final GetConversionRateResponse response = getGetConversionRateResponse(currencyFrom, currencyTo);
        insertCurrency(currencyFrom, currencyTo, response.getGetConversionRateResult());
        return getJsonConverter(currencyFrom, currencyTo, response.getGetConversionRateResult());
    }

    private GetConversionRateResponse getGetConversionRateResponse(final String currencyFrom, final String currencyTo) {
        final GetConversionRate request = new GetConversionRate();
        request.setCurrencyFrom(currencyFrom);
        request.setCurrencyTo(currencyTo);
        request.setRateDate(NOW);
        return converterClient.convert(request);
    }

    private JSONConverter getJsonConverter(final String currencyFrom, final String currencyTo,
                                           final BigDecimal conversionRate) {
        final JSONConverter jsonConverter = new JSONConverter();
        jsonConverter.setConversionRate(conversionRate);
        jsonConverter.setCurrencyFrom(currencyFrom);
        jsonConverter.setCurrencyTo(currencyTo);
        return jsonConverter;
    }

    private void insertCurrency(final String currencyFrom, final String currencyTo,
                                final BigDecimal conversionRate) {
        final CurrencyImpl currency = new CurrencyImpl();
        currency.setConversionDate(NOW);
        currency.setFromCurrencyCode(CurrencyCode.valueOf(currencyFrom));
        currency.setToCurrencyCode(CurrencyCode.valueOf(currencyTo));
        currency.setConversionRate(conversionRate);
        currencyDO.create(currency);
    }
}
