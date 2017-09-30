package com.converter.domain;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum TemperatureUnit {

    Celsius("degreeCelsius"),

    Fahrenheit("degreeFahrenheit"),

    Rankine("degreeRankine"),

    Reaumur("degreeReaumur"),

    Kelvin("kelvin");

    static final Map<String, TemperatureUnit> STRING_TO_ENUM;
    private final String code;

    public static TemperatureUnit fromString(final String code) {
        return STRING_TO_ENUM.get(code);
    }

    TemperatureUnit(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    static {
        STRING_TO_ENUM = new HashMap<>();
        for (TemperatureUnit unit : values()) {
            STRING_TO_ENUM.put(unit.getCode(), unit);
        }
    }

}
