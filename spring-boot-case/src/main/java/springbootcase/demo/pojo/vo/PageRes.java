package springbootcase.demo.pojo.vo;

import java.util.List;

/**
 * @Author Wangzhiwen
 * @ClassName PageRes
 * @Description
 * @Date 2019/7/29 13:59
 * @Version 1.0
 */
public class PageRes<T> {
    private int page;
    private long size;
    private List<T> data;

    public PageRes() {
    }

    public PageRes(int page, long size, List<T> data) {
        this.page = page;
        this.size = size;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
