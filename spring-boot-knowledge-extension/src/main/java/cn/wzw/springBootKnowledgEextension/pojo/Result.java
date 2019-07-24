package cn.wzw.springBootKnowledgEextension.pojo;

import java.util.List;

/**
 * @Author Wangzhiwen
 * @ClassName Result
 * @Description
 * @Date 2019/7/23 15:14
 * @Version 1.0
 */
public class Result {
    private int totalPages;
    private int page;
    private List list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
