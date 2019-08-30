-- 커피전문점
DROP SCHEMA IF EXISTS ncs_product;

-- 커피전문점
CREATE SCHEMA ncs_product;

-- 제품
CREATE TABLE ncs_product.product (
	code CHAR(4)     NOT NULL COMMENT '제품코드', -- 제품코드
	name VARCHAR(20) NULL     COMMENT '제품명' -- 제품명
)
COMMENT '제품';

-- 제품
ALTER TABLE ncs_product.product
	ADD CONSTRAINT PK_product -- 제품 기본키
		PRIMARY KEY (
			code -- 제품코드
		);

-- 판매현황
CREATE TABLE ncs_product.sale (
	no          INT     NOT NULL COMMENT '번호', -- 번호
	code        CHAR(4) NULL     COMMENT '제품코드', -- 제품코드
	price       INT     NULL     COMMENT '가격', -- 가격
	sale_cnt    INT     NULL     COMMENT '판매량', -- 판매량
	margin_rate INT     NULL     COMMENT '마진율' -- 마진율
)
COMMENT '판매현황';

-- 판매현황
ALTER TABLE ncs_product.sale
	ADD CONSTRAINT PK_sale -- 판매현황 기본키
		PRIMARY KEY (
			no  -- 번호
		);

-- 상세판매현황
CREATE TABLE ncs_product.sale_detail (
	no         INT NULL COMMENT '번호', -- 번호
	sale_price INT NULL COMMENT '판매금액', -- 판매금액
	add_tax    INT NULL COMMENT '부가세액', -- 부가세액
	sup_price  INT NULL COMMENT '공급가액', -- 공급가액
	mar_price  INT NULL COMMENT '마진액' -- 마진액
)
COMMENT '상세판매현황';

-- 판매현황
ALTER TABLE ncs_product.sale
	ADD CONSTRAINT FK_product_TO_sale -- 제품 -> 판매현황
		FOREIGN KEY (
			code -- 제품코드
		)
		REFERENCES ncs_product.product ( -- 제품
			code -- 제품코드
		);

-- 상세판매현황
ALTER TABLE ncs_product.sale_detail
	ADD CONSTRAINT FK_sale_TO_sale_detail -- 판매현황 -> 상세판매현황
		FOREIGN KEY (
			no  -- 번호
		)
		REFERENCES ncs_product.sale ( -- 판매현황
			no  -- 번호
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
	select * , greatest( @rank := if(@score = if(isSalePrice, 판매액, 마진액), @rank, @rank + 1), 
	least(0, @score := if(isSalePrice,판매액,마진액)) ) as rank 
	from 
		(select no, s.code code, name, price 가격, sale_cnt 판매수량, @saleprice := price*sale_cnt 판매액, @addtax := ceil(@saleprice/11) 부가세액, 
			@supprice := @saleprice - @addtax 공급가액, margin_rate 마진율, @marPrice := round(@supprice * (margin_rate/100)) 마진액
			from sale s join product p on s.code = p.code ) t 
	order by if(isSalePrice,판매액,마진액) desc;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE ncs_product.proc_sum () 
begin 
	select sum(@saleprice:=price*salecnt) 판매액, 
		sum(@addtax := ceil(@saleprice/11)) 부가세액,
		sum(@supprice := @saleprice - @addtax) 공급가액, 
		sum(@marPrice := round(@supprice * (marginrate/100))) 마진액 
	from sale;
END$$
DELIMITER ;



insert into product 
values  ('A001', '아메리카노'),
		('A002', '카푸치노'),
		('A003', '헤이즐넛'),
		('A004', '에스프레소'),
		('B001', '딸기쉐이크'),
		('B002', '후르츠와인'),
		('B003', '팥빙수'),
		('B004', '아이스초코');
	
select * from product;

insert into sale values (1, 'A001', 4500, 150, 10);
select * from sale;
select * from sale_detail;
