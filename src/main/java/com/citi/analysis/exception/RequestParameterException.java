package com.citi.analysis.exception;

import lombok.Data;

@Data
public class RequestParameterException extends RuntimeException{

    private String statusCode;
    private String statusMessage;

    public RequestParameterException(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public RequestParameterException(String message, String statusCode, String statusMessage) {
        super(message);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public RequestParameterException(String message, Throwable cause, String statusCode, String statusMessage) {
        super(message, cause);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public RequestParameterException(Throwable cause, String statusCode, String statusMessage) {
        super(cause);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public RequestParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String statusCode, String statusMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
