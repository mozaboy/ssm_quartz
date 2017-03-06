package com.zxk175.ssm.dto;

/**
 * Created by zxk175 on 2017/2/27.
 */
public class ExceptionVo {
    private int code;
    private String exType;
    private String exMsg;

    public ExceptionVo() {
    }

    public ExceptionVo(int code, String exType) {
        this.code = code;
        this.exType = exType;
    }

    public ExceptionVo(int code, String exType, String exMsg) {
        this.code = code;
        this.exType = exType;
        this.exMsg = exMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    @Override
    public String toString() {
        return "ExceptionVo{" +
                "code=" + code +
                ", exType='" + exType + '\'' +
                ", exMsg='" + exMsg + '\'' +
                '}';
    }
}
