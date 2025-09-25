# TUTORIAL

#### Este repositório tem como objetivo ensinar de maneira detalhada o processo de conexão com banco de dados MySQL com eclipse

Caso você não tenha o seu MySQL Workbench instalado: (https://dev.mysql.com/downloads/workbench/)

Caso você não tenha o seu Eclipse e JDK instalado: (https://www.eclipse.org/downloads/)

### Foi criado o usuário como:

Usuário: Root

Senha: Projeto!1

#### Comandos para a criação do DB no MySQL:

create database db_senhas;
use db_senhas;

create table dados_senhas(
    -> id int auto_increment not null primary key,
    -> nomecompleto varchar(45) not null,
    -> cpf varchar(14) not null,
    -> email varchar(60) not null),
    -> cargo varchar(40) not null),
    -> login varchar(45) not null),
    -> senha varchar(45) not null); 

create table dados_equipes(
    -> id int auto_increment not null primary key,
    -> nomeeqp varchar(45) not null,
    -> descricaoeqp varchar(45) not null,
    -> membros varchar(45) not null); 

create table dados_projetos(
    -> id int auto_increment not null primary key,
    -> nomepj varchar(45) not null,
    -> descricaopj varchar(45) not null,
    -> datainicio varchar(10) not null,
    -> datatermino varchar(10) not null,
    -> status varchar(45) not null);
