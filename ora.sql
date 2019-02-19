

DROP TABLE point_code purge;
DROP TABLE trade_info purge;
DROP TABLE item_status purge;
DROP TABLE chat purge;
DROP TABLE deal purge;
DROP TABLE likes purge;
DROP TABLE items purge;
DROP TABLE categorys purge;
DROP TABLE users purge;



create table USERS(
USER_ID VARCHAR2(7) NOT NULL,
USER_NICKNAME VARCHAR2(30) NOT NULL,
USER_NAME VARCHAR2(40) NOT NULL,
USER_ZIPCODE VARCHAR2(7) NOT NULL,
USER_PREFCODE NUMBER(2) NOT NULL,
USER_ADDRESS VARCHAR(80) NOT NULL,
USER_EMAIL VARCHAR2(30) NOT NULL,
USER_PASSWORD VARCHAR2(15) NOT NULL,
USER_INTRODUCTION VARCHAR2(300) default null,
USER_GOOD NUMBER(4) default 0,
USER_NORMAL NUMBER(4) default 0,
USER_BAD NUMBER(4) default 0,
USER_ALERT NUMBER(2) default 0,
USER_POINT number(8) default 0,
CONSTRAINT user1 PRIMARY KEY (USER_ID),
CONSTRAINT user2 unique(USER_EMAIL),
CONSTRAINT user3 check(REGEXP_like(USER_zipcode,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9]')),
CONSTRAINT user6 check(USER_email like  '%@%.%')
);
commit;


create table categorys(
category_name varchar2(30)NOT NULL,
category_code number(5)NOT NULL,
CONSTRAINT category1 PRIMARY KEY (category_code)
);
commit;


create table items(
item_id number(7)NOT NULL,
item_category number(5),
item_name varchar2(40) NOT NULL,
item_image1 varchar2(100) NOT NULL,
item_image2 varchar2(100) default null,
item_image3 varchar2(100)default null,
item_image4 varchar2(100)default null,
item_size number(5),
item_description varchar2(600) NOT NULL,
item_state number(1)NOT NULL,
item_shipping number(1),
item_postage number(1) NOT NULL,
item_Exhibitdate TIMESTAMP(0) default sysdate,
item_price number(8) NOT NULL, 
item_available number(1) default 0,
CONSTRAINT item1 PRIMARY KEY (item_id),
CONSTRAINT item16 FOREIGN KEY (item_category)REFERENCES categorys(category_code),
CONSTRAINT item3 check(item_state BETWEEN 1 AND 5),
CONSTRAINT item4 check(item_shipping BETWEEN 1 AND 2),
CONSTRAINT item5 check(item_postage BETWEEN 1 AND 7),
CONSTRAINT item6 check(item_price BETWEEN 1 AND 99999999),
CONSTRAINT item7 check(item_available BETWEEN 0 AND 1),
CONSTRAINT item12 check(item_size BETWEEN 0 AND 5)
);
commit;


create table likes(
likes_userid varchar2(7) NOT NULL,
likes_itemid number(5) NOT NULL,
likes_endisable number(1) default 0,
CONSTRAINT like1 PRIMARY KEY (likes_userid,likes_itemid),
CONSTRAINT like2 FOREIGN KEY (likes_userid)REFERENCES users(user_id),
CONSTRAINT like3 FOREIGN KEY (likes_itemid)REFERENCES items(item_id),
CONSTRAINT like4 check(likes_endisable BETWEEN 0 AND 1)
);
commit;

commit;
create table deal(
deal_id number(5) NOT NULL,
deal_amount number(8) NOT NULL,
deal_flag varchar2(7) ,
deal_commission number(8)NOT NULL,
deal_received number(8)NOT NULL,
deal_completiondate TIMESTAMP(0) default sysdate,
CONSTRAINT urikai1 FOREIGN KEY (deal_id)REFERENCES items(item_id),
CONSTRAINT urikai5 check(deal_amount BETWEEN 0 AND 99999999)
);

commit;

create table item_status(
istatus_id number(5) not null,
istatus_amount number(8) not null,
istatus_date timestamp(0) default sysdate,
istatus_flag number(1),
CONSTRAINT item_staus1 PRIMARY KEY (istatus_id),
CONSTRAINT item_staus2 FOREIGN KEY (istatus_id)REFERENCES items(item_id),
CONSTRAINT item_staus3 check(istatus_amount BETWEEN 0 AND 99999999),
CONSTRAINT item_staus6 check(istatus_flag BETWEEN 0 AND 6)
);
commit;


create table chat(
chat_itemid number(5)NOT NULL,
chat_userid varchar2(7),
chat_content varchar2(600)NOT NULL,
chat_date TIMESTAMP(0) default sysdate,
CONSTRAINT caht1 FOREIGN KEY (chat_userid)REFERENCES users(user_id),
CONSTRAINT caht2 FOREIGN KEY (chat_itemid)REFERENCES items(item_id)
);
commit;
create table trade_info(
tinfo_buyerid varchar2(7),
tinfo_salerid varchar2(7) not null,
tinfo_itemid number(5) not null,
CONSTRAINT trade_info1 PRIMARY KEY (tinfo_itemid),
CONSTRAINT trade_info2 FOREIGN KEY (tinfo_buyerid)REFERENCES users(user_id),
CONSTRAINT trade_info3 FOREIGN KEY (tinfo_salerid)REFERENCES users(user_id)
);
insert into trade_info(tinfo_buyerid,tinfo_salerid,tinfo_itemid)values();
commit;
create table point_code(
monye number(6),
code varchar(12),
CONSTRAINT point_code PRIMARY KEY (code)
);

create sequence userid
  increment by 1
  start with 1
  maxvalue 9999999
  minvalue 1
  cycle
  cache 3
  order;


commit;
insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password
)values(userid.nextval,'高橋','高橋','1234567',01,'abcdef','test1@gmail.com','test1');

insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password
)values('0000001','高橋','高橋','1234567',01,'abcdef','test1@gmail.com','test1');

insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password
)values(userid.nextva,'斎藤','斎藤','2345678',02,'bcdefg','test2@gmail.com','test2');

insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password
)values('0000003','鈴木','鈴木','3456789',03,'cdefgh','test3@gmail.com','test3');

insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password
)values('0000004','田中','田中','4567891',04,'defghi','test4@gmail.com','test4');

insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password
)values('0000005','伊藤','伊藤','5678912',05,'efghilm','test5@gmail.com','test5');

insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password
)values('9999999','Admin','Admin','9999999',01,'admin','admin@gmail.com','admin');

commit;

insert into categorys(category_name,category_code)values('チャージ',99999);
insert into categorys(category_name,category_code)values('レディース',1);
insert into categorys(category_name,category_code)values('メンズ',2);
insert into categorys(category_name,category_code)values('キッズ',3);
insert into categorys(category_name,category_code)values('インテリア',4);
insert into categorys(category_name,category_code)values('おもちゃ',5);
insert into categorys(category_name,category_code)values('コスメ',6);
insert into categorys(category_name,category_code)values('家電',7);
insert into categorys(category_name,category_code)values('スポーツ',8);
insert into categorys(category_name,category_code)values('ハンドメイド',9);
insert into categorys(category_name,category_code)values('チケット',10);
insert into categorys(category_name,category_code)values('自転車',11);
insert into categorys(category_name,category_code)values('その他',12);

commit;

---image1のみの商品が10個 Imageは（String型**.jpg）-------
insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00001,1,'キーホルダー','/image1.jpg','よい',1,3,900);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00002,2,'バック','/image1.jpg','ブランドのバック',2,4,1800);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00003,3,'おもちゃ','/image1.jpg','子供のおもちゃ',3,5,1000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00004,4,'食器','/image1.jpg','お皿',3,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00005,5,'カード','/image1.jpg','カードゲーム',1,1,1500);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00006,6,'リップ','/image1.jpg','リップ',1,4,200);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00007,7,'テレビ','/image1.jpg','テレビ',1,3,500000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00008,8,'シューズ','/image1.jpg','運動用のシューズ',1,3,3000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00009,9,'ネックレス','/image1.jpg','ハンドメイド',1,3,3500);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00010,10,'音楽','/image1.jpg','CD',1,3,4000);


