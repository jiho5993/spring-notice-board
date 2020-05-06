package com.board.article;

import com.board.article.controller.ArticleController;
import com.board.article.domain.ArticleVO;
import com.board.article.persistence.ArticleDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testCreate() throws Exception {

        ArticleVO article = new ArticleVO();
        article.setTitle("test title");
        article.setContent("test content");
        article.setWriter("test writer");
        articleDAO.create(article);
    }

    @Test
    public void testRead() throws Exception {
        logger.info(articleDAO.read(104).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        ArticleVO article = new ArticleVO();
        article.setArticleNo(1);
        article.setTitle("new title");
        article.setContent("new content");
        articleDAO.update(article);
    }

    @Test
    public void testDelete() throws Exception {
        articleDAO.delete(1);
    }

}
