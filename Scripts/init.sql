-- Ŀ��������
DROP SCHEMA IF EXISTS ncs_product;

-- Ŀ��������
CREATE SCHEMA ncs_product;

-- ��ǰ
CREATE TABLE ncs_product.product (
	code CHAR(4)     NOT NULL COMMENT '��ǰ�ڵ�', -- ��ǰ�ڵ�
	name VARCHAR(20) NULL     COMMENT '��ǰ��' -- ��ǰ��
)
COMMENT '��ǰ';

-- ��ǰ
ALTER TABLE ncs_product.product
	ADD CONSTRAINT PK_product -- ��ǰ �⺻Ű
		PRIMARY KEY (
			code -- ��ǰ�ڵ�
		);

-- �Ǹ���Ȳ
CREATE TABLE ncs_product.sale (
	no          INT     NOT NULL COMMENT '��ȣ', -- ��ȣ
	code        CHAR(4) NULL     COMMENT '��ǰ�ڵ�', -- ��ǰ�ڵ�
	price       INT     NULL     COMMENT '����', -- ����
	sale_cnt    INT     NULL     COMMENT '�Ǹŷ�', -- �Ǹŷ�
	margin_rate INT     NULL     COMMENT '������' -- ������
)
COMMENT '�Ǹ���Ȳ';

-- �Ǹ���Ȳ
ALTER TABLE ncs_product.sale
	ADD CONSTRAINT PK_sale -- �Ǹ���Ȳ �⺻Ű
		PRIMARY KEY (
			no  -- ��ȣ
		);

-- ���Ǹ���Ȳ
CREATE TABLE ncs_product.sale_detail (
	no         INT NULL COMMENT '��ȣ', -- ��ȣ
	sale_price INT NULL COMMENT '�Ǹűݾ�', -- �Ǹűݾ�
	add_tax    INT NULL COMMENT '�ΰ�����', -- �ΰ�����
	sup_price  INT NULL COMMENT '���ް���', -- ���ް���
	mar_price  INT NULL COMMENT '������' -- ������
)
COMMENT '���Ǹ���Ȳ';

-- �Ǹ���Ȳ
ALTER TABLE ncs_product.sale
	ADD CONSTRAINT FK_product_TO_sale -- ��ǰ -> �Ǹ���Ȳ
		FOREIGN KEY (
			code -- ��ǰ�ڵ�
		)
		REFERENCES ncs_product.product ( -- ��ǰ
			code -- ��ǰ�ڵ�
		);

-- ���Ǹ���Ȳ
ALTER TABLE ncs_product.sale_detail
	ADD CONSTRAINT FK_sale_TO_sale_detail -- �Ǹ���Ȳ -> ���Ǹ���Ȳ
		FOREIGN KEY (
			no  -- ��ȣ
		)
		REFERENCES ncs_product.sale ( -- �Ǹ���Ȳ
			no  -- ��ȣ
		) on delete cascade;

	
use ncs_product;

DELIMITER $$
create trigger tri_sale_insert_after_detail 
after insert on sale 
for each row 
begin 
	set @saleprice = new.price * new.sale_cnt, 
		@addtax = ceil(@saleprice/11), 
		@supprice = @saleprice - @addtax, 
		@marPrice = round(@supprice * (new.margin_rate/100));
	INSERT INTO sale_detail(no, sale_price, add_tax, sup_price, mar_price) VALUES(new.no, @saleprice, @addtax, @supprice, @marPrice); 
end $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE ncs_product.proc_order_price (in isSalePrice boolean) 
begin 
	set @score:=0, @rank:=0;
	select * , greatest( @rank := if(@score = if(isSalePrice, �Ǹž�, ������), @rank, @rank + 1), 
	least(0, @score := if(isSalePrice,�Ǹž�,������)) ) as rank 
	from 
		(select no, s.code code, name, price ����, sale_cnt �Ǹż���, @saleprice := price*sale_cnt �Ǹž�, @addtax := ceil(@saleprice/11) �ΰ�����, 
			@supprice := @saleprice - @addtax ���ް���, margin_rate ������, @marPrice := round(@supprice * (margin_rate/100)) ������
			from sale s join product p on s.code = p.code ) t 
	order by if(isSalePrice,�Ǹž�,������) desc;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE ncs_product.proc_sum () 
begin 
	select sum(@saleprice:=price*salecnt) �Ǹž�, 
		sum(@addtax := ceil(@saleprice/11)) �ΰ�����,
		sum(@supprice := @saleprice - @addtax) ���ް���, 
		sum(@marPrice := round(@supprice * (marginrate/100))) ������ 
	from sale;
END$$
DELIMITER ;



insert into product 
values  ('A001', '�Ƹ޸�ī��'),
		('A002', 'īǪġ��'),
		('A003', '�������'),
		('A004', '����������'),
		('B001', '���⽦��ũ'),
		('B002', '�ĸ�������'),
		('B003', '�Ϻ���'),
		('B004', '���̽�����');
	
select * from product;

insert into sale values (1, 'A001', 4500, 150, 10);
select * from sale;
select * from sale_detail;
