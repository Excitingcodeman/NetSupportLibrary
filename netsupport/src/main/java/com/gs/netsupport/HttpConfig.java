package com.gs.netsupport;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * @author husky
 * create on 2019-05-14-13:44
 */
public class HttpConfig {
    /**
     * 成功的返回码
     */
    public static String SUCCESS_CODE = "000000";
    /**
     * 连接超时
     */
    public static long CONNECT_TIMEOUT = 8;
    /**
     * 数据读取超时
     */
    public static long READ_TIMEOUT = 8;
    /**
     * 数据写入超时
     */
    public static long WRITE_TIMEOUT = 8;


    public static OkHttpClient.Builder getBuiler() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
    }
}
