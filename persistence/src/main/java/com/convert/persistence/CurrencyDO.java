package com.convert.persistence;

import com.converter.domain.persistence.Currency;
import com.converter.domain.persistence.CurrencyCode;

public interface CurrencyDO {

    Currency getCurrency(final CurrencyCode fromCurrencyCode, final CurrencyCode toCurrencyCode);

    void create(final Currency currency);

}
