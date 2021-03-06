package com.gs.netsupport.exception;

/**
 * @author husky
 * create on 2019-05-14-13:46
 * API的异常
 */
public class ApiException extends RuntimeException {

    private String code;

    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
