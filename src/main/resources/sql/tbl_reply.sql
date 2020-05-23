-- 댓글 테이블 생성
create table tbl_reply (
    reply_no int not null auto_increment,
    article_no int not null default 0,
    reply_text varchar(1000) not null,
    reply_writer varchar(50) not null,
    reg_date timestamp not null default now(),
    update_date timestamp not null default now(),
    primary key (reply_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 댓글 참조키 설정
alter table tbl_reply add constraint fk_article
foreign key (article_no) references tbl_article (article_no);