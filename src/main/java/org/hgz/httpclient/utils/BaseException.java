package org.hgz.httpclient.utils;

public class BaseException extends RuntimeException {

    public static final int ERROR_CODE_HTTP_CLIENT = 1002 * 100;

    private final int errorCode;

    private String message;

    public BaseException(int errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public BaseException(int errorCode) {
        this.errorCode = errorCode;
    }



    public BaseException(int errorCode, String message, Throwable cause) {
        super(cause);
        this.message = message;
        this.errorCode = errorCode;

    }

    public BaseException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;

    }
}
