package com.converter.domain;
public class TemperatureVO {

    private double value;

    private TemperatureUnit fromUnit;

    private TemperatureUnit toUnit;

    private double result;

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public TemperatureUnit getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(final String fromUnit) {
        this.fromUnit = TemperatureUnit.fromString(fromUnit);
    }

    public TemperatureUnit getToUnit() {
        return toUnit;
    }

    public void setToUnit(final String toUnit) {
        this.toUnit = TemperatureUnit.fromString(toUnit);
    }

    public double getResult() {
        return result;
    }

    public void setResult(final double result) {
        this.result = result;
    }
}
