package com.demo.util;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */
public class PageBean<T> implements Serializable{
    private int pageSize;
    private int currPage;

    //总记录数
    private long total;

    private long pageCount;

    private List<T> result;

    private boolean isFirstPage = false;
    private boolean isLastPage = false;

    public PageBean(){

    }

    public PageBean(List<T> list){
        if (list instanceof Page) {
            Page page = (Page) list;
            this.currPage = page.getNumber();
            this.pageSize = page.getSize();

            this.pageCount = page.getTotalPages();
            this.result = list;
            this.total = page.getNumberOfElements();
        } else if (list instanceof Collection) {
            this.currPage = 1;
            this.pageSize = list.size();

            this.pageCount = 1;
            this.result = list;
            this.total = list.size();
        }
        if (list instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = (currPage == 1);
        isLastPage = (pageSize == pageCount);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", total=" + total +
                ", pageCount=" + pageCount +
                ", result=" + result +
                ", isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                '}';
    }
}
