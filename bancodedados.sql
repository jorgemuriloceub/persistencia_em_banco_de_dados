CREATE DATABASE escola;

USE escola;

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    idade INT
);

CREATE TABLE curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    duracao_horas INT
);

USE escola;

-- Inserindo o primeiro aluno (ID provavelmente será 1)
INSERT INTO aluno (nome, email, idade) VALUES 
('Mariana Lima', 'mariana.l@exemplo.com', 22);

-- Inserindo o segundo aluno (ID provavelmente será 2)
INSERT INTO aluno (nome, email, idade) VALUES 
('João Pedro', 'joao.p@exemplo.com', 28);

-- Inserindo o terceiro aluno (ID provavelmente será 3)
INSERT INTO aluno (nome, email, idade) VALUES 
('Sofia Mendes', 'sofia.m@exemplo.com', 19);

-- Para verificar os dados inseridos
SELECT * FROM aluno;

USE escola;

-- Inserindo o primeiro curso (ID provavelmente será 1)
INSERT INTO curso (nome, duracao_horas) VALUES 
('Introdução ao Spring Boot', 60);

-- Inserindo o segundo curso (ID provavelmente será 2)
INSERT INTO curso (nome, duracao_horas) VALUES 
('Modelagem de Dados Avançada', 40);

-- Inserindo o terceiro curso (ID provavelmente será 3)
INSERT INTO curso (nome, duracao_horas) VALUES 
('Desenvolvimento Web Frontend', 120);

-- Para verificar os dados inseridos
SELECT * FROM curso;