------image1,2のみの商品が10個--------------------------------------------------
insert into items(item_id,item_category,item_name,item_image1,item_image2,item_description,item_state,item_postage,item_price)
values(00011,11,'自転車','/image1.jpg','/image1.jpg','ロードバイク',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_description,item_state,item_postage,item_price)
values(00012,12,'バック','/image1.jpg','/image1.jpg','ハンドメイド',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_description,item_state,item_postage,item_price)
values(00013,1,'帽子','/image1.jpg','/image1.jpg','ブランド',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_description,item_state,item_postage,item_price)
values(00014,2,'バック','/image1.jpg','/image1.jpg','ブランド',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_description,item_state,item_postage,item_price)
values(00015,4,'エプロン','/image1.jpg','/image1.jpg','ブランド',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_description,item_state,item_postage,item_price)
values(00016,9,'キーホルダー','/image1.jpg','/image1.jpg','ハンドメイド',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_size,item_description,item_state,item_postage,item_price)
values(00017,1,'ワンピース','/image1.jpg','/image1.jpg',0,'洋服',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_size,item_description,item_state,item_postage,item_price)
values(00018,1,'ワンピース','/image1.jpg','/image1.jpg',1,'洋服',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_size,item_description,item_state,item_postage,item_price)
values(00019,1,'ワンピース','/image1.jpg','/image1.jpg',2,'洋服',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_size,item_description,item_state,item_postage,item_price)
values(00020,1,'ワンピース','/image1.jpg','/image1.jpg',3,'洋服',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_size,item_description,item_state,item_postage,item_price)
values(00021,1,'ワンピース','/image1.jpg','/image1.jpg',4,'洋服',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_size,item_description,item_state,item_postage,item_price)
values(00022,1,'ワンピース','/image1.jpg','/image1.jpg',5,'洋服',4,5,1050);

commit;
------------1,2,3のみの商品が5個-----------
insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_description,item_state,item_postage,item_price)
values(00023,4,'ソファー','/image1.jpg','/image1.jpg','/image1.jpg','インテリア',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_description,item_state,item_postage,item_price)
values(00024,4,'テーブル','/image1.jpg','/image1.jpg','/image1.jpg','インテリア',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_description,item_state,item_postage,item_price)
values(00025,3,'おもちゃ','/image1.jpg','/image1.jpg','/image1.jpg','子供のおもちゃ',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_description,item_state,item_postage,item_price)
values(00026,3,'おむつ','/image1.jpg','/image1.jpg','/image1.jpg','赤ちゃん用',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_description,item_state,item_postage,item_price)
values(00027,1,'香水','/image1.jpg','/image1.jpg','/image1.jpg','ブランド',4,5,1050);

commit;
---------1,2,3,4の商品が5個----------------
insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_image4,item_description,item_state,item_postage,item_price)
values(00028,7,'カメラ','/image1.jpg','/image1.jpg','/image1.jpg','/image1.jpg','家電',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_image4,item_description,item_state,item_postage,item_price)
values(00029,2,'財布','/image1.jpg','/image1.jpg','/image1.jpg','/image1.jpg','ブランド',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_image4,item_description,item_state,item_postage,item_price)
values(00030,1,'時計','/image1.jpg','/image1.jpg','/image1.jpg','/image1.jpg','ブランド',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_image4,item_description,item_state,item_postage,item_price)
values(00031,4,'椅子','/image1.jpg','/image1.jpg','/image1.jpg','/image1.jpg','インテリア',4,5,1050);

insert into items(item_id,item_category,item_name,item_image1,item_image2,item_image3,item_image4,item_description,item_state,item_postage,item_price)
values(00032,4,'キッチン収納','/image1.jpg','/image1.jpg','/image1.jpg','/image1.jpg','インテリア',4,5,1050);

