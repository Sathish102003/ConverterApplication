package com.convert.service;
public interface ConverterClient<I, O> {

    O convert(final I request);
}
