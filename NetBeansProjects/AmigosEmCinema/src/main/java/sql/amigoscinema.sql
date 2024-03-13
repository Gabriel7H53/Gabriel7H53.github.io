DROP TABLE IF EXISTS Avaliacoes;
DROP TABLE IF EXISTS Amigos;
DROP TABLE IF EXISTS FilmeCompanhiaCinematograficas;
DROP TABLE IF EXISTS FilmeProvedoraStreaming;
DROP TABLE IF EXISTS Filmes;

CREATE TABLE Amigos (
Nome VARCHAR(50) NOT NULL PRIMARY KEY,
Apelido VARCHAR(30),
Sexo VARCHAR(1) NOT NULL,
EstadoCivil INT NOT NULL,
Cidade VARCHAR(50) NOT NULL,
Email VARCHAR(50) NOT NULL,
Whatsapp VARCHAR (30),
Instagram VARCHAR (30));

CREATE TABLE Filmes (
 Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 Titulo VARCHAR(60) NOT NULL,
 Genero INT NOT NULL,
 Ano INT NOT NULL
);


CREATE TABLE FilmeCompanhiaCinematograficas(
OscarMelhorFilme BOOLEAN NOT NULL,
OscarMelhorDiretor VARCHAR(30),
OscarMelhorAtor VARCHAR (30),
OscarMelhorAtriz VARCHAR (30),
FilmeId INT NOT NULL,
FOREIGN KEY (FilmeId) REFERENCES Filmes (Sequencial));

CREATE TABLE FilmeProvedoraStreaming(
ProvedoraStreaming INT NOT NULL,
Producao INT NOT NULL,
TotalEpisodios INT NOT NULL,
FilmeId INT NOT NULL,
FOREIGN KEY (FilmeId) REFERENCES Filmes (Sequencial));

CREATE TABLE Avaliacoes (
Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
AmigoId VARCHAR(50) NOT NULL,
FilmeId INT NOT NULL,
ClassificacaoTrama INT NOT NULL,
ClassificacaoDirecao INT NOT NULL,
ClassificacaoAtuacao INT NOT NULL,
Preferencia INT,
DataHora TIMESTAMP NOT NULL,
FOREIGN KEY (AmigoId) REFERENCES Amigos (Nome) ,
FOREIGN KEY (FilmeId) REFERENCES Filmes (Sequencial)) ;

 