commit;
------itemが30個5このカテゴリーに6つに分ける-----------
insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00033,1,'tシャツ/シャツ','/image1.jpg',0,'いい',3,4,1000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00034,1,'tシャツ/シャツ','/image1.jpg',1,'いい',2,2,900);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00035,1,'tシャツ/シャツ','/image1.jpg',2,'わるい',1,3,1500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00036,1,'tシャツ/シャツ','/image1.jpg',3,'いい',2,5,2000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00037,1,'tシャツ/シャツ','/image1.jpg',4,'わるい',3,4,2300);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00038,1,'tシャツ/シャツ','/image1.jpg',5,'いい',1,3,2500);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00039,1,'ポロシャツ','/image1.jpg',0,'わるい',2,4,900);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00040,1,'ポロシャツ','/image1.jpg',1,'いい',3,5,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00041,1,'ポロシャツ','/image1.jpg',2,'いい',1,4,10000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00042,1,'ポロシャツ','/image1.jpg',3,'わるい',4,2,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00043,1,'ポロシャツ','/image1.jpg',4,'わるい',3,3,2600);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00044,1,'ポロシャツ','/image1.jpg',5,'いい',1,3,2800);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00045,1,'タンクトップ','/image1.jpg',0,'わるい',2,3,800);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00046,1,'タンクトップ','/image1.jpg',1,'いい',1,3,900);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00047,1,'タンクトップ','/image1.jpg',2,'わるい',3,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00048,1,'タンクトップ','/image1.jpg',3,'いい',1,6,2800);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00049,1,'タンクトップ','/image1.jpg',4,'いい',2,4,2950);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00050,1,'タンクトップ','/image1.jpg',5,'わるい',3,5,25000);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00051,1,'セーター/ニット','/image1.jpg',0,'いい',1,2,4500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00052,1,'セーター/ニット','/image1.jpg',1,'わるい',2,3,5000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00053,1,'セーター/ニット','/image1.jpg',2,'いい',3,6,8900);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00054,1,'セーター/ニット','/image1.jpg',3,'いい',2,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00055,1,'セーター/ニット','/image1.jpg',4,'わるい',1,3,1000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00056,1,'セーター/ニット','/image1.jpg',5,'いい',3,3,2600);

commit;


insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00057,1,'トレーナー/スウェット','/image1.jpg',0,'いい',2,4,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00058,1,'トレーナー/スウェット','/image1.jpg',1,'わるい',3,5,2300);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00059,1,'トレーナー/スウェット','/image1.jpg',2,'わるい',3,3,2600);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00060,1,'トレーナー/スウェット','/image1.jpg',3,'いい',2,6,2700);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00061,1,'トレーナー/スウェット','/image1.jpg',4,'わるい',1,3,3000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00062,1,'トレーナー/スウェット','/image1.jpg',5,'いい',2,3,3100);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00063,1,'ジャケット','/image1.jpg',0,'いい',2,3,2600);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00064,1,'ポロシャツ','/image1.jpg',1,'わるい',1,3,2800);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00065,1,'ポロシャツ','/image1.jpg',2,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00066,1,'ポロシャツ','/image1.jpg',3,'わるい',1,3,2600);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00067,1,'ポロシャツ','/image1.jpg',4,'いい',1,3,2700);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00068,1,'ポロシャツ','/image1.jpg',5,'わるい',1,3,3000);

commit;


insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00069,1,'ポンチョ','/image1.jpg',0,'いい',2,7,2600);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00070,1,'ポンチョ','/image1.jpg',1,'わるい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00071,1,'ポンチョ','/image1.jpg',2,'わるい',1,3,2700);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00072,1,'ポンチョ','/image1.jpg',3,'いい',1,3,3500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00073,1,'ポンチョ','/image1.jpg',4,'わるい',1,3,4500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00074,1,'ポンチョ','/image1.jpg',5,'いい',1,3,4700);

commit;



insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00075,1,'コート','/image1.jpg',0,'わるい',3,3,10000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00076,1,'コート','/image1.jpg',2,'いい',2,4,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00077,1,'コート','/image1.jpg',3,'わるい',1,5,34000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00078,1,'コート','/image1.jpg',4,'いい',2,6,5000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00079,1,'コート','/image1.jpg',5,'いい',1,3,4500);

commit;



insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00080,1,'パンツ','/image1.jpg',0,'いい',3,3,1000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00081,1,'パンツ','/image1.jpg',1,'いい',2,4,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00082,1,'パンツ','/image1.jpg',2,'わるい',3,5,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00083,1,'パンツ','/image1.jpg',3,'いい',2,3,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00084,1,'パンツ','/image1.jpg',4,'わるい',3,3,16000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00085,1,'パンツ','/image1.jpg',5,'いい',1,3,2500);

commit;


insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00086,1,'デニム/ジーンズ','/image1.jpg',0,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00087,1,'デニム/ジーンズ','/image1.jpg',1,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00088,1,'デニム/ジーンズ','/image1.jpg',2,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00089,1,'デニム/ジーンズ','/image1.jpg',3,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00090,1,'デニム/ジーンズ','/image1.jpg',4,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00091,1,'デニム/ジーンズ','/image1.jpg',5,'いい',1,3,2500);

commit;




insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00092,1,'靴','/image1.jpg','いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00093,1,'バック','/image1.jpg','いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00094,1,'アクセサリー','/image1.jpg','いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00095,1,'ヘアーアクセサリー','/image1.jpg','いい',1,3,2500);

