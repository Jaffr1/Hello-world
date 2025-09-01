use employee;

delimiter $$
create procedure stprocd1()
begin 
declare a int default 0;
-- set a=10;
select count(empno) into a from emp;
select a;
end $$
delimiter ;
call stprocd1();
select count(name) from emp;
drop procedure stprocd1;


delimiter ##
create procedure stprocd2(in jb varchar(10))
begin 
select * from emp where job=jb;
end ##
delimiter ;
call stprocd2('manager');


delimiter ##
create procedure stprocd3(out x int,in n varchar(10))
begin 
select salary into x from emp where name=n;
end ##
delimiter ;

drop procedure stprocd3;

call stprocd3(@y,'ward');
call stprocd3(@y,'king');
select @y;

delimiter ##
create procedure stprocd4(inout val int,in m varchar(10))
begin 
select salary+val into val from emp where name=m;
end ##
delimiter ;


delimiter ##
create procedure stprocd5(inout m varchar(10))
begin 
select job into m from emp where name='king';
end ##
delimiter ;
call stprocd5(@d);
select @d;

set @d=10;
call stprocd4(@d,'king');
call stprocd4(@d,'king');
select @d;