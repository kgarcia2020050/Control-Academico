drop database control_academico;
create database if not exists control_academico;
use control_academico;



-- ----------------------------------------------
-- Tabla instructor
-- ----------------------------------------------
create table if not exists instructor (
	instructor_id INT NOT NULL AUTO_INCREMENT,
	apellidos VARCHAR(45),
	nombres VARCHAR(45),
	direccion VARCHAR(45),
	telefono VARCHAR(8),
	PRIMARY KEY (instructor_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Hernandez', 'Pablo', '1ra ave. 1-50 zona 7', '12345678');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Morales', 'Andree', '2ra ave. 1-47 zona 3', '87654321');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Pérez','Geraldine', '6ta ave. 4-20 zona 12', '14725836');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Armstrong', 'Louis', '7ma calle 6-20 zona 4', '51475865');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Sacario', 'Norma', '28 calle 1-47 zona 3', '55369711');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Chocojay', 'José', '7ma ave. 1-14 zona 7', '41486532');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Humberto', 'Cristian', '4ta ave. 7-4 zona 14', '45253687');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Sona', 'Mayra', 'manzana 1 lote 5 B.lago', '58360025');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Solma', 'Maritza', '8va calle 1-45 zona 16', '88996622');
INSERT INTO instructor (apellidos, nombres, direccion, telefono) VALUES ('Orellana', 'Joel', '1ra avenida 1-48 zona 3', '51180625');


-- ----------------------------------------------
-- Tabla alumnos
-- ----------------------------------------------
CREATE TABLE alumno (
  carne varchar(16) not null,
  apellidos VARCHAR(45),
  nombres VARCHAR(45),
  email VARCHAR(32),
  PRIMARY KEY (carne)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021020,'Pérez','Carlos','carlosgarc@kinal.edu.gt');
INSERT INTO alumno (carne,apellidos,nombres, email) VALUES (2021150,'Gutierrez','Karyn', 'karyg@kinal.edu.gt');
INSERT INTO alumno (carne,apellidos,nombres, email) VALUES (2021225,'Garcia ','Xavier', 'garciaxavier068@kinal.edu.gt');
INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021365, 'Fernandez','Jonathan', 'Fernajona@kinal.edu.gt');
INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021065,'Herrera','David', 'herredav@kinal.edu.gt');
INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021629,'Palma','Andree', 'palmandr@kinal.edu.gt');
INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021175, 'Ordoñez', 'Karol','kaarolordo@kinal.edu.gt');
INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021512,'Rodrigez','Carla', 'rodriguescar@kinal.edu.gt');
INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021086,'Diaz','Alex', 'aledia@kinal.edu.gt');
INSERT INTO alumno  (carne,apellidos,nombres, email) VALUES (2021297,'Moran','Nando', 'morannd@kinal.edu.gt');

-- ----------------------------------------------
-- Tabla carrera_tecnica
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS carrera_tecnica (
	codigo_carrera VARCHAR(128),
	nombre VARCHAR(45),
	PRIMARY KEY (codigo_carrera)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTIN', 'Informática');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTMC', 'Mecánica');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTEC', 'Electrónica en computación');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTEI', 'Electrónica Industrial');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTMT', 'Mecatrónica');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTTG', 'Topografía');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTTC', 'Telecomunicaciones');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTDT', 'Dibujo técnico');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTEL', 'Electricidad');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) VALUES ('CTSN', 'Sonido y música');


