package com.converter.domain.web;

import java.math.BigDecimal;

public class JSONConverter {

    private String city;
    private String unit;
    private Double temperature;
    private Integer minimumTemperature;
    private Integer maximumTemperature;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversionRate;

    public String getUnit() {
        return unit;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(final Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(final Integer minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public Integer getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(final Integer maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(final String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(final String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(final BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }
}
