CREATE SCHEMA IF NOT EXISTS "dbo";
SET SCHEMA "dbo";
CREATE TABLE IF NOT EXISTS "dbo"."gift" (
	id int IDENTITY(0,1) not null,
	nome varchar(100) NULL,
	CONSTRAINT gift_PK PRIMARY KEY (id)
);