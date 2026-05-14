create table autor(
	id uuid not null primary key,
	nome varchar(100) not null,
	data_nascimento date,
	nascionalidade varchar(50)
);

create table livro(
	id uuid not null primary key,
	isbn varchar(20) not null,
	titulo varchar(150) not null,
	data_publicacao date,
	preco numeric(18,2),
	genero varchar(30) not null,
	id_autor uuid not null references autor(id),
		constraint chk_genero check (genero in ('FICCAO','FANTASIA','MISTERIO','ROMAMCE','BIIOGRAFIA'))
);

