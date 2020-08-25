
/* Estado Civil */
insert into civil_status(name_civil_status) values('Casado/a'),('Soltero/a'),('Viudo/a'),('Compronetido/a');

/* Sexos */
insert into sexs(name_sex) values('Varón'),('Mujer'),('Otro'),('Me gustaria no responder.');

/* Distritos */
insert into districts(name_district) values ('Ancon');
insert into districts(name_district) values ('Ate');
insert into districts(name_district) values ('Barranco');
insert into districts(name_district) values ('Breña');
insert into districts(name_district) values ('Carabayllo');
insert into districts(name_district) values ('Chaclacayo');
insert into districts(name_district) values ('Cieneguilla');
insert into districts(name_district) values ('Comas');
insert into districts(name_district) values ('Chorrillos');
insert into districts(name_district) values ('El Agostino');
insert into districts(name_district) values ('Huaycan');
insert into districts(name_district) values ('Independencia');
insert into districts(name_district) values ('Jesus Maria');
insert into districts(name_district) values ('La Molina');
insert into districts(name_district) values ('La Victoria');
insert into districts(name_district) values ('Lince');
insert into districts(name_district) values ('Lima');
insert into districts(name_district) values ('Los Olivos');
insert into districts(name_district) values ('Lurigancho');
insert into districts(name_district) values ('Lurin');
insert into districts(name_district) values ('Magdalena del mar');
insert into districts(name_district) values ('Miraflores');
insert into districts(name_district) values ('Pachacamac');
insert into districts(name_district) values ('Pucasana');
insert into districts(name_district) values ('Pueblo Libre');
insert into districts(name_district) values ('Puente Piedra');
insert into districts(name_district) values ('Punta Hermosa');
insert into districts(name_district) values ('Punta Negra');
insert into districts(name_district) values ('Rimac');
insert into districts(name_district) values ('San Isidro');
insert into districts(name_district) values ('San Bartolo');
insert into districts(name_district) values ('San Juan de Lurigancho');
insert into districts(name_district) values ('San juan de Miraflores');
insert into districts(name_district) values ('San Luis');
insert into districts(name_district) values ('San Martin de Porres');
insert into districts(name_district) values ('San Miguel');
insert into districts(name_district) values ('Santa Anita');
insert into districts(name_district) values ('Santa Maria del Mar');
insert into districts(name_district) values ('Santa Rosa');
insert into districts(name_district) values ('Santiago de Surco');
insert into districts(name_district) values ('Surquillo');
insert into districts(name_district) values ('Villa el Salvador');
insert into districts(name_district) values ('Villa María del Triunfo');


/* Carreras */
insert into careers(career_name) values ('Administración Empresarial');
insert into careers(career_name) values ('Desarrollo de Sistemas de la Información');
insert into careers(career_name) values ('Mecanica Automotriz');
insert into careers(career_name) values ('Marketing Digital');
insert into careers(career_name) values ('Contabilidad');
insert into careers(career_name) values ('Diseño Grafico');
insert into careers(career_name) values ('Secretaría');
insert into careers(career_name) values ('Redes');

/* Personas */

insert into persons(first_name,last_name,birthday,dni,address,phone,email,id_civil_status,id_district,id_sex,create_date) values('Josselyn','Reyes Cirineo','2000-05-12','92012312','San carlos','901234123','ReyesCirineo@hotmail.com',1,1,2,now());
insert into persons(first_name,last_name,birthday,dni,address,phone,email,id_civil_status,id_district,id_sex,create_date) values('Miguel ','Molina Hernandez','1991-02-12','90123591','San Jose','903123145','miguelm@hotmail.com',1,1,1,now());
insert into persons(first_name,last_name,birthday,dni,address,phone,email,id_civil_status,id_district,id_sex,create_date) values('Franck Junior','Arrieta Guere','2000-11-12','92052312','Alto Marcavalle','901434123','frankj@hotmail.com',1,1,2,now());
insert into persons(first_name,last_name,birthday,dni,address,phone,email,id_civil_status,id_district,id_sex,create_date) values('Piero','Zurita Lermo','1998-12-12','93414512','Av Tupac Amaru','901935631','zuritalermo@hotmail.com',1,1,2,now());
insert into persons(first_name,last_name,birthday,dni,address,phone,email,id_civil_status,id_district,id_sex,create_date) values('Erick Brandom','Cordova Tejeda','1995-05-12','92513172','Block 16','973155123','brandom@hotmail.com',1,3,1,now());
insert into persons(first_name,last_name,birthday,dni,address,phone,email,id_civil_status,id_district,id_sex,create_date) values('Dayana Lucia','Dias Tobar','2000-07-13','03125412','Av San Carloz, ref cruzando el puente','901213123','dayadiaz12@hotmail.com',1,1,2,now());

/* Students */

insert into students(id_career, id_person) values(1,3);
insert into students(id_career, id_person) values(8,6);
insert into students(id_career, id_person) values(2,1);

/* USUARIOS Y ROLES */

insert into users(user_name, password, enabled, uniqueid,id_person) values('admin','$2a$10$EQF58.szubymHpHernWLOu91SyVzOzu6329jJtMaKp0nmNS38WfWO',1,'39bd8b15-2b7c-4559-b803-f71305e4c146',1);
insert into users(user_name, password, enabled, uniqueid,id_person) values('usuario','$2a$10$7Bl7NwRf3iTbL3GbBpvy.e0/jgOvPdVoJSAP2CMrAH3yE4BFKQ0V2',1,'6c1ec1e9-8714-4480-bd49-a214e87b9f4f',2);
insert into users(user_name, password, enabled, uniqueid,id_person) values('usuario2','$2a$10$oT5HZDwi6Pz8dTdc.vxsLOp7FTCDY21URs6RybHgizMQXRxkd.fSe',0,'cc112e3d-3f55-4a3b-9a8f-49fcc27edb14',3);

insert into roles(role_name) values('ROLE_ADMIN');
insert into roles(role_name) values('ROLE_STUDENT');
insert into roles(role_name) values('ROLE_TEACHER');
insert into roles(role_name) values('ROLE_EMPLOYEE');
insert into roles(role_name) values('ROLE_CLIENT');


/* ADMINISTRADOR */
insert into users_roles(users_id, roles_id) values (1,1);
insert into users_roles(users_id, roles_id) values (1,2);
insert into users_roles(users_id, roles_id) values (1,3);
insert into users_roles(users_id, roles_id) values (1,4);
insert into users_roles(users_id, roles_id) values (1,5);

/* USUARIO PRUEBA */
insert into users_roles(users_id, roles_id) values (2,4);

/* USUARIO PRUEBA 2 */
insert into users_roles(users_id, roles_id) values (3,5);