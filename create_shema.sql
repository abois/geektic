drop table geek if exists cascade;
drop sequence geek_seq if exists;

create table geek(
	id numeric not null,
	nom varchar(255) not null,
	prenom varchar(255) not null,
	email varchar(255) not null,
	primary key (id)
);

create table interest(
	id numeric not null,
	nom varchar(255) not null,
	primary key (id)
);

create table geek_interest(
  id_geek numeric not null,
  id_interest numeric not null,
  FOREIGN KEY(id_geek) REFERENCES public.geek (id),
  FOREIGN KEY(id_interest) REFERENCES public.interest (id),
  primary key (id_geek, id_interest)
);

create sequence geeke_seq start with 1000;