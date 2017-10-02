package com.converter.domain.persistence;
import java.math.BigDecimal;

import org.joda.time.DateTime;

public interface Currency {

    DateTime getConversionDate();

    long getId();

    CurrencyCode getFromCurrencyCode();

    CurrencyCode getToCurrencyCode();

    BigDecimal getConversionRate();

}
