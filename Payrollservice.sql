-- uc1
create database payroll_service;
show databases;
use payroll_service;
-- uc2
Create Table employee_payroll
(id int unsigned NOT NULL auto_increment ,
name varchar(150) NOT NULL,
salary double NOT NULL,
start date NOT NULL,
primary key (id));
-- uc3
INSERT INTO employee_payroll (name,salary,start ) VALUES 
('bill',10000.00,'22-05-16'),
('jeff',20000.00,'22-05-25'),
('charls',30000.00,'22-05-30');
-- uc4
select * from employee_payroll;
-- uc5
select salary from employee_payroll where name='bill';
-- uc6
Alter table employee_payroll add gender char(1) AFTER name;
UPDATE employee_payroll set gender =
'M' where name = 'Bill' or name =
'Charls' or name ='jeff';
-- uc7
SELECT SUM(salary) FROM employee_payroll
WHERE gender = 'M' GROUP BY gender;