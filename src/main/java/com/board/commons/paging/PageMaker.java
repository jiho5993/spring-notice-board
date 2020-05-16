package com.board.commons.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    public String makeQuery(int page) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pePageNum", criteria.getPerPageNum())
                .build();

        return uriComponents.toUriString();
    }

    public String makeSearch(int page) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", criteria.getPerPageNum())
                .queryParam("searchType", ((SearchCriteria)criteria).getSearchType())
                .queryParam("keyword", encoding(((SearchCriteria)criteria).getKeyword()))
                .build();

        return uriComponents.toUriString();
    }

    public String encoding(String keyword) {
        if(keyword == null || keyword.trim().length() == 0) {
            return "";
        }

        try {
            return URLEncoder.encode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
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
}
