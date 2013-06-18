insert into public.geek values (1,'Jean', 'Dupond', 'jd@orange.fr', 0, 'password', null, null);
insert into public.geek values (2,'Andre', 'Charcot', 'acharcot@free.fr', 0, 'password', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur malesuada diam vitae mi tempor, id vestibulum lorem ullamcorper. Sed a placerat diam. Nam cursus purus nec ultrices feugiat. Nam porta dui sit amet massa faucibus, a porta lorem congue. Quisque cursus feugiat risus, at fermentum tortor egestas id. Phasellus at nisl sit amet velit dapibus iaculis. Ut suscipit urna at urna malesuada, eu semper quam molestie. Nunc sit amet cursus lectus. Aliquam sed consectetur augue, ac lacinia urna. Vivamus convallis dui id dui tempor rhoncus. Cras nec est orci. Sed at posuere erat. Vivamus eget est augue. Donec felis urna, facilisis id tempus eget, elementum eu nibh. Fusce ut risus a turpis condimentum pretium.', null);
insert into public.geek values (3,'Alice', 'Marinelo', 'alice.marinelo@hotmail.fr', 1, 'password', 'Phasellus ac purus interdum, aliquet odio sit amet, molestie nisl. Morbi molestie ultrices dapibus. Fusce mollis sem molestie urna elementum, non varius dui laoreet. Suspendisse potenti. Morbi fermentum, erat eu fringilla porta, nisi orci imperdiet nisi, in cursus lacus mauris sit amet nunc. Etiam dignissim magna eget dui consequat ultrices. Donec at leo feugiat elit mattis venenatis. Sed elementum massa neque, a vehicula massa congue sit amet. Vivamus ac nibh quis nulla vestibulum iaculis. Suspendisse a tortor arcu. Nullam sollicitudin nisl ligula, eu feugiat mi bibendum non. ', null);
insert into public.geek values (4,'Bob', 'Marques', 'robert@orange.fr', 0, 'password', null, null);
insert into public.geek values (5,'Charles', 'Etangsale', 'charlot@orange.fr', 0, 'password', null, null);
insert into public.geek values (6,'Jessica', 'Marinelo', 'jessy@live.fr', 1, 'password', null, null);
insert into public.geek values (7,'Aline', 'Dupont', 'aline.dupont@sfr.fr', 1, 'password', null, null);
insert into public.geek values (8,'Bernadette', 'Martin', 'martinbernadette@hotmail.com', 1, 'password', null, null);
insert into public.geek values (9,'Jacqueline', 'Richard', 'jackyrichard@free.fr', 1, 'password', 'Nullam in interdum felis. Sed iaculis metus id odio euismod, pretium sollicitudin lorem posuere. Suspendisse a rhoncus neque. Nulla ut nisi id eros vestibulum bibendum. Suspendisse in augue ante. Nulla tincidunt in eros sit amet varius. Praesent rhoncus massa nisl, vel suscipit purus dignissim ut. Aenean lorem sem, pretium quis erat et, facilisis tempus nunc. Morbi ac arcu et dolor gravida euismod. Nunc feugiat, augue ut vestibulum facilisis, quam mi vehicula quam, quis laoreet ipsum nisi vitae leo. ', null);
insert into public.geek values (10,'Nicolas', 'Perrier', 'perrier.nico@hotmail.fr', 0, 'password', 'Sed dictum risus at viverra varius. Mauris nec dolor hendrerit, varius lacus vel, pulvinar eros. Mauris massa eros, pharetra vel quam vel, aliquet congue erat. Suspendisse dictum adipiscing risus, non tempor leo tempor nec. Fusce leo nunc, porta at diam a, pellentesque molestie magna. Vivamus id augue a dolor tristique rhoncus quis in enim. Aenean in nibh id diam fermentum imperdiet. Praesent pulvinar at massa vitae facilisis. Nunc eu feugiat est. Proin sagittis ornare leo, quis euismod urna iaculis in. Phasellus mattis semper rhoncus. Vivamus tempor vestibulum hendrerit. Duis at dolor eu tellus laoreet pharetra. Morbi in nunc ullamcorper, eleifend lectus eu, congue arcu. ', null);

insert into public.interest values (1, 'Python');
insert into public.interest values (2, 'Java');
insert into public.interest values (3, 'JPA');
insert into public.interest values (4, 'PHP');
insert into public.interest values (5, 'Maven');
insert into public.interest values (6, 'Jeux video');
insert into public.interest values (7, 'Linux');
insert into public.interest values (8, 'Apple');
insert into public.interest values (9, 'Android');
insert into public.interest values (10, 'Apache');
insert into public.interest values (11, 'Open Source');
insert into public.interest values (12, 'Ninja Squad');
insert into public.interest values (13, 'C#');
insert into public.interest values (14, 'Microsoft');
insert into public.interest values (15, '.NET');
insert into public.interest values (16, 'SQL');
insert into public.interest values (17, 'Internet');
insert into public.interest values (18, 'Django');

insert into public.geek_interest values (1,18);
insert into public.geek_interest values (1,1);
insert into public.geek_interest values (1,17);
insert into public.geek_interest values (1,10);

insert into public.geek_interest values (2,7);
insert into public.geek_interest values (2,17);
insert into public.geek_interest values (2,18);
insert into public.geek_interest values (2,3);

insert into public.geek_interest values (3,12);
insert into public.geek_interest values (3,5);

insert into public.geek_interest values (4,18);
insert into public.geek_interest values (4,8);

insert into public.geek_interest values (5,1);
insert into public.geek_interest values (5,10);
insert into public.geek_interest values (5,7);
insert into public.geek_interest values (5,14);

insert into public.geek_interest values (6,2);
insert into public.geek_interest values (6,3);
insert into public.geek_interest values (6,12);

insert into public.geek_interest values (7,1);
insert into public.geek_interest values (7,18);
insert into public.geek_interest values (7,12);
insert into public.geek_interest values (7,2);

insert into public.geek_interest values (8,1);
insert into public.geek_interest values (8,7);

insert into public.geek_interest values (9,18);
insert into public.geek_interest values (9,1);

insert into public.geek_interest values (10,18);
insert into public.geek_interest values (10,1);
insert into public.geek_interest values (10,13);