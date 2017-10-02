package com.convert.persistence;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.converter.domain.persistence.Currency;
import com.converter.domain.persistence.CurrencyCode;

@Entity
@Table(name = "CURRENCY")
@SequenceGenerator(name = "currency_seq", sequenceName = "CURRENCY_SEQ")
@NamedQuery(name = "getCurrency", query = "SELECT e FROM CurrencyImpl e WHERE e.fromCurrencyCode=:fromCurrencyCode and e.toCurrencyCode=:toCurrencyCode order by e.conversionDate desc")
public class CurrencyImpl implements Currency {

    @Id @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_seq")
    private long id;

    @Column(name = "FROM_CURRENCY_CODE")
    @Enumerated(value = EnumType.STRING)
    private CurrencyCode fromCurrencyCode;

    @Column(name = "TO_CURRENCY_CODE")
    @Enumerated(value = EnumType.STRING)
    private CurrencyCode toCurrencyCode;

    @Column(name = "CONVERSION_RATE")
    private BigDecimal conversionRate;

    @Column(name = "CONVERSION_DATE") @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime conversionDate;

    public DateTime getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(final DateTime conversionDate) {
        this.conversionDate = conversionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public CurrencyCode getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(final CurrencyCode fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
    }

    public CurrencyCode getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(final CurrencyCode toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(final BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

}
