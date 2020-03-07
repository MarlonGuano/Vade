CREATE DATABASE SIALC
GO

USE SIALC
GO

/*CREAR TABLAS*/
CREATE TABLE LABORATORIO(
	id_laboratorio			int IDENTITY(1,1)	NOT NULL,
	nombre_laboratorio		nvarchar(80)		NOT NULL,
	maquinas_laboratorio	int					NOT NULL,
	estado_laboratorio		nvarchar(15)		NOT NULL)
GO

CREATE TABLE USUARIO(
	id_usuario				int IDENTITY(1,1)	NOT NULL,
	cedula_usuario			nvarchar(15)		NOT NULL,
	nombre_usuario			nvarchar(80)		NOT NULL,
	apellido_usuario		nvarchar(80)		NOT NULL,
	correo_usuario			nvarchar(90)		NOT NULL,
	usu_usuario				nvarchar(80)		NOT NULL,
	contrasena_usuario		nvarchar(80)		NOT NULL,
	ref_tipo_usuario		int					NOT NULL)
GO

CREATE TABLE TIPO_USUARIO(
	id_tipo_usuario			int IDENTITY(1,1)	NOT NULL,
	nombre_tipo_usuario		nvarchar(80)		NOT NULL)
GO

CREATE TABLE SOLICITUD(
	id_solicitud			int IDENTITY(1,1)	NOT NULL,
	ref_usuario				int					NOT NULL,
	Descripcion_solicitud	nvarchar(100)		NOT NULL,
	estado_solicitud		nvarchar(15)		NOT NULL)
GO

CREATE TABLE REGISTRO(
	id_registro				int IDENTITY(1,1)	NOT NULL,
	ref_usuario_super		int					NOT NULL,
	ref_solicitud			int					NOT NULL,
	ref_laboratorio			int					NOT NULL,
	fecha_registro			date				NOT NULL,
	hora_registtro			time				NOT NULL)
GO

/*ASIGNAR PK */

ALTER TABLE LABORATORIO
ADD
CONSTRAINT pk_laboratorio PRIMARY KEY(id_laboratorio)
GO

ALTER TABLE USUARIO
ADD
CONSTRAINT pk_usuario PRIMARY KEY(id_usuario)
GO

ALTER TABLE TIPO_USUARIO
ADD
CONSTRAINT pk_tipo_usuario PRIMARY KEY(id_tipo_usuario)
GO

ALTER TABLE SOLICITUD
ADD
CONSTRAINT pk_solicitud PRIMARY KEY(id_solicitud)
GO

ALTER TABLE REGISTRO
ADD
CONSTRAINT pk_registro PRIMARY KEY(id_registro)
GO

/*ASIGNAR FK */

ALTER TABLE USUARIO
ADD
CONSTRAINT fk_tipo_usuario FOREIGN KEY(ref_tipo_usuario) REFERENCES TIPO_USUARIO(id_tipo_usuario)
GO

ALTER TABLE SOLICITUD
ADD
CONSTRAINT fk_usuario FOREIGN KEY(ref_usuario) REFERENCES USUARIO(id_usuario)
GO

ALTER TABLE REGISTRO
ADD
CONSTRAINT fk_usuario_s		FOREIGN KEY(ref_usuario_super)	REFERENCES USUARIO(id_usuario),
CONSTRAINT fk_solicitud		FOREIGN KEY(ref_solicitud)		REFERENCES SOLICITUD(id_solicitud),
CONSTRAINT fk_laboratorio	FOREIGN KEY(ref_laboratorio)	REFERENCES LABORATORIO(id_laboratorio)
GO
