select user
  from dual;
select *
  from user_tables;

select current_timestamp
  from dual;

insert into menu (
   name,
   created_at
) values ( 'Papas fritas con pollo al jugo',
           current_timestamp );
insert into menu (
   name,
   created_at
) values ( 'Papas fritas con bistec',
           current_timestamp );
insert into menu (
   name,
   created_at
) values ( 'Papas mayo con bistec',
           current_timestamp );

select *
  from menu;