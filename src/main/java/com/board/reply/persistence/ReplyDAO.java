package com.board.reply.persistence;

import com.board.commons.paging.Criteria;
import com.board.reply.domain.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    List<ReplyVO> list(Integer articleNo) throws Exception;

    void create(ReplyVO replyVO) throws Exception;

    void update(ReplyVO replyVO) throws Exception;

    void delete(Integer replyNo) throws Exception;

    List<ReplyVO> listPaging(Integer articleNo, Criteria criteria) throws Exception;

    int countReply(Integer articleNo) throws Exception;

    int getArticleNo(Integer replyNo) throws Exception;

}
