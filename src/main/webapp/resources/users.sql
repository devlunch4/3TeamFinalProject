 DROP TABLE USERS;

  CREATE TABLE USERS 
   (	USERID VARCHAR2(20 BYTE), 
	USERNM VARCHAR2(20 BYTE), 
	PASS VARCHAR2(100 BYTE), 
	REG_DT DATE, 
	ALIAS VARCHAR2(50 BYTE), 
	ADDR1 VARCHAR2(50 BYTE), 
	ADDR2 VARCHAR2(50 BYTE), 
	ZIPCODE VARCHAR2(5 BYTE), 
	FILENAME VARCHAR2(50 BYTE), 
	REALFILENAME VARCHAR2(200 BYTE), 
	 CONSTRAINT PK_USER PRIMARY KEY (USERID)
    );
  

   COMMENT ON COLUMN USERS.USERID IS '사용자 아이디';
   COMMENT ON COLUMN USERS.USERNM IS '사용자 이름';
   COMMENT ON COLUMN USERS.PASS IS '비밀번호';
   COMMENT ON COLUMN USERS.REG_DT IS '사용자 등록일';
   COMMENT ON COLUMN USERS.ALIAS IS '별명';
   COMMENT ON COLUMN USERS.ADDR1 IS '주소';
   COMMENT ON COLUMN USERS.ADDR2 IS '상세주소';
   COMMENT ON COLUMN USERS.ZIPCODE IS '우편번호';
   COMMENT ON COLUMN USERS.FILENAME IS '업로드파일명';
   COMMENT ON COLUMN USERS.REALFILENAME IS '실제파일경로';
   COMMENT ON TABLE USERS  IS '사용자';
  
  
insert into users values('brown', '브라운', 'c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44', '19/01/28', '곰', '', '', '', '', '');
insert into users values('cony', '코니', '55525cd5e74f52ef9e686b812f616b5891bda924f26450113b3f6ebd6adb5c', '19/01/28', '토끼', '', '', '', '', '');
insert into users values('sally', '샐리', 'c96de0c53a6194aceefbf83121e5b7dfb9d675dee1821d6da438dc3ae3e1ef55', '19/01/28', '병아리', '', '', '', '', '');
insert into users values('james', '제임스', 'b097f022d7879a164ea13dd63719e7a2af70c372d9139fc1d6443c6884e2f851', '19/01/28', '사람', '', '', '', '', '');
insert into users values('moon', '문', '7deff5c6fea2a1683b983bc5969afa759d13c5dc0d6dbd02c6f5bd091e06c', '', '달', '', '', '', '', '');

commit;
    