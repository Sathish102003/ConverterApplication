package com.converter.business;
import com.converter.domain.web.JSONConverter;

public interface CurrencyBO {

    JSONConverter convertCurrency(final String currencyFrom, final String currencyTo);

}
