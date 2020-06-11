package com.wzw.test.springboottest.ssid;

/**
 * 商汤ssid响应体
 * @author Wangzhiwen
 */
public class Response<Data> {
    /** 响应码 */
    private String code;
    /** 提示信息 */
    private String msg;
    /** 响应体 */
    private Data data;
    /** 响应是否成功 */
    private boolean success;

    public Response() {
    }

    public Response(Data data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
