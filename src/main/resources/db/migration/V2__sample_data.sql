insert into users (name, surname, username, email, password, activation_hash) values ('Jan', 'Nowak', 'jnowak', 'jnowak@wp.pl', '$2a$10$duQWxXeeoPsSC1YZ2MAK3uiHjcw41hOR/ZNySiiKpiRfF.9Hzxsju', '82202c7616504a96856be06766ac0d31' );
insert into users (name, surname, username, email, password, activation_hash) values ('Anna', 'Kot', 'akot', 'akot@wp.pl', '$2a$10$TG9fWXL/7kJlMTHIgpdD9OlTz8XAcTXncEw7ETAYsUSpzx9Tw4.62', '329bea9b03304e28ac0c491f64a4102a' );

insert into roles (name) values ( 'ROLE_ADMIN' ), ('ROLE_USER'); --rola musi mieć przedrostek, w innym wypadku spring odczyta to jako privilige albo authority


insert into user_roles (user_id, role_id) values ( 1,1 ), (2, 2);