package com.convert.persistence;

import java.util.List;

import com.convert.persistence.model.Currency;

public interface CurrencyDO {

    Currency getCurrency(final long id);

    void create(final Currency currency);

    List<Currency> getAllCurrencies();
}
