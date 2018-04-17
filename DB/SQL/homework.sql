create database if not exists homework;

create table expenses(
num int,
paydate date,
receiver int,
value dec
);

create table receivers(
num int,
name varchar(255)
);

insert into expenses values (1, now(), 1,2000.0);
insert into expenses values (2, now(), 2, 94200.0);
insert into expenses values (3, now(), 3, 10000.0);
insert into expenses values (4, now(), 3, 12950.0);
insert into expenses values (5, now(), 3, 15000.0);
insert into expenses values (5, now(), 4, 17000.0);

/* TASK 1  */
insert into receivers values (1, 'ivanov');
insert into receivers values (2, 'petrov');
insert into receivers values (1, 'sidorov');
insert into receivers values (1, 'kapturovich');
insert into receivers values (1, 'petrenko');

/* TASK 2 */

select expenses.num, paydate, name, value from expenses, receivers where expenses.value>=10000.0 ;

/* TASK 3 */

delete from expenses where expenses.value<3000;

/*TASK 6*/
select paydate, sum(value) from expenses where value=(select MAX(value) from expenses) group by paydate;

select paydate, max(value) from expenses where value=(select MAX(value) from expenses) group by paydate;



