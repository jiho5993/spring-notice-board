-- 게시판 테이블
create table tbl_article (
    article_no int not null auto_increment,     -- 게시글 번호
    title varchar(200) not null,                -- 게시글 제목
    content text null,                          -- 게시글 내용
    writer varchar(50) not null,                -- 게시글 작성자
    regdate timestamp not null default now(),   -- 게시글 등록 시간
    viewcnt int default 0,                      -- 게시글 조회 수
    primary key (article_no)                    -- 게시글 기본키
)