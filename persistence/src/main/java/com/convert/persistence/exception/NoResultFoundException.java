package com.convert.persistence.exception;
public class NoResultFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param msg the exception message.
     */
    public NoResultFoundException(String msg) {
        super(msg);
    }
}
