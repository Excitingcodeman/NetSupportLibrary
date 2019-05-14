package com.gs.netsupport;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * @author husky
 * create on 2019-05-14-13:37
 */
public class BaseResponse implements Serializable {
    private String code;
    private String msg;
    private String respCode;
    private String memo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


    public String getResultCode() {
        return (TextUtils.isEmpty(code)) ? respCode : code;
    }

    public String getResultMessage() {
        return (TextUtils.isEmpty(memo)) ? msg : memo;
    }
}
