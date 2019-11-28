package cn.javabs.book.util;

import java.util.List;

/**
 * 分页
 */
public class Page {

    //记录的条数
    private List records;

    //每列要显示的条数
    private int pageSize = 3;

    //当前页面
    private int currentPage;

    //总页数
    private int totalPage;

    //上一页
    private int prePageNum;

    //下一页
    private int nextPageNum;

    //开始的索引
    private int startIndex;

    //总记录的条数
    private int totalRecord;

    //链接
    private String url;

    /**
     *
     * @param currentPage  当前页
     * @param totalRecord  总条数
     */
    public Page(int currentPage, int totalRecord) {
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        totalPage = totalRecord % pageSize  == 0  ?  totalRecord / pageSize  :  totalRecord / pageSize  + 1;
        startIndex = (currentPage - 1) * pageSize;
    }

    public List getRecords() {
        return records;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrePageNum() {
        //上一页 = 当前页面 - 1  要求大于0  才可以拥有 上一页  否则就是 1
        prePageNum = currentPage - 1  > 0  ?  currentPage - 1 : 1 ;
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public int getNextPageNum() {
        nextPageNum = currentPage + 1 > totalPage  ?  totalPage : currentPage + 1 ;
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
