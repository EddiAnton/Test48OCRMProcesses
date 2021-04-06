DECLARE
PRODUCTORDERID CHAR(12) := 'Infor_ID';
FB_PRODUCTORDERMEMBERID CHAR(12); 
FB_PRODUCTORDMEMB_DATAID CHAR(12); 
FB_PRODUCTORDMEMB_DATAID_1 CHAR(12); 
FB_PRODUCTORDMEMB_DATAID_2 CHAR(12); 
FB_PRODUCTORDMEMB_DATAID_3 CHAR(12);
now_timestamp DATE := SYS_EXTRACT_UTC (SYSTIMESTAMP);
BEGIN
SELECT fbpo.FB_PRODUCTORDERMEMBERID into FB_PRODUCTORDERMEMBERID FROM FB_PRODUCTORDERMEMBER fbpo WHERE fbpo.FB_PRODUCTORDERID = PRODUCTORDERID;
FB_PRODUCTORDMEMB_DATAID := SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_DATA');
FB_PRODUCTORDMEMB_DATAID_1 := SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_DATA');
FB_PRODUCTORDMEMB_DATAID_2 := SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_DATA');
FB_PRODUCTORDMEMB_DATAID_3 := SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_DATA');

UPDATE fb_productorder fbpo
SET fbpo.URLTESSA = 'url tessa 1' 
WHERE fbpo.FB_PRODUCTORDERID = PRODUCTORDERID;

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_DATA (FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
ISPRIMARY, MEMBERDATATYPE, FB_PRODUCTORDERMEMBERID, IDCFT, ACCOUNTNAME, AKA,
ENGNAME, ENGNAMESHORT, OKATO, OKTMO, MANAGE_STRUCTURE, OKFS, COMPANYTYPE,
STAFCOUNT, OKOPF, CAPITALANNOUNCEDSUM, CAPITALCURRENCY, INN, ISCURRENCYRESIDENT, ISTAXRESIDENT,
OKPO, SWIFT, OKOGU, MANAGE_PERSON, PROFILERECEIPTS, ISPROFILEREPUTATION_CLIENT, ISPROFILEREPUTATION_BANK,
ISPROFILEREPUTATION_OTHER, ISPROFILEFINANCESOURCE_FOUNDER, ISPROFILEFINANCESOURCE_MAIN, ISPROFILEFINANCESOURCE_ADD,
ISPROFILEFINANCESOURCE_LOAN, ISPROFILEFINANCESOURCE_STATE, ISPROFILEFINANCESOURCE_OTHER, PROFILECASHOPERATION_SALARY,
PROFILECASHOPERATION_TRAVEL, PROFILECASHOPERATION_ECONOMIC, PROFILECASHOPERATION_AGRI, PROFILECASHOPERATION_OTHER,
PROFILEBANKRUPTCY, PROFILELIQUIDATION, PROFILEZEROCASH, PROFILEBANKRUPTCYDECISION, PROFILEVTOAMOUNT,
FATCADOC, FATCADOCW9, KIO, JURISDICTION)
VALUES (FB_PRODUCTORDMEMB_DATAID, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'T', 1, FB_PRODUCTORDERMEMBERID, '7126', '��� ������ ������', '�������� � ������������ ���������������� ������ ������',
'Best client Ltd', 'Best client', '45277598000', '45348000000', '����� �������� ����������� ��������', '14', 'F_�',
'45', '12200', '200000', 'USD', '7405556677', 'T', 'T',
'93309026', 'SWIFT', '4210014', '����� �������� ������� �������� �������� 100% ����������� �������� ������� �������� ��������', '5000000', 'T', 'F',
'F', 'T', 'F', 'F',
'F', 'F', 'T', '44444',
'55555', '33333', '77777', '88888',
'F', 'F', 'F', 'F', '50000',
'T', 'F', '56677', 'RUS');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_FACE (FB_PRODUCTORDMEMB_FACEID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
FACETYPE, FACEID, MEMBERCLASS, DATEBEGIN, ISEIO, ISMANAGEBOARD, ASSOCIATIONTYPE, TITLE, TYPEOFFOUNDATION, NOTES)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_FACE'), FB_PRODUCTORDMEMB_DATAID_1, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'B', '410', 'CL_PRIV', TO_DATE('2012-08-18','YYYY-MM-DD'), 'T', 'T', '���_������������', '������� ��� �������� ���������',
'��������', '���� ���������� �� ������ �� �������� 15.05.2015 - 5 ���');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_FACE (FB_PRODUCTORDMEMB_FACEID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
FACETYPE, FACEID, MEMBERCLASS, DATEBEGIN, ASSOCIATIONTYPE, TITLE, NOTES)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_FACE'), FB_PRODUCTORDMEMB_DATAID_2, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'B', '414', 'CL_PRIV', TO_DATE('2012-10-10','YYYY-MM-DD'), '���_������������', '��. ���������', '���� ���������� �� ������ �� �������� 15.05.2015 - 3 ����');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_FACE (FB_PRODUCTORDMEMB_FACEID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
FACETYPE, FACEID, MEMBERCLASS, DATEBEGIN, TYPEOFFOUNDATION, ASSOCIATIONTYPE, CAPITALPERCENT)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_FACE'), FB_PRODUCTORDMEMB_DATAID_3, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'F', '444', 'CL_ORG', TO_DATE('2012-08-18','YYYY-MM-DD'), 'BEN3', '����������', '100');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_DATA (FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
MEMBERDATATYPE, ISPRIMARY, FB_PRODUCTORDERMEMBERID, BIRTHDATE, BIRTHPLACE, FIRSTNAME, LASTNAME, MIDDLENAME,
GENDER, INN, COUNTRY, NOCITIZENSHIP, IDCFT, MEMBERCLASS)
VALUES (FB_PRODUCTORDMEMB_DATAID_1, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
1, 'F', FB_PRODUCTORDERMEMBERID, TO_DATE('1965-09-04','YYYY-MM-DD'), 'New York', '�����������', '����', '����������',
'�', '7474567891', 'USA', 'F', '3476', 'CL_PRIV');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_DATA (FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
MEMBERDATATYPE, ISPRIMARY, FB_PRODUCTORDERMEMBERID, BIRTHDATE, BIRTHPLACE, FIRSTNAME, LASTNAME, MIDDLENAME,
GENDER, INN, COUNTRY, NOCITIZENSHIP, IDCFT, MEMBERCLASS)
VALUES (FB_PRODUCTORDMEMB_DATAID_2, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
1, 'F', FB_PRODUCTORDERMEMBERID, TO_DATE('1981-11-25','YYYY-MM-DD'), '������', '���������', '��������', '����������',
'�', '74700000001', 'RUS', 'F', '578', 'CL_PRIV');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_DATA (FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
ISPRIMARY, MEMBERDATATYPE, FB_PRODUCTORDERMEMBERID, IDCFT, ACCOUNTNAME, AKA,
ENGNAME, ENGNAMESHORT, OKATO, OKTMO, MANAGE_STRUCTURE, OKFS, COMPANYTYPE,
STAFCOUNT, OKOPF, CAPITALANNOUNCEDSUM, CAPITALCURRENCY, INN, ISCURRENCYRESIDENT, ISTAXRESIDENT,
OKPO, SWIFT, OKOGU, MANAGE_PERSON, PROFILERECEIPTS, ISPROFILEREPUTATION_CLIENT, ISPROFILEREPUTATION_BANK,
ISPROFILEREPUTATION_OTHER, ISPROFILEFINANCESOURCE_FOUNDER, ISPROFILEFINANCESOURCE_MAIN, ISPROFILEFINANCESOURCE_ADD,
ISPROFILEFINANCESOURCE_LOAN, ISPROFILEFINANCESOURCE_STATE, ISPROFILEFINANCESOURCE_OTHER, PROFILECASHOPERATION_SALARY,
PROFILECASHOPERATION_TRAVEL, PROFILECASHOPERATION_ECONOMIC, PROFILECASHOPERATION_AGRI, PROFILECASHOPERATION_OTHER,
PROFILEBANKRUPTCY, PROFILELIQUIDATION, PROFILEZEROCASH, PROFILEBANKRUPTCYDECISION, PROFILEVTOAMOUNT,
FATCADOC, FATCADOCW9, JURISDICTION, MEMBERCLASS)
VALUES (FB_PRODUCTORDMEMB_DATAID_3, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'F', 1, FB_PRODUCTORDERMEMBERID, '129', '��� ������ �������', '�������� � ������������ ���������������� ������ �������',
'Best partner Ltd', 'Best partner', '45277598000', '45348000000', '����� �������� ����������� ��������', '14', 'F_K',
'277', '12300', '222000', 'RUB', '7403334455', 'F', 'T',
'93309026', 'SWIFT', '4210014', '����� �������� 100% ����������� ��������', '7770000', 'T', 'F',
'F', 'T', 'F', 'F',
'F', 'F', 'T', '1111',
'50000', '3300', '77000', '8000',
'F', 'F', 'F', 'F', '125000',
'T', 'F', 'RUS', 'CL_ORG');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CODE (FB_PRODUCTORDMEMB_CODEID, FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE, CODETYPE, CODEID, CODE, ISPRIMARY, ISADDITIONALPROPERTY1)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CODE'), FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
'ADMIN', now_timestamp, 'ADMIN', now_timestamp, '2', '212', '1234567890147', 'T', 'F');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CODE (FB_PRODUCTORDMEMB_CODEID, FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE, CODETYPE, CODEID, CODE, CODENAME)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CODE'), FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
'ADMIN', now_timestamp, 'ADMIN', now_timestamp, '4', '213', '7714', '���� ������ � 14 �� �.������');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CODE (FB_PRODUCTORDMEMB_CODEID, FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE, CODETYPE, CODEID, CODE, BEGINDATE, ISPRIMARY)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CODE'), FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
'ADMIN', now_timestamp, 'ADMIN', now_timestamp, '1', '215', '73.20', TO_DATE('2010-11-25','YYYY-MM-DD'), 'T');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CODE (FB_PRODUCTORDMEMB_CODEID, FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE, CODETYPE, CODEID, CODE, BEGINDATE, ISPRIMARY)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CODE'), FB_PRODUCTORDMEMB_DATAID, FB_PRODUCTORDERMEMBERID,
'ADMIN', now_timestamp, 'ADMIN', now_timestamp, '1', '217', '82.99', TO_DATE('2010-11-25','YYYY-MM-DD'), 'F');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CONT (FB_PRODUCTORDMEMB_CONTID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
CUST_CHANNELID, CHANNEL_TYPE, CHANNEL_VALUE, CHANNEL_SUBTYPE, ISACTIVE, ISPRIMARY, NOTE)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CONT'), FB_PRODUCTORDMEMB_DATAID, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'291', 'PHONE', '7(495) 478-3077', '2', 'T', 'T', '����������� ��������');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CONT (FB_PRODUCTORDMEMB_CONTID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
CUST_CHANNELID, CHANNEL_TYPE, CHANNEL_VALUE, ISACTIVE, ISPRIMARY, NOTE)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CONT'), FB_PRODUCTORDMEMB_DATAID, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'295', 'MAIL', 'Svetlana.A@lukoil.com', 'T', 'F', '��� ���������������');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CONT (FB_PRODUCTORDMEMB_CONTID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
CUST_CHANNELID, CHANNEL_TYPE, CHANNEL_VALUE, ISACTIVE, ISPRIMARY)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CONT'), FB_PRODUCTORDMEMB_DATAID, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'305', 'WEB', 'http:/testsave.ru/', 'T', 'T');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_ADDR (FB_PRODUCTORDMEMB_ADDRID, FB_PRODUCTORDERMEMBERID, FB_PRODUCTORDMEMB_DATAID,
CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE, ADDRESSID, ADDRESSTYPE,
CITY, CITYFIAS, STREETFIAS, STREET, HOUSE, CORPUS, APARTMENT,
FULLADDRESS, COUNTRY)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_ADDR'), FB_PRODUCTORDERMEMBERID, FB_PRODUCTORDMEMB_DATAID,
'ADMIN', now_timestamp, 'ADMIN', now_timestamp, '389', 'CORP',
'������', '77000000000000000000000000', '77000000000000073740000000', '���������������� �������', '14', '���� 3', '���/���� V/9',
'������,125252,,,� ������,�� ���������������� �������,��� 14,���� 3,���/���� V/9', 'RUS');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_ADDR (FB_PRODUCTORDMEMB_ADDRID, FB_PRODUCTORDERMEMBERID, FB_PRODUCTORDMEMB_DATAID,
CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE, ADDRESSID, ADDRESSTYPE,
CITY, CITYFIAS, STREETFIAS, STREET, HOUSE, CORPUS, APARTMENT,
FULLADDRESS, COUNTRY)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_ADDR'), FB_PRODUCTORDERMEMBERID, FB_PRODUCTORDMEMB_DATAID,
'ADMIN', now_timestamp, 'ADMIN', now_timestamp, '396', 'POST',
'������', '77000000000000000000000000', '77000000000000073740000000', '���������������� �������', '14', '���� 3', '���/���� V/9',
'������,125252,,,� ������,�� ���������������� �������,��� 14,���� 3,���/���� V/9', 'RUS');

