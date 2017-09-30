package com.converter.rest.model;

public class JSONConverter {

    private String city;
    private String unit;
    private Double temperature;
    private Integer minimumTemperature;
    private Integer maximumTemperature;

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

}
