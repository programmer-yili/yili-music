package com.bilitech.yilimusic.exception;

public enum ExceptionType {
    FORBIDDEN(403, "无权操作");

    private final Integer code;

    private final String message;


    ExceptionType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    }
