--Å×ÀÌºí »ý¼º
create table MyWebUser_t(
    id varchar2(20) primary key,
    pwd varchar2(20),
    name varchar2(10),
    email varchar2(50),
    joinDate date default sysdate
);

select * from mywebuser_t;

create table blog_t(
    blogNum int primary key,
    Title varchar2(20),
    Contents varchar2(500),
    writeUser varchar2(10),
    writeDate date default sysdate,
    writerID varchar(20)
);

CREATE SEQUENCE blogIndex
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
NOCACHE;

select * from blog_t;

select * from ( select ROWNUM NUM, blog_t.* from blog_t order by blogNum desc ) 
where NUM between 1 and 5;

commit;




