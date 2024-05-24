
# Mergulho Java

 Códigos ensinados no evento mergulho java da Algaworks


## RH API v0.0.1 ##

### Métodos GET ### 

#### Listar todos os funcionarios ####
http://localhost:8080/funcionarios 


#### Parametros #### 

#### Buscar um funcionário pelo id  ####
http://localhost:8080/funcionarios/{funcionarioId}

### Métodos POST ###
#### Criar funcionário ####
#### Parâmetros  (body) ####
Obs: enviar no corpo da requisição (body) em formato JSON.

Parâmetros | Tipo   | Valor
-----------|--------|-----------
nome        | string | Nome de funcionario
email       | string | email@server.com
salario     | numeral | 12000
dataAdmissao| string   |YYYY-MM-DD
status      | string    | ATIVO\|INATIVO

http://localhost:808/funcionarios/{funcionarioId}

### Método PUT ###
#### Atualizar dados de funcionário (id) ####
http://localhost:808/funcionarios/{funcionarioId}




### Método DELETE ###
1.  Deletar funcionário pelo (id)

## Diferenças desse projeto ##
Projeto original usava o banco de dados H2.<br/>
Este projeto utiliza MYSQL em container.



## compose.yaml ##
Adicionei a string ```allowPublicKeyRetrieval=true``` em *spring.datasource.url*

O arquivo [compose.yaml](compose.yaml) contém dois serviços.
1. mysqldb (configura o banco de dados)
2. app (executa a aplicação spring boot)

```yaml
    environment:
      SPRING_APPLICATION_JSON: '{
        "spring.datasource.url"  : "jdbc:mysql://mysqldb:$MYSQLDB_DOCKER_PORT/$MYSQLDB_DATABASE?useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true",
        "spring.datasource.username" : "$MYSQLDB_USER",
        "spring.datasource.password" : "$MYSQLDB_ROOT_PASSWORD"
      }'
      
  ```

Este projeto utiliza a imagem mysql:latest</br>
Foram aplicadas configurações especificas em *[applications.properties]*(rh-api/src/main/resources/application.properties)

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
## Referências ##
https://www.bezkoder.com/docker-compose-spring-boot-mysql/</br>
https://stackoverflow.com/questions/57416600/connection-spring-boot-mysql-public-key-retrieval-is-not-allowed

## Pré-requisitos ##
1.  Instalar docker
2.  Instalar docker-compose
3.  Configurar o arquivo [.env](#env)

## .env ##

### Configurando o arquivo .env na raiz do **repositório** ###
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
Note: Estes comandos devem ser executados na pasta raíz do repositório.</br>
Isto levantará um container com mysql e outro executando a aplicação spring
```bash 
docker-compose up
```

## Paralizando o projeto ## 

```bash
docker-compose down 
```

## Executando apenas o banco de dados ##
Note: será executado o container configurado em [docker-compose.yml](rh-api/docker-compose.yml)</br>

**Dica**: crie um link-simbólico de .env na pasta rh-api

```bash
cd rh-api
ln -s ../.env .env
docker-compose up
```

## Dica ##
Para paralizar o container e deletar arquivos use: 

```bash
docker-compose down --rmi all -v
```