CREATE TABLE ORDERS(
    ORDER_CODE          VARCHAR2(12),
    NUM                 NUMBER(4)     NOT NULL,
    PRODUCT_CODE        VARCHAR2(30),
    ID                  VARCHAR2(20),
    AMOUNTOFPURCHASE    NUMBER(5) CHECK (AMOUNTOFPURCHASE > 0),
    ORDER_DATE          TIMESTAMP DEFAULT SYSDATE,
    ORDER_STATUS        VARCHAR2(30),
    SELLER_ID			VARCHAR2(20),
    CONSTRAINT ORDER_ORDER_CODE_PK PRIMARY KEY(ORDER_CODE),
    CONSTRAINT ORDER_PRODUCT_CODE_FK FOREIGN KEY(PRODUCT_CODE) REFERENCES PRODUCT(PRODUCT_CODE),
    CONSTRAINT ORDER_ID_FK  FOREIGN KEY(ID) REFERENCES MEMBER(ID)
    CONSTRAINT ORDER_SELLER_ID_FK FOREIGN KEY(SELLER_ID) REFERENCES MEMBER(ID)
    );