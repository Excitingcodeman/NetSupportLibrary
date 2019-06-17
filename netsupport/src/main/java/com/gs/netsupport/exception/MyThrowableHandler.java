package com.gs.netsupport.exception;

/**
 * @author husky
 * create on 2019-06-17-14:43
 */
public interface MyThrowableHandler {
    /**
     * 连接超时  连接错误
     *
     * @param throwable
     */
    void connectException(Throwable throwable);

    /**
     * http错误
     *
     * @param throwable Throwable
     */
    void httpException(Throwable throwable);

    /**
     * 解析错误
     *
     * @param throwable Throwable
     */
    void parseException(Throwable throwable);

    /**
     * 服务器位置错误
     *
     * @param throwable Throwable
     */
    void unknownServiceException(Throwable throwable);

    /**
     * 证书错误
     *
     * @param throwable Throwable
     */
    void sSLHandshakeException(Throwable throwable);

    /**
     * api异常
     *
     * @param throwable ApiException
     */
    void apiException(ApiException throwable);

    /**
     * token异常
     *
     * @param throwable TokenException
     */
    void tokenException(TokenException throwable);

    /**
     * webhub异常
     *
     * @param throwable WebHubException
     */
    void webHubException(WebHubException throwable);

    /**
     * 未知的错误
     *
     * @param throwable Throwable
     */
    void unCatch(Throwable throwable);
}
