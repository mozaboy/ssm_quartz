package com.zxk175.ssm.exception;

import java.io.Serializable;

/**
 * Created by zxk175 on 2017/2/20.
 */
public class ParameterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

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
