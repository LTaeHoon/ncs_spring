-- goodsItem.sql

drop tabel goodsItem purge;

create table goodsItem(
item_id int primary key      /* 상품id */
,item_name varchar(20) not null  /* 상품명 */
,item_price int not null     /* 상품가격 */
,item_des varchar(200)       /* 상품설명 */
,item_pic varchar(20)        /* 상품이미지 */
);

insert into GOODSITEM 
values(1, '냉장고',850000,'S사 최고사양 최고 판매율','img01.jpg');
insert into GOODSITEM 
values(2, '세탁기',650000,'L사 최고사양 최고 판매율','img02.jpg');
insert into GOODSITEM 
values(3, 'HDTV',1850000,'K사 최고사양 최고 판매율','img03.jpg');
insert into GOODSITEM 
values(4, '세척기',500000,'M사 최고사양 최고 판매율','img04.jpg');
insert into GOODSITEM 
values(5, '전자레인지',450000,'H사 최고사양 최고 판매율','img05.jpg');

SELECT * FROM GOODSITEM;

commit work;




