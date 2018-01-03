create table my_board(
    num         number(5),
    writer      varchar2(20)  not null,
    pwd         varchar2(10)  not null,
    subject     varchar2(50)  not null,
    content     varchar2(500) not null,
    readcnt     number(5)     default 0,
    ref         number(5)     default 0,
    ref_step    number(5)     default 0,
    ref_level   number(5)     default 0,
    reg_date    timestamp     default sysdate,
    ip          varchar2(15),
    constraint my_board_num_pk primary key(num)
    );