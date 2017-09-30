package com.converter.domain;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TemperatureUnitTest {

    @Test
    public void fromString() throws Exception {
        assertThat(TemperatureUnit.fromString("kelvin"), is(TemperatureUnit.Kelvin));
    }

    @Test
    public void getCode() throws Exception {
        assertThat(TemperatureUnit.Kelvin.getCode(), is("kelvin"));
    }

}