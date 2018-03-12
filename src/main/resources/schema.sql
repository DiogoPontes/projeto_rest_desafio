DROP TABLE IF EXISTS setor;
 
CREATE TABLE IF NOT EXISTS setor (
  id              INT     NOT NULL PRIMARY KEY,
  descricao    	  VARCHAR(200) NOT NULL
);

DROP TABLE IF EXISTS colaborador;
 
CREATE TABLE IF NOT EXISTS colaborador (
  id              INT     NOT NULL PRIMARY KEY,
  cpf       	  VARCHAR(200) NOT NULL,
  nome            VARCHAR(200) NOT NULL,
  telefone        VARCHAR(200) NOT NULL,
  email			  VARCHAR(200) NOT NULL,
  setor           INT     NOT NULL
);