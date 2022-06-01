

CREATE TABLE IF NOT EXISTS tb_especie
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
     
    CONSTRAINT tb_especie_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_raca
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
	id_especie bigint NOT NULL,
     
	 
    CONSTRAINT tb_raca_pkey PRIMARY KEY (id),
	CONSTRAINT tb_raca_tb_especie_fkey FOREIGN KEY (id_especie) REFERENCES tb_especie (id)
	
);

CREATE TABLE IF NOT EXISTS tb_animal
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
    data_inclusao timestamp without time zone,
	data_nascimento timestamp without time zone,
    porte integer NOT NULL,
	genero integer NOT NULL,
    status integer NOT NULL,
	idade integer NOT NULL,
	id_raca bigint NOT NULL,
	cor varchar(255) NOT NULL,
    descricao text NOT NULL,
	--proprietario integer NOT NULL,
    --usuario_ref varchar(255) NOT NULL,
	--adotado_por bigint,
	
    CONSTRAINT tb_animal_pkey PRIMARY KEY (id),
	CONSTRAINT tb_animal_tb_raca_fkey FOREIGN KEY (id_raca) REFERENCES tb_raca (id)
);


CREATE TABLE IF NOT EXISTS tb_imagem
(
    id bigint NOT NULL,
    descricao varchar(255) NOT NULL,
    img bytea NOT NULL,
   	id_animal bigint NOT NULL,
	
    CONSTRAINT tb_imagem_pkey PRIMARY KEY (id),
	CONSTRAINT tb_imagem_tb_animal_fkey FOREIGN KEY (id_animal) REFERENCES tb_animal (id)

);

CREATE TABLE IF NOT EXISTS tb_estado
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
    sigla varchar(2) NOT NULL,
	
    CONSTRAINT tb_estado_pkey PRIMARY KEY (id)

);

CREATE TABLE IF NOT EXISTS tb_cidade
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
    id_estado bigint NOT NULL,
	
    CONSTRAINT tb_cidade_pkey PRIMARY KEY (id),
    CONSTRAINT tb_cidade_tb_estado_fkey FOREIGN KEY (id_estado) REFERENCES tb_estado (id)


);



CREATE SEQUENCE IF NOT EXISTS tb_especie INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_raca INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_animal INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_imagem INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_estado INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_cidade INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 


CREATE SEQUENCE IF NOT EXISTS hibernate_sequence INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807 START 1 CACHE 1;