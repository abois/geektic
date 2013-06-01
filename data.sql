insert into public.geek values (1,'Jean', 'Dupond', 'jd@orange.fr', 0);
insert into public.geek values (2,'Andre', 'Charcot', 'acharcot@free.fr', 0);
insert into public.geek values (3,'Alice', 'Marinelo', 'alice.marinelo@hotmail.fr', 1);

insert into public.interest values (1, 'python');
insert into public.interest values (2, 'java');
insert into public.interest values (3, 'JPA');

insert into public.geek_interest values (1,3);
insert into public.geek_interest values (1,2);
insert into public.geek_interest values (2,1);
insert into public.geek_interest values (3,1);
insert into public.geek_interest values (3,2);
insert into public.geek_interest values (3,3);