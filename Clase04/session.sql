create table tsession(
    id       numeric(10,0) not null,
	codEmp   char(4) not null,
	equipo   varchar(50) not null,
	fecini   date not null,
	fecfin   date null,
    estado   numeric(1,0) not null,
	constraint pk_tsession primary key(id),
	constraint fk_tsession foreign key(codEmp)
		references empleado
);

create table tsession(
    id       numeric(10,0) not null,
	codEmp   char(4) not null,
	equipo   varchar(50) not null,
	fecini   timestamp not null,
	fecfin   timestamp null,
    estado   numeric(1,0) not null,
	constraint pk_tsession primary key(id),
	constraint fk_tsession foreign key(codEmp)
		references empleado
);



create sequence seqSession;








