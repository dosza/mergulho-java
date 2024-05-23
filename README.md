
# Mergulho Java

 Códigos ensinados no evento mergulho java da Algaworks


## RH API v0.0.1 ##

## Diferenças desse projeto ##
Projeto original usava o banco de dados H2.
Este projeto executado em um container construído pelo *docker-compose*



## compose.yaml ##
Adicionei a string *allowPublicKeyRetrieval=true* em  *spring.datasource.url* para resolver problemas de inicialização do SpringBoot

Diferente do tutorial de configuração de spring foram removidas configurações de dialeto *Mysql5* e aplicadas a de *Mysql8*
Utilize a imagem *mysql:latest* no serviço mysqldb

## Referências ##
https://www.bezkoder.com/docker-compose-spring-boot-mysql/
https://stackoverflow.com/questions/57416600/connection-spring-boot-mysql-public-key-retrieval-is-not-allowed
## Pré-requisitos ##
1.  Instalar docker
2.  Instalar docker-compose
3.  Configurar o arquivo .env

## Configurando o arquivo .env na raiz do **repositório** ##
Note: *.env* é um arquivo de variáveis de ambiente (consta no .gitignore)
Substitua password pela respectiva senha do banco de dados.
```ini
MYSQLDB_USER=root
MYSQLDB_ROOT_PASSWORD=password
MYSQLDB_DATABASE=rhapi_db
MYSQLDB_LOCAL_PORT=3307
MYSQLDB_DOCKER_PORT=3306
SPRING_LOCAL_PORT=8080
SPRING_DOCKER_PORT=8080

```
## Executando  o projeto ##

Isto levantará um container com mysql e outro executando a aplicação spring
```bash 
docker-compose up
```

## Paralizando o projeto ## 
```bash
docker-compose down 
```
## Dica ##
Para paralizar o container e deletar arquivos use: 

```bash
docker-compose down --rmi all -v
```