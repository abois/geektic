drop table geek_interest if exists cascade;
drop table geek if exists cascade;
drop table interest if exists cascade;
drop sequence geek_seq if exists;
drop sequence interest_seq if exists;

create table geek(
	id numeric not null,
	firstname varchar(255) not null,
	lastname varchar(255) not null,
	email varchar(255) not null,
  gender boolean not null,
	primary key (id)
);

create table interest(
	id numeric not null,
	name varchar(255) not null,
	primary key (id)
);

create table geek_interest(
  id_geek numeric not null,
  id_interest numeric not null,
  FOREIGN KEY(id_geek) REFERENCES public.geek (id),
  FOREIGN KEY(id_interest) REFERENCES public.interest (id),
  primary key (id_geek, id_interest)
);

create sequence geek_seq start with 1000;
create sequence interest_seq start with 1000;