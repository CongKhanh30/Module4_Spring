create database FPT_management;

use FPT_management;

create table Staff
(
    staffId   INT PRIMARY KEY AUTO_INCREMENT,
    staffCode VARCHAR(10) NOT NULL,
    staffName VARCHAR(255) NOT NULL,
    age       INT NOT NULL,
    salary    INT,
    branchId  INT,
    img       TEXT NOT NULL,
    FOREIGN KEY (branchId) REFERENCES Branch (branchId)
);

create table Branch
(
    branchId   INT PRIMARY KEY AUTO_INCREMENT,
    branchName VARCHAR(255) NOT NULL
);


insert into Branch(branchName)
values ('Human Resources');
insert into Branch(branchName)
values ('RnD');
insert into Branch(branchName)
values ('Marketing');

insert into Staff(staffCode, staffName, age, salary, branchId, img)
values ( 'FT01', 'Nguyễn Văn Quang', '35',10000000 , 1, 'quang.jpg');
insert into Staff(staffCode, staffName, age, salary, branchId, img)
values ( 'FT02', 'Trần Văn Huỳnh', '23',11000000 , 2, 'huynh.jpg');
insert into Staff(staffCode, staffName, age, salary, branchId, img)
values ( 'FT03', 'Nguyễn Viết Đạt', '26',9000000 , 3, 'dat.jpg');





