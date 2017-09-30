package com.convert.service.exception;
/**
 * Exception Class for Create Update Facility service errors.
 */
public class ConverterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param msg the exception message.
     */
    public ConverterException(String msg) {
        super(msg);
    }
}
