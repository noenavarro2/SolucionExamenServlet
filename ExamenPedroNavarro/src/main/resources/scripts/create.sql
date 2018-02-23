create table IF NOT EXISTS consoles(
	ID varchar(25) PRIMARY KEY,
	name varchar(25),
	company varchar(25)
);
create table IF NOT EXISTS company(
	ID varchar(25) PRIMARY KEY,
	name varchar(25),
	dateLaunch date
);
create table IF NOT EXISTS videogames(
	ID varchar(25) PRIMARY KEY,
	title varchar(25),
	date varchar(25),
	launchDate date
);
