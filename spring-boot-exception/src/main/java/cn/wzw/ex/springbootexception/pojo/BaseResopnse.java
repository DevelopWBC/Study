package cn.wzw.ex.springbootexception.pojo;

/**
 * @Author Wangzhiwen
 * @ClassName BaseResopnse
 * @Description
 * @Date 2019/6/27 13:44
 * @Version 1.0
 */
public class BaseResopnse {
    /*响应码*/
    private Integer code;
    /*信息*/
    private String msg;
    /*响应数据*/
    private Object data;
    /*分页数据*/
    private PageEntity pageEntity;

    public BaseResopnse() {
    }

    public BaseResopnse(Integer code, String msg, Object data, PageEntity pageEntity) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pageEntity = pageEntity;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PageEntity getPageEntity() {
        return pageEntity;
    }

    public void setPageEntity(PageEntity pageEntity) {
        this.pageEntity = pageEntity;
    }
}
