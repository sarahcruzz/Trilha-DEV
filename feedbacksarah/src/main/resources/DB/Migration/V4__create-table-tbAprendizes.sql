create table tb_aprendizes (
    id integer not null auto_increment,
    edv varchar(255),
    email varchar(255),
    ferias bit,
    ativo bit,
    faculdade varchar(255),
    nome varchar(255),
    trilha varchar(255),
    turma varchar(255),
    curso enum ('ADM','DS','MANUFATURA','MECATRONICA'),
    primary key (id)

) engine=InnoDB;
