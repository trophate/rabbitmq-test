package com.trophate.rabbitmqtest.result;

public class Result {

    /**
     * 状态码
     */
    private int code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 成功
     *
     * @return Result
     */
    public static Result success() {
        return new Result().setCode(DefaultResult.SUCCESS.getCode()).setMessage(DefaultResult.SUCCESS.getMessage());
    }

    /**
     * 失败
     *
     * @return Result
     */
    public static Result fail() {
        return new Result().setCode(DefaultResult.FAIL.getCode()).setMessage(DefaultResult.FAIL.getMessage());
    }
}
