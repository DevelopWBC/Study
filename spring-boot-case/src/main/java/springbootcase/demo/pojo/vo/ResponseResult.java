package springbootcase.demo.pojo.vo;


/**
 * @Author Wangzhiwen
 * @ClassName ResponseResult
 * @Description：响应结果实体，
 * @Date 2019/7/1 13:19
 * @Version 1.0
 */
/*显示层对象，通常是 Web 向模板渲染引擎层传输的对象。*/
public class ResponseResult<T> {
    /*响应码*/
    private Integer code;
    /*信息*/
    private String msg;
    /*响应数据*/
    private Object data;
    /*分页数据*/
    private PageRes<T> pageRes;

    public ResponseResult() {
    }

    public ResponseResult(Integer code, String msg, Object data, PageRes<T> pageRes) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pageRes = pageRes;
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

    public PageRes<T> getPageRes() {
        return pageRes;
    }

    public void setPageRes(PageRes<T> pageRes) {
        this.pageRes = pageRes;
    }
}
