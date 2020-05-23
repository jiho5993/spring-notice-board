package com.board.reply;

import com.board.commons.paging.Criteria;
import com.board.reply.domain.ReplyVO;
import com.board.reply.persistence.ReplyDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ReplyDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);

    @Inject
    private ReplyDAO replyDAO;

    @Test
    public void testReplyCreate() throws Exception {
        for(int i=1; i<=100; i++) {
            ReplyVO replyVO = new ReplyVO();
            replyVO.setArticleNo(58);
            replyVO.setReplyText(i + "번째 댓글입니다.");
            replyVO.setReplyWriter("user0" + (i%10));
            replyDAO.create(replyVO);
        }
    }

    @Test
    public void testReplyList() throws Exception {
        logger.info(replyDAO.list(58).toString());
    }

    @Test
    public void testReplyUpdate() throws Exception {
        ReplyVO replyVO = new ReplyVO();
        replyVO.setArticleNo(58);
        replyVO.setReplyText("2번째 댓글 수정...");
        replyDAO.update(replyVO);
    }

    @Test
    public void testReplyDelete() throws Exception {
        replyDAO.delete(58);
    }

    @Test
    public void testReplyPaging() throws Exception {
        Criteria criteria = new Criteria();
        criteria.setPerPageNum(20);
        criteria.setPage(5);

        List<ReplyVO> replies = replyDAO.listPaging(58, criteria);

        for(ReplyVO reply : replies) {
            logger.info(reply.getReplyNo() + " : " + reply.getReplyText());
        }
    }

}
