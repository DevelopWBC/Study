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
    /*要打印的总页数*/
    private int totalPages;
    /*总记录数*/
    private int recordCount;
    /*分页数据*/
    private List<T> Data;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }
}
