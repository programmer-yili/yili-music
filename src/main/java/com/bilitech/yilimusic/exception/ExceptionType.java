package com.bilitech.yilimusic.exception;

public enum ExceptionType {

    INNER_ERROR(500, "系统内部错误"),
    UNAUTHORIZED(401, "未登录"),
    BAD_REQUEST(400, "请求错误"),
    FORBIDDEN(403, "无权操作"),
    NOT_FOUND(404, "未找到"),
    USER_NAME_DUPLICATE(40001001, "用户名重复"),
    USER_NOT_FOUND(40401002, "用户不存在"),
    USER_PASSWORD_NOT_MATCH(40001003, "用户名或密码错误"),
    USER_NOT_ENABLED(50001001, "用户未启用"),
    USER_LOCKED(50001002, "用户被锁定"),
    MUSIC_NOT_FOUND(40402001, "歌曲不存在"),
    FILE_NOT_FOUND(40403001, "文件不存在"),
    FILE_NOT_PERMISSION(40303002, "当前用户无权限修改文件"),
    PLAYLIST_NOT_FOUND(40404001, "歌单不存在"),
    ARTIST_NOT_FOUND(40405001, "歌手不存在");


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
