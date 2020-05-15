package com.board.article;

import com.board.article.controller.ArticleController;
import com.board.article.domain.ArticleVO;
import com.board.article.persistence.ArticleDAO;
import com.board.commons.paging.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testCreate() throws Exception {
        for(int i=1; i<=57; i++) {
            ArticleVO articleVO = new ArticleVO();
            Date date = new Date();
            articleVO.setTitle(i + "번째 글 제목입니다.");
            articleVO.setContent(i + "번째 글 내용입니다.");
            articleVO.setRegDate(date);
            articleVO.setWriter("user0" + (i%10));

            articleDAO.create(articleVO);
        }
    }

    @Test
    public void testListPaging() throws Exception {
        int page = 3;

        List<ArticleVO> articles = articleDAO.listPaging(page);

        for(ArticleVO article : articles) {
            logger.info(article.toString());
        }
    }

    @Test
    public void testListCriteria() throws Exception {
        Criteria criteria = new Criteria();
        criteria.setPage(3);
        criteria.setPerPageNum(20);

        List<ArticleVO> articles = articleDAO.listCriteria(criteria);

        for(ArticleVO article : articles) {
            logger.info(article.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setContent("updated1");
        articleVO.setTitle("updated114324");
        articleVO.setArticleNo(1000);
        articleDAO.update(articleVO);
        logger.info(articleDAO.read(1000).toString());
    }

}
