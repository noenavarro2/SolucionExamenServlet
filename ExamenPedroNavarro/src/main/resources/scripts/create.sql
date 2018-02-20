create table IF NOT EXISTS consolas(
	ID varchar(25) PRIMARY KEY,
	nombre varchar(25),
	empresa varchar(25)
);
create table IF NOT EXISTS empresas(
	ID varchar(25) PRIMARY KEY,
	nombre varchar(25),
	fechaCreacion date
);
create table IF NOT EXISTS videojuegos(
	ID varchar(25) PRIMARY KEY,
	titulo varchar(25),
	edad varchar(25),
	fechaLanzamiento date
);