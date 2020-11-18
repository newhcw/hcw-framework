package cn.hasfun.learn.springcloud.consumer.vo;

public class Result {

    private int code;

    private String msg;

    private Object data;

    private Result() {
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static Result success() {
        return success(null);
    }

    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    public static Result fail() {
        return fail(500, "fail");
    }

    public static Result fail(int code, String message) {
        return new Result(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
