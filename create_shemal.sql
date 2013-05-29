drop table geek if exists cascade;
drop sequence geek_seq if exists;
drop sequence representation_seq if exists;

create table geek(
	id numeric not null,
	nom varchar(255) not null,
	prenom varchar(255) not null,
	email varchar(255) not null,
	primary key (id)
);

create sequence geeke_seq start with 1000;