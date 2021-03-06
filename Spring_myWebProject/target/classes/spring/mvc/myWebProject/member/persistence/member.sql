CREATE TABLE MEMBER(
    ID VARCHAR2(20),
    PWD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    JUMIN VARCHAR2(14) NOT NULL,
    EMAIL VARCHAR2(320) NOT NULL,
    ADDRESS VARCHAR2(160),
    HP VARCHAR2(13) NOT NULL,
    CONSTRAINT MEMBER_ID_PK PRIMARY KEY(ID),
    CONSTRAINT MEMBER_EMAIL_UK UNIQUE(EMAIL),
    CONSTRAINT MEMBER_HP_UK UNIQUE(HP)
    );