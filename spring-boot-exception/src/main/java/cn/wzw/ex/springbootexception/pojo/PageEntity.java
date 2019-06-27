package cn.wzw.ex.springbootexception.pojo;

import java.util.List;

/**
 * @Author Wangzhiwen
 * @ClassName PageEntity
 * @Description
 * @Date 2019/6/27 14:21
 * @Version 1.0
 */
public class PageEntity<T> {
    /*当前页*/
    private int page;
    /*总记录数*/
    private int total;
    /*分页数据*/
    private List<T> Data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }
}
