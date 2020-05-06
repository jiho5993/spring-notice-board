-- 게시판 테이블
CREATE TABLE tbl_article (
  article_no int NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  content text,
  writer varchar(50) NOT NULL,
  regdate timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  viewcnt int DEFAULT 0,
  PRIMARY KEY (article_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;