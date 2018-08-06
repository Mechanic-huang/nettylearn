package org.hgz.httpclient.utils;

/**
 * @author baofan.li
 * @Description httpclient异常
 * @Copyright 2015 © anzhi.com
 * @Created 2015年7月6日 上午11:02:29
 */
public class HttpClientException extends BaseException {

    private static final long serialVersionUID = -324289254344816766L;


    /**
     * 从连接池取连接超时
     */
    public static final int CONNECTION_POOL_TIMEOUT_EXCEPTION = ERROR_CODE_HTTP_CLIENT + 1;
    /**
     * 响应失败
     */
    public static final int HTTP_RESPONSE_EXCEPTION = ERROR_CODE_HTTP_CLIENT + 2;
    /**
     * http协议异常
     */
    public static final int CLIENT_PROTOCOL_EXCEPTION = ERROR_CODE_HTTP_CLIENT + 3;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT_EXCEPTION = ERROR_CODE_HTTP_CLIENT + 4;
    /**
     * 没有http响应内容
     */
    public static final int NO_HTTP_RESPONSE_EXCEPTION = ERROR_CODE_HTTP_CLIENT + 5;

    /**
     * 其他http异常
     */
    public static final int OTHER_EXCEPTION = ERROR_CODE_HTTP_CLIENT + 99;


    public HttpClientException() {
        super(ERROR_CODE_HTTP_CLIENT);
    }

    public HttpClientException(String message) {
        super(ERROR_CODE_HTTP_CLIENT, message);
    }

    public HttpClientException(String message, Throwable e) {
        super(ERROR_CODE_HTTP_CLIENT, message, e);
    }

    public HttpClientException(int errorCode, String message, Throwable e) {
        super(errorCode, message, e);
    }

    public HttpClientException(int errorCode, Throwable e) {
        super(errorCode, e);
    }


}
