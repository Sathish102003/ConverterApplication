package com.converter.domain.service;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class CurrentWeather {

    @JsonProperty("temp")
    private Double temperature;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty("temp_min")
    private Integer minimumTemperature;
    @JsonProperty("temp_max")
    private Integer maximumTemperature;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(final Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(final Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(final Integer humidity) {
        this.humidity = humidity;
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
