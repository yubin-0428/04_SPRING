-- 2��° �ֹ�
insert into order_t values(3333,'����Ư���� ������ ������ 136 ���̺�Ÿ�� 2,3��','������','010-1111-1111','����غ���','2022-06-29','1');

insert into detail values(3333,'2','2','bowls05');

commit;

delete from detail where o_num = 3333;

delete from order_t where o_num = 3333;

commit;

-- 3���� �ֹ�
insert into order_t values(4444,'����Ư���� ������ ������ 136 ���̺�Ÿ�� 2,3��','������','010-1111-1111','����غ���','2022-06-29','1');
insert into detail values(4444,'2','2','bowls10');

-- 4��° �ֹ�
insert into order_t values(5555,'����Ư���� ������ ������ 136 ���̺�Ÿ�� 2,3��','������','010-1111-1111','����غ���','2022-06-29','1');
insert into detail values(5555,'2','2','plate01');

-- 5��° �ֹ�
insert into order_t values(6666,'����Ư���� ������ ������ 136 ���̺�Ÿ�� 2,3��','������','010-1111-1111','����غ���','2022-06-29','1');
insert into detail values(6666,'2','2','glass08');