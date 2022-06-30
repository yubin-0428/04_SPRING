-- 2번째 주문
insert into order_t values(3333,'서울특별시 마포구 서강로 136 아이비타워 2,3층','최유빈','010-1111-1111','배송준비중','2022-06-29','1');

insert into detail values(3333,'2','2','bowls05');

commit;

delete from detail where o_num = 3333;

delete from order_t where o_num = 3333;

commit;

-- 3번쨰 주문
insert into order_t values(4444,'서울특별시 마포구 서강로 136 아이비타워 2,3층','최유빈','010-1111-1111','배송준비중','2022-06-29','1');
insert into detail values(4444,'2','2','bowls10');

-- 4번째 주문
insert into order_t values(5555,'서울특별시 마포구 서강로 136 아이비타워 2,3층','최유빈','010-1111-1111','배송준비중','2022-06-29','1');
insert into detail values(5555,'2','2','plate01');

-- 5번째 주문
insert into order_t values(6666,'서울특별시 마포구 서강로 136 아이비타워 2,3층','최유빈','010-1111-1111','배송준비중','2022-06-29','1');
insert into detail values(6666,'2','2','glass08');