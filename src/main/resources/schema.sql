DROP TABLE IF EXISTS CLIENTE;
CREATE TABLE CLIENTE ( idclient INTEGER PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(150) NOT NULL, apellidos VARCHAR(150) NOT NULL, dni LONG NOT NULL, direccion VARCHAR(150) NOT NULL);
DROP TABLE IF EXISTS EMPRESA;
CREATE TABLE EMPRESA ( idempresa INTEGER PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(150) NOT NULL, ruc LONG NOT NULL, rubro VARCHAR(150) NOT NULL, direccion VARCHAR(150) NOT NULL);
DROP TABLE IF EXISTS PRODUCTO;
CREATE TABLE PRODUCTO ( idproducto INTEGER PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(150) NOT NULL, description VARCHAR(150) NOT NULL, preciounitario DOUBLE NOT NULL, cantstock LONG NOT NULL);

