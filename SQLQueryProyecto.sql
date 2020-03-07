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
/*STORED PROCEDURES*/

CREATE PROCEDURE INSERTAR_USUARIO
	@cedula			nvarchar(15),
	@nombre			nvarchar(80),
	@apellido		nvarchar(80),
	@correo			nvarchar(90),
	@usuario		nvarchar(80),
	@contrasena		nvarchar(80),
	@tipo_usuario	int
AS
	INSERT INTO USUARIO (cedula_usuario,nombre_usuario,apellido_usuario,correo_usuario,usu_usuario,contrasena_usuario,ref_tipo_usuario)
	VALUES (@cedula,@nombre,@apellido,@correo,@usuario,@contrasena,@tipo_usuario)
GO


CREATE PROCEDURE INSERTAR_TIPO_USUARIO
	@nombre nvarchar(80)
AS
	INSERT INTO TIPO_USUARIO (nombre_tipo_usuario)
	VALUES (@nombre)
GO

CREATE PROCEDURE INSERTAR_LABORATORIO
	@nombre		nvarchar(80),
	@maquinas	int,
	@estado		nvarchar(15)
AS
	INSERT INTO LABORATORIO(nombre_laboratorio,maquinas_laboratorio,estado_laboratorio)
	VALUES (@nombre,@maquinas,@estado)
GO

CREATE PROCEDURE INSERTAR_SOLICITUD
	@usuario		int,
	@descripcion	nvarchar(100)
AS
	INSERT INTO SOLICITUD(ref_usuario,Descripcion_solicitud,estado_solicitud)
	VALUES (@usuario,@descripcion,'NUEVA')
GO

CREATE PROCEDURE ACTUALIZAR_ESTADO_SOLICITUD
	@id_solicitud int,
	@estado nvarchar(15)
AS
	UPDATE SOLICITUD SET estado_solicitud = @estado WHERE id_solicitud = @id_solicitud
GO

CREATE PROCEDURE INSERTAR_REGISTRO
	@super_usuario int,
	@solicitud int,
	@laboratorio int
AS
	INSERT INTO REGISTRO(ref_usuario_super,ref_solicitud,ref_laboratorio,fecha_registro,hora_registtro)
	VALUES (@super_usuario,@solicitud,@laboratorio,convert (date,GETDATE()),convert (time,GETDATE()))
	UPDATE LABORATORIO SET estado_laboratorio = 'NO DISPONIBLE' WHERE id_laboratorio = @laboratorio  
GO

CREATE VIEW LABORATORIOS_DISPONIBLES
AS
SELECT L.id_laboratorio, L.nombre_laboratorio
FROM LABORATORIO L
WHERE L.estado_laboratorio = 'DISPONIBLE'
GO

CREATE PROCEDURE LISTADO_LABORATORIOS_NO_DISPONIBLES
@fecha date
AS
SELECT L.nombre_laboratorio, L.estado_laboratorio,U.nombre_usuario,R.hora_registtro
FROM LABORATORIO AS L	INNER JOIN REGISTRO		AS R ON		L.id_laboratorio = R.ref_laboratorio
						INNER JOIN SOLICITUD	AS S ON		S.id_solicitud	= R.ref_solicitud 
						INNER JOIN USUARIO		AS U ON		U.id_usuario = S.ref_usuario
WHERE R.fecha_registro = @fecha
GO

CREATE VIEW LISTADO_TODOS_LABORATORIOS
AS
SELECT * FROM LABORATORIO
GO

CREATE VIEW LLENARCOMBO_USUARIO
AS
SELECT * FROM TIPO_USUARIO
GO
CREATE VIEW LLENARCOMBO_SOLICITUD
AS
SELECT id_solicitud FROM SOLICITUD WHERE estado_solicitud = 'NUEVA'
GO
CREATE PROCEDURE  VERIFICACION_LOGIN
@usuario nvarchar(80)
AS
SELECT id_usuario, usu_usuario, contrasena_usuario,cedula_usuario, nombre_usuario,apellido_usuario,tp.nombre_tipo_usuario 
FROM USUARIO u INNER JOIN TIPO_USUARIO tp ON u.ref_tipo_usuario = tp.id_tipo_usuario
WHERE usu_usuario = @usuario
GO
CREATE VIEW SOLICITUDES_NUEVAS
AS
SELECT S.id_solicitud,U.nombre_usuario,U.apellido_usuario,S.Descripcion_solicitud,S.estado_solicitud
FROM SOLICITUD S INNER JOIN USUARIO U ON S.ref_usuario=U.id_usuario
WHERE S.estado_solicitud = 'NUEVA'
GO