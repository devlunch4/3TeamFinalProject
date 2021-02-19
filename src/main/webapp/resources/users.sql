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
  

   COMMENT ON COLUMN USERS.USERID IS '����� ���̵�';
   COMMENT ON COLUMN USERS.USERNM IS '����� �̸�';
   COMMENT ON COLUMN USERS.PASS IS '��й�ȣ';
   COMMENT ON COLUMN USERS.REG_DT IS '����� �����';
   COMMENT ON COLUMN USERS.ALIAS IS '����';
   COMMENT ON COLUMN USERS.ADDR1 IS '�ּ�';
   COMMENT ON COLUMN USERS.ADDR2 IS '���ּ�';
   COMMENT ON COLUMN USERS.ZIPCODE IS '�����ȣ';
   COMMENT ON COLUMN USERS.FILENAME IS '���ε����ϸ�';
   COMMENT ON COLUMN USERS.REALFILENAME IS '�������ϰ��';
   COMMENT ON TABLE USERS  IS '�����';
  
  
insert into users values('brown', '����', 'c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44', '19/01/28', '��', '', '', '', '', '');
insert into users values('cony', '�ڴ�', '55525cd5e74f52ef9e686b812f616b5891bda924f26450113b3f6ebd6adb5c', '19/01/28', '�䳢', '', '', '', '', '');
insert into users values('sally', '����', 'c96de0c53a6194aceefbf83121e5b7dfb9d675dee1821d6da438dc3ae3e1ef55', '19/01/28', '���Ƹ�', '', '', '', '', '');
insert into users values('james', '���ӽ�', 'b097f022d7879a164ea13dd63719e7a2af70c372d9139fc1d6443c6884e2f851', '19/01/28', '���', '', '', '', '', '');
insert into users values('moon', '��', '7deff5c6fea2a1683b983bc5969afa759d13c5dc0d6dbd02c6f5bd091e06c', '', '��', '', '', '', '', '');

commit;
    