package com.zxk175.ssm.dto.web;

/**
 * Created by zxk175 on 2017/2/24.
 */
public class ResponseVo {
    private int code;
    private Object data;
    private String message;

    public ResponseVo() {
    }

    public ResponseVo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseVo(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