-- ----------------------------------------------
-- Tabla salon
-- ----------------------------------------------
create table if not exists salon(
  salon_id int not null auto_increment,
  capacidad int,	
  descripcion varchar(225),
  nombre_salon varchar(255),
  PRIMARY KEY (salon_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into salon (capacidad,descripcion,nombre_salon)
values(35,"Salón de Dibujo","A-0001");
insert into salon (capacidad,descripcion,nombre_salon)
values(35,"Salón de Electrónica en Computación","A-0002");
insert into salon (capacidad,descripcion,nombre_salon)
values(40,"Salón de Electrónica Industrial","A-0003");
insert into salon (capacidad,descripcion,nombre_salon)
values(50,"Salón de Electricidad","A-0004");
insert into salon (capacidad,descripcion,nombre_salon)
values(40,"Salón de Informatica","A-0005");
insert into salon (capacidad,descripcion,nombre_salon)
values(35,"Salón de Mecánica","A-0006");
insert into salon (capacidad,descripcion,nombre_salon)
values(40,"Salón de Mecatrónica","A-0007");
insert into salon (capacidad,descripcion,nombre_salon)
values(50,"Salón de Sonido y Música","A-0008");
insert into salon (capacidad,descripcion,nombre_salon)
values(90,"Salón de Telecomunicacione","A-0009");
insert into salon (capacidad,descripcion,nombre_salon)
values(25,"Salón de Topografía","A-0010");


-- ----------------------------------------------
-- Tabla horario
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS horario (
	horario_id INT NOT NULL AUTO_INCREMENT,
	horario_final TIME,
    horario_inicio TIME,
    PRIMARY KEY(horario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into horario (horario_inicio, horario_final) values ('7:30:00', '8:30:00');
insert into horario (horario_inicio, horario_final) values ('8:30:00', '9:30:00');
insert into horario (horario_inicio, horario_final) values ('9:30:00', '10:30:00');
insert into horario (horario_inicio, horario_final) values ('10:30:00', '11:30:00');
insert into horario (horario_inicio, horario_final) values ('11:30:00', '12:30:00');
insert into horario (horario_inicio, horario_final) values ('1:30:00', '2:30:00');
insert into horario (horario_inicio, horario_final) values ('2:30:00', '3:30:00');
insert into horario (horario_inicio, horario_final) values ('3:30:00', '4:30:00');
insert into horario (horario_inicio, horario_final) values ('4:30:00', '5:30:00');
insert into horario (horario_inicio, horario_final) values ('5:30:00', '6:30:00');


-- ----------------------------------------------
-- Tabla curso
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS curso (
	curso_id INT NOT NULL AUTO_INCREMENT,
    ciclo INT,
    cupo_maximo INT,
    cupo_minimo INT,
    descripcion VARCHAR(255),
    codigo_carrera VARCHAR(128) NOT NULL,
    horario_id INT NOT NULL,
    instructor_id INT NOT NULL,
    salon_id INT NOT NULL,
    PRIMARY KEY (curso_id),
    CONSTRAINT FK_curso_carrera_tecnica
		FOREIGN KEY (codigo_carrera)
        REFERENCES carrera_tecnica (codigo_carrera)
        on delete cascade on update cascade,
	CONSTRAINT FK_curso_horario
		FOREIGN KEY (horario_id)
        REFERENCES horario (horario_id)
        on delete cascade on update cascade,
	CONSTRAINT FK_curso_instructor
		FOREIGN KEY (instructor_id)
        REFERENCES instructor (instructor_id)
        on delete cascade on update cascade,
	CONSTRAINT FK_curso_salon
		FOREIGN KEY (salon_id)
        REFERENCES salon (salon_id)
		on delete cascade on update cascade) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '20', '3', 'Programación', 'CTIN', '1', '1', '5'); 
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '20', '4', 'Reparación de motores ', 'CTMC', '2', '4', '6');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '40', '10', 'Mantenimiento de computadoras', 'CTEC', '3', '7', '2');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '25', '10', 'Circuitos', 'CTEI', '4', '3', '3');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '35', '5', 'Mecatrónica I', 'CTMT', '5', '5', '7');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '20', '5', 'Topografía I', 'CTTG', '6', '6', '10');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '22', '7', 'Telecomunicaciones I', 'CTTC', '7', '8', '9');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '26', '10', 'Plantas y planos I', 'CTDT', '8', '6', '1');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '30', '15', 'Instalaciones Eléctricas I', 'CTEL', '9', '9', '4');
INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ('2021', '20', '2', 'Solfeo y entonación I', 'CTSN', '10', '10', '8');

-- ----------------------------------------------
-- Tabla asignacion_alumno
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS asignacion_alumno(
  asignacion_id varchar(45),
  fecha_asignacion datetime,
  carne VARCHAR(16) NOT NULL,
  curso_id int not null,
 PRIMARY KEY (asignacion_id),
  CONSTRAINT FK_asignacion_alumno_alumno
    FOREIGN KEY (carne)
    REFERENCES alumno (carne)
    on delete cascade
    on update cascade,
  CONSTRAINT FK_asignacion_alumno_curso
    FOREIGN KEY (curso_id)
    REFERENCES curso (curso_id)
    on delete cascade
    on update cascade) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-12', '2021-01-1 12:00:00', '2021225', 1);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-13', '2020-01-3 1:00:00', '2021020', 2);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-14', '2021-01-6 2:00:00', '2021629', 3);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-15', '2021-01-10 3:00:00', '2021086', 4);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-16', '2020-07-24 4:00:00', '2021175', 5);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-17', '2020-06-26 5:00:00', '2021365', 6);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-18', '2020-07-28 6:00:00', '2021297', 7);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-19', '2020-08-15 7:00:00', '2021065', 8);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-20', '2020-09-24 8:00:00', '2021512', 9);
  insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id)
  value('A-21', '2020-10-11 9:00:00', '2021150', 10);
  

create table if not exists nota(id_nota int not null auto_increment,
nombre_actividad varchar(45),
nota_actividad int,
fecha_entrega date,
asignacion_id varchar(45),
constraint fk_asignacion_id foreign key(asignacion_id)
references asignacion_alumno(asignacion_id)
on delete cascade on update cascade,
primary key (id_nota))ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


insert into nota(nombre_actividad,nota_actividad,fecha_entrega,asignacion_id) values("Página web",70,"2021-5-11","A-13");
insert into nota(nombre_actividad,nota_actividad,fecha_entrega,asignacion_id) values("Página web",90,"2021-5-12","A-14");

insert into nota(nombre_actividad,nota_actividad,fecha_entrega,asignacion_id) values("Página web",50,"2021-5-12","A-15");
insert into nota(nombre_actividad,nota_actividad,fecha_entrega,asignacion_id) values("Página web",23,"2021-5-12","A-16");
insert into nota(nombre_actividad,nota_actividad,fecha_entrega,asignacion_id) values("Página web",71,"2021-5-12","A-17");




-- -----------------------------------------------------
-- Tablas Login
-- -----------------------------------------------------
create table if not exists rol(id int not null auto_increment,
descripcion varchar(45),
primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into rol (descripcion) values("Administrador");

create table if not exists usuario(
user varchar(25) not null,
pass varchar(225) not null,
nombre varchar(50),
rol_id_rol int,
constraint fk_rol_id_rol foreign key (rol_id_rol)
references rol(id)on delete cascade on update cascade,
primary key PK_usuario(user))ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO usuario(user, pass, nombre,rol_id_rol) VALUES("root", "YWRtaW4=", "Jorge Pérez",1); -- admin