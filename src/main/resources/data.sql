DROP TABLE IF EXISTS  NISUM_PHONE;
DROP TABLE IF EXISTS  NISUM_USUARIO;

CREATE TABLE NISUM_USUARIO (
 nombre varchar(100), 
 email varchar(100), 
 password varchar(100),
 token varchar(4000), 
 fecha_creacion DATETIME,
 fecha_modificacion DATETIME,
 PRIMARY KEY (email)
);

CREATE TABLE NISUM_PHONE (
 id_phone int not null auto_increment,
 numero int,
 city_Code int,
 country_Code int,
 email varchar(100)
 );
  
 ALTER TABLE public.NISUM_PHONE
 ADD PRIMARY KEY (id_phone);
 
 ALTER TABLE public.NISUM_PHONE
 ADD FOREIGN KEY (email)
 REFERENCES public.NISUM_USUARIO(email);
 
 
 INSERT INTO NISUM_USUARIO (email) values ('hola.cl');
 