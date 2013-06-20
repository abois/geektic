drop table geek_interest if exists cascade;
drop table geek if exists cascade;
drop table interest if exists cascade;
drop table audit if exists cascade;
drop sequence geek_seq if exists;
drop sequence interest_seq if exists;
drop sequence audit_seq if exists;

create table geek(
	id numeric not null,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	email varchar(100) not null,
  gender boolean not null,
  password varchar(150) not null,
	description longvarchar,
	avatar varchar(200),
  isAvailable boolean default 0,
	primary key (id)
);

create table interest(
	id numeric not null,
	name varchar(150) not null,
	primary key (id)
);

create table geek_interest(
  id_geek numeric not null,
  id_interest numeric not null,
  FOREIGN KEY(id_geek) REFERENCES public.geek (id),
  FOREIGN KEY(id_interest) REFERENCES public.interest (id),
  primary key (id_geek, id_interest)
);

create table audit(
  id numeric not null,
  id_geek numeric not null,
  visit_date varchar(10),
  ip varchar(20),
  FOREIGN KEY(id_geek) REFERENCES public.geek (id),
  primary key (id)
);

create sequence geek_seq start with 1000;
create sequence interest_seq start with 1000;
create sequence audit_seq start with 1000;