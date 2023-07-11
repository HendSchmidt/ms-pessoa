CREATE TABLE pessoa (
    id_pessoa BIGINT NOT NULL AUTO_INCREMENT,
    nm_nome VARCHAR(60) NOT NULL,
    cd_cpf VARCHAR(11) NOT NULL,
    cd_rg VARCHAR(11),
    dt_nascimento DATE NOT NULL,
    nm_sexo VARCHAR(10),
    nm_estado_civil VARCHAR(60),
    in_ativo BIT NOT NULL DEFAULT 1,
    dt_inclusao DATE NOT NULL,
    dt_alteracao DATE,
    PRIMARY KEY (id_pessoa)
);

CREATE INDEX IX01_pessoa ON pessoa (id_pessoa, cd_cpf, dt_nascimento, in_ativo);

ALTER TABLE ms_pessoa.pessoa CHANGE dt_inclusao dt_criacao date NOT NULL;
ALTER TABLE ms_pessoa.pessoa MODIFY COLUMN dt_criacao DATETIME NOT NULL;
ALTER TABLE ms_pessoa.pessoa MODIFY COLUMN dt_alteracao DATETIME NULL;


