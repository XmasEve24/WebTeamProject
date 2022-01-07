create table admin(
    adminNum int primary key,
    adminName varchar(20) not null,
    adminId varchar(20) not null,
    adminPw varchar(20) not null,
    adminEmail varchar(30) not null
);

create table member(
    memberNum int primary key ,
    memberName varchar(20) not null,
    memberID varchar(20) not null,
    memberPw varchar(20) not null,
    memberEmail varchar(30) not null
);
select * from portfolio;
drop table portfolio;

create table portfolio(
    portNum int primary key , 
    adminNum int not null,
    adminName varchar(20) not null,
    portTitle varchar(50) not null,
    portContent varchar(200),
    portTime date, 
    constraint admin_fk foreign key(adminNum) references admin(adminNum) on DELETE CASCADE 
);


create table reply(
    replyNum int primary key ,
    portNum int not null,
    replyContent varchar(50),
    memberName varchar(20) not null,
    replyTime date,
    constraint portfolio_fk foreign key(portNum) references portfolio(portNum) on DELETE CASCADE  
);
select * from member;

create table contact (
    contactNum int primary key,
    contactType varchar(30) not null,
    portNum int not null,
    memberName varchar(30) not null,
    contactContent varchar(250) not null,
    memberEmail varchar(30) not null
);
drop table contact;
