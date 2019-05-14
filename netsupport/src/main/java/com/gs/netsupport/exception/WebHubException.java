package com.gs.netsupport.exception;

/**
 * @author husky
 * create on 2019-05-14-13:46
 * webhub的异常
 */
public class WebHubException extends RuntimeException {

    private String code;

    public WebHubException(String message, String code) {
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
