package cn.wzw.ex.springbootexception.pojo;
/**
  *@author Wangzhiwen
  *@description
  *@date 2019/6/27 14:29
  *@param
  *@return
*/
public enum BaseResponseCode {
    /*系统通用响应码*/
    SUCCESS(0,"操作成功"),
    ERROR(2000,"服务器内部错误"),
    PARAMS_ERROR(1000,"参数错误");

    private Integer code;
    private String msg;

    BaseResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    BaseResponseCode(Integer code) {
        this.code = code;
    }

    BaseResponseCode() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
