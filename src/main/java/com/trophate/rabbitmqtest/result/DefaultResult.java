package com.trophate.rabbitmqtest.result;

public enum DefaultResult {

    /**
     * 成功
     */
    SUCCESS(1, "success"),
    /**
     * 失败
     */
    FAIL(-1, "fail");

    /**
     * 状态码
     */
    private final int code;
    /**
     * 消息
     */
    private final String message;

    DefaultResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
