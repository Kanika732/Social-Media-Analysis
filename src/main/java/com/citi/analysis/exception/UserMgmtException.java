package com.citi.analysis.exception;

import lombok.Data;

@Data
public class UserMgmtException extends Exception {

    private Integer statusCode;
    private String statusMessage;

    public UserMgmtException(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public UserMgmtException(String message, Integer statusCode, String statusMessage) {
        super(message);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public UserMgmtException(String message, Throwable cause, Integer statusCode, String statusMessage) {
        super(message, cause);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public UserMgmtException(Throwable cause, Integer statusCode, String statusMessage) {
        super(cause);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public UserMgmtException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer statusCode, String statusMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
