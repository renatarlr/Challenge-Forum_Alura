create table topico
(

    id           bigint       not null auto_increment,
    titulo       varchar(100) not null,
    mensagem     varchar(200) not null,
    data_criacao date        ,
    status       varchar(100),
    autor        varchar(100) not null,
    curso        varchar(100),
    primary key (id)
);