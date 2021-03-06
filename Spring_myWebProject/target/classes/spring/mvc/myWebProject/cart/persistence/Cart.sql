CREATE TABLE CART(
    CART_ID         VARCHAR2(20),
    NUM             NUMBER(6),
    ID              VARCHAR2(20),
    PRODUCT_CODE    VARCHAR2(30),
    AMOUNT			NUMBER(4),
    CONSTRAINT CART_CART_ID_PK PRIMARY KEY(CART_ID),
    CONSTRAINT CART_MEM_ID_FK  FOREIGN KEY(ID) REFERENCES MEMBER(ID),
    CONSTRAINT CART_PRODUCT_CODE_FK FOREIGN KEY(PRODUCT_CODE) REFERENCES PRODUCT(PRODUCT_CODE)
    );