INSERT INTO SYSDBA.FB_PRODUCTORDERLICENSE (FB_PRODUCTORDERLICENSEID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
LICENSEID, LICENSENUMBER, DOCTYPE, ACTIVITYKIND, ISSUEDATE, EXPIRYDATE, ISSUEDBY, ACTIVITYKINDLIST)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDERLICENSE'), FB_PRODUCTORDMEMB_DATAID, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'450', '12/455', '��������', '������ ����� �� �������� ������ ��� ����� �������� ��������� ����������', TO_DATE('2012-08-18','YYYY-MM-DD'),
TO_DATE('2022-08-18','YYYY-MM-DD'), '����������� ������ �� ������� � ����� �����, �������������� ���������� � �������� ������������', '���������');

INSERT INTO SYSDBA.FB_PRODUCTORDMEMB_CRS (FB_PRODUCTORDMEMB_CRSID, FB_PRODUCTORDMEMB_DATAID, CREATEUSER, CREATEDATE, MODIFYUSER, MODIFYDATE,
CRSID, CRS_NALOG_RESIDENCE, CRS_IINN, CRS_DATE_BEGIN, CRS_STATUS)
VALUES (SYSDBA.FCREATESLXID ('FB_PRODUCTORDMEMB_CRS'), FB_PRODUCTORDMEMB_DATAID, 'ADMIN', now_timestamp, 'ADMIN', now_timestamp,
'404', 'SUI', '5555555', TO_DATE('2017-04-24','YYYY-MM-DD'), 'CRS_RUS_ACTIV_1');
COMMIT;
END;