commit;


insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00096,2,'tシャツ/ポロシャツ','/image1.jpg',0,'わるい',3,5,1000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00097,2,'tシャツ/ポロシャツ','/image1.jpg',1,'いい',4,2,4000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00098,2,'tシャツ/ポロシャツ','/image1.jpg',2,'いい',5,1,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00099,2,'tシャツ/ポロシャツ','/image1.jpg',3,'わるい',3,2,15000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(000100,2,'tシャツ/ポロシャツ','/image1.jpg',4,'いい',2,1,23000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00101,2,'tシャツ/ポロシャツ','/image1.jpg',5,'わるい',1,1,1000);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00102,2,'パーカー','/image1.jpg',0,'いい',2,3,4000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00103,2,'パーカー','/image1.jpg',1,'わるい',4,3,5500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00104,2,'パーカー','/image1.jpg',2,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00105,2,'パーカー','/image1.jpg',3,'わるい',2,3,2300);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00106,2,'パーカー','/image1.jpg',4,'いい',3,3,2650);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00107,2,'パーカー','/image1.jpg',5,'いい',2,6,6700);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00108,2,'スウェット','/image1.jpg',0,'わるい',3,6,4500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00109,2,'スウェット','/image1.jpg',1,'いい',1,3,3500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00110,2,'スウェット','/image1.jpg',2,'わるい',2,3,4670);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00111,2,'スウェット','/image1.jpg',3,'いい',1,6,10000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00112,2,'スウェット','/image1.jpg',4,'いい',4,3,3520);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00113,2,'スウェット','/image1.jpg',5,'わるい',4,5,6500);

commit;


insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00114,2,'デニムジャケット/Gジャン','/image1.jpg',0,'わるい',3,6,7000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00115,2,'デニムジャケット/Gジャン','/image1.jpg',1,'いい',2,5,8900);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00116,2,'デニムジャケット/Gジャン','/image1.jpg',2,'いい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00117,2,'デニムジャケット/Gジャン','/image1.jpg',3,'いい',4,2,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00118,2,'デニムジャケット/Gジャン','/image1.jpg',4,'わるい',1,3,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00119,2,'デニムジャケット/Gジャン','/image1.jpg',5,'いい',3,3,4500);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00120,2,'コート','/image1.jpg',0,'いい',2,4,5000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00121,2,'コート','/image1.jpg',1,'いい',2,5,3400);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00122,2,'コート','/image1.jpg',2,'わるい',1,3,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00123,2,'コート','/image1.jpg',3,'いい',3,4,78900);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00124,2,'コート','/image1.jpg',4,'いい',4,4,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00125,2,'コート','/image1.jpg',5,'いい',3,3,35000);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00126,2,'パンツ','/image1.jpg',0,'いい',3,3,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00127,2,'パンツ','/image1.jpg',1,'いい',4,3,4500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00128,2,'パンツ','/image1.jpg',2,'わるい',2,3,1999);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00129,2,'パンツ','/image1.jpg',3,'いい',1,5,999);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00130,2,'パンツ','/image1.jpg',4,'わるい',3,7,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00131,2,'パンツ','/image1.jpg',5,'いい',1,3,2500);


commit;

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00132,2,'靴','/image1.jpg','いい',2,3,5000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00133,2,'バック','/image1.jpg','わるい',1,3,25000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00134,2,'帽子','/image1.jpg','いい',3,3,3000);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00135,3,'トップス','/image1.jpg',0,'いい',3,3,15000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00136,3,'トップス','/image1.jpg',1,'わるい',1,4,3500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00137,3,'トップス','/image1.jpg',2,'いい',3,5,25000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00138,3,'トップス','/image1.jpg',3,'わるい',1,2,3000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00139,3,'トップス','/image1.jpg',4,'わるい',2,1,2500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00140,3,'トップス','/image1.jpg',5,'いい',3,4,45000);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00141,3,'スカート','/image1.jpg',1,'いい',1,4,4500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00142,3,'スカート','/image1.jpg',2,'わるい',1,3,1000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00143,3,'スカート','/image1.jpg',3,'いい',3,4,3000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00144,3,'スカート','/image1.jpg',4,'わるい',2,6,4000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00145,3,'スカート','/image1.jpg',5,'いい',3,4,45000);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00146,3,'パンツ','/image1.jpg',0,'いい',1,3,1000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00147,3,'パンツ','/image1.jpg',1,'いい',3,4,4500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00148,3,'パンツ','/image1.jpg',2,'いい',2,5,45000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00149,3,'パンツ','/image1.jpg',3,'いい',1,4,5000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00150,3,'パンツ','/image1.jpg',4,'いい',3,2,6000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00151,3,'パンツ','/image1.jpg',5,'いい',2,1,65000);

commit;

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00152,4,'キッチン/食器','/image1.jpg','いい',4,3,10000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00153,4,'ベット/マットレス','/image1.jpg',1,'いい',3,5,9000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00154,4,'ソファ/ソファベット','/image1.jpg',2,'わるい',2,1,3500);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00155,4,'椅子/チェア','/image1.jpg',3,'いい',3,6,56000);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00156,4,'机/テーブル','/image1.jpg',4,'わるい',2,1,3400);

insert into items(item_id,item_category,item_name,item_image1,item_size,item_description,item_state,item_postage,item_price)
values(00157,4,'収納家具','/image1.jpg',5,'わるい',4,2,4500);

commit;


insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00158,5,'おもちゃ','/image1.jpg','いい',4,3,56000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00159,5,'タレントグッズ','/image1.jpg','わるい',2,3,4300);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00160,5,'コミック/アニメグッズ','/image1.jpg','いい',3,4,15000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00161,5,'フィギュア','/image1.jpg','わるい',3,2,2500);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00162,5,'楽器/器材','/image1.jpg','いい',4,5,6700);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00163,5,'美術品/アート用品','/image1.jpg','いい',3,4,8900);

commit;


insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00164,6,'ベースメイク','/image1.jpg','いい',1,3,8900);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00165,6,'リップ/口紅','/image1.jpg','わるい',3,4,5600);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00166,6,'ネイルケア','/image1.jpg','いい',2,5,7800);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00167,6,'香水','/image1.jpg','わるい',2,3,25000);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00168,6,'スキンケア','/image1.jpg','わるい',1,4,8900);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(00169,6,'ボディケア','/image1.jpg','いい',4,4,8900);

insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(99999,1,'Admin','/image1.jpg','いい',1,1,1);

commit;

-------------チャージ----------------------------------------------------------------------------------------------
insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)
values(99999,99999,'チャージ','null','チャージ',1,1,300);


------------------trade_info--------------------------------------------------------
----------------0000001----------------------------------------------
insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00001');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00002');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00003');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00004');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00005');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00006');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00007');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00008');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00009');



insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00010');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00011');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00012');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00013');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00014');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00015');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00016');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00017');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00018');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00019');



insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00020');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00021');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00022');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00023');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00024');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00025');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00026');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00027');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00028');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00029');



insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00030');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00031');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00032');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00033');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00034');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00035');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00036');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000001','00037');



----------------------------------0000002--------------------------------------------------
insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00038');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00039');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00040');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00041');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00042');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00043');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00044');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00045');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00046');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00047');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00048');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00049');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00050');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00051');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00052');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00053');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00054');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00055');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00056');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00057');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00058');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00059');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00060');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00061');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00062');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00063');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00064');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00065');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00066');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00067');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00068');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00069');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00070');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00071');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00072');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000002','00073');


-----------------------------------------------0000003------------------------------------

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00074');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00075');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00076');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00077');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00078');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00078');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00079');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00080');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00081');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00082');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00083');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00084');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00085');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00086');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00087');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00088');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00089');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00090');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00091');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00092');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00093');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00094');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00095');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00096');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00097');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00098');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00099');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00100');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00101');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00102');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00103');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00104');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00105');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00106');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00107');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000003','00108');


-------------------------0000004--------------------------------------------


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00109');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00110');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00111');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00112');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00113');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00114');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00115');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00116');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00117');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00118');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00119');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00120');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00121');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00122');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00123');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00124');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00125');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00126');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00127');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00128');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','000129');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00130');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00131');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00132');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00133');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00134');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00135');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00136');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00137');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00138');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00139');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00140');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00141');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00142');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00143');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000004','00144');


---------------------------0000005---------------------------

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00145');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00146');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00147');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00148');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00149');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00150');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00151');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00152');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00153');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00154');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00155');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00156');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00157');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00158');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00159');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00160');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00161');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00162');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00163');


insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00164');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','000165');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00166');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00167');

insert into trade_info(tinfo_salerid,tinfo_itemid)
values('0000005','00168');

commit;
