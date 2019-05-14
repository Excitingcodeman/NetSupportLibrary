package com.gs.netsupport.exception;

import com.google.gson.JsonParseException;
import org.json.JSONException;
import retrofit2.HttpException;

import javax.net.ssl.SSLHandshakeException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

/**
 * @author husky
 * create on 2019-05-14-13:49
 */
public class MyConsumerThrowable {

    public static void handlingException(Throwable throwable) {
        if (null == throwable) {
            return;
        }
        if (throwable instanceof SocketTimeoutException
                || throwable instanceof ConnectException
                || throwable instanceof UnknownHostException) {
            //连接失败
        } else if (throwable instanceof HttpException) {
            //网络错误
        } else if (throwable instanceof UnknownServiceException) {
            //服务器未知错误
        } else if (throwable instanceof JsonParseException
                || throwable instanceof JSONException
                || throwable instanceof android.net.ParseException
                || throwable instanceof java.text.ParseException) {
            //解析错误
        } else if (throwable instanceof SSLHandshakeException) {
            //证书错误
        } else if (throwable instanceof ApiException) {
            //接口错误
        } else if (throwable instanceof TokenException) {
           //token错误
        } else if (throwable instanceof WebHubException) {
            // webtoken错误
        } else {
            //未知的错误

        }
    }
}
