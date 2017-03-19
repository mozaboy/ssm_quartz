package com.zxk175.ssm.exception;

import java.io.Serializable;

/**
 * Created by zxk175 on 2017/2/20.
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
