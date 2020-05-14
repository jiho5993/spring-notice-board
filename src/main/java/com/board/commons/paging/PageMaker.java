package com.board.commons.paging;

public class PageMaker {

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;

    private Criteria criteria;

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    private void calcData() {

        endPage = (int)(Math.ceil(criteria.getPage() / (double)displayPageNum) * displayPageNum);

        startPage = (endPage - displayPageNum) + 1;

        int tmpEndPage = (int)(Math.ceil(totalCount / (double)criteria.getPerPageNum()));

        if(endPage > tmpEndPage) {
            endPage = tmpEndPage;
        }

        prev = startPage == 1 ? false : true;

        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
    }
}
