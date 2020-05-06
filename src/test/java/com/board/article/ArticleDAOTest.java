package com.board.article;

import com.board.article.domain.ArticleVO;
import com.board.article.persistence.ArticleDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTest {

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testCreate() throws Exception {

        Date date = new Date();

        ArticleVO article = new ArticleVO();
        article.setTitle("test title");
        article.setContent("test content");
        article.setWriter("test writer");
        article.setRegDate(date);
        articleDAO.create(article);
    }

    @Test
    public void testRead() throws Exception {
        System.out.println(articleDAO.read(1).toString());
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
