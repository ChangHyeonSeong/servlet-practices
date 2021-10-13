desc guestbook;

-- insert
insert into guestbook values(null, '안대혁', '1234', '안녕하세요', now());
insert into guestbook values(null, '둘리', '3234', '호이 ~', now());

-- select
select no, name, date_format(reg_date, '%Y/%m/%d %H:%i:%s'), message, password
 from guestbook
 order by reg_date desc;
 
 -- delete
 delete
   from guestbook
  where no =1
    and password = '1234';
    
    
