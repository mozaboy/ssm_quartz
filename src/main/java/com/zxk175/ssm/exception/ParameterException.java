package com.zxk175.ssm.exception;

/**
 * Created by zxk175 on 2017/2/20.
 */
public class ParameterException extends RuntimeException {

    public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
