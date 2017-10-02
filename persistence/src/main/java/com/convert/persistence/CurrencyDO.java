package com.convert.persistence;

import com.convert.persistence.exception.NoResultFoundException;
import com.converter.domain.persistence.Currency;
import com.converter.domain.persistence.CurrencyCode;

public interface CurrencyDO {

    Currency getCurrency(final CurrencyCode fromCurrencyCode, final CurrencyCode toCurrencyCode)
            throws NoResultFoundException;

    void create(final Currency currency);

}
