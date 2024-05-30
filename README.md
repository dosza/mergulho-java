

# Mergulho Java

 Códigos ensinados no evento mergulho java da Algaworks

# Índice #

1.  [API RH v0.1.0](#1-api-rh-v0-1-0)
2.  [Diferenças deste projeto](#2-diferenças-deste-projeto)
   1. [Diferenças de implementação](#2-1-diferenças-de-implementação)
      1. [Getters and Setters](#2-1-1-getters-and-setters)
      2. [Equals and HashCode](#2-1-2-equals-and-hashcode)
3. [Docker](#3-docker)
   1. [Estrutura de um projeto docker](#3-1-estrutura-de-um-projeto-docker)
   2. [Pré-requisitos](#3-2-pré-requisitos)
   3. [.env](#3-3--arquivo--env)
      1. [Configurando o arquivo .env na raiz do repositório](#3-3-1-configurando-o-arquivo--env-na-raiz-do-repositório)
   4. [compose.yaml](#3-4-compose-yaml)
   5. [Executando o projeto com Docker](#3-5-executando-o-projeto-com-docker)
      1. [Executando apenas o container MySQL](#3-5-1-executando-apenas-o-container-mysql)
   6. [Reconstruindo a imagem docker da aplicação](#3-6-reconstruindo-a-imagem-docker-da-aplicação)
   7. [Paralizando o projeto](#3-7-paralizando-o-projeto)
   8. [Dica](#3-8-dica)
4. [Notas de aula](#4-notas-de-aula)
5. [Referências](#5-referências)


## 1. API RH v0.1.0 ##
Link da  especificação da [API](api.md)

## 2. Diferenças deste projeto ##

Recurso                             |Projeto original   | v0.1.0
------------------------------------|-------------------|---------------
Banco de dados                      | H2\*              | MySQL 
Docker compose para MySQL           | ❌️                | ✅️
Docker compose para MYSQL e backend | ❌️                | ✅️
Método HTTP DELETE                  | ❌️                | ✅️

\* [H2](https://h2database.com/html/main.html) é um banco de dados em memória RAM.

### 2.1 Diferenças de implementação ### 

Classe [Funcionario](rh-api/src/main/java/com/algaworks/rh/rhapi/model/Funcionario.java)

#### 2.1.1 Getters and Setters ####

Substitui os métodos ```getters```, ```setters``` pelas respectivas anotações ```@Getter``` e ```@Setter```

#### 2.1.2 Equals and HashCode ####

Substitui os métodos ```equals```, ```hashCode``` pela anotação ```@EqualsAndHashCode```.</br> 
Estes métodos são **fundamentais** para **comparar objetos** da mesma classe</br>

## 3 Docker ##
### 3.1 Estrutura de um projeto docker ###
### 3.2 Pré-requisitos ###
1.  Instalar docker
2.  Instalar docker-compose
3.  Configurar o arquivo [.env](#arquivo-env)
4.  [Executar o projeto](#executando-o-projeto)

### 3.3  Arquivo .env ###

#### 3.3.1 Configurando o arquivo .env na raiz do **repositório** ####
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

### 3.4 compose.yaml ###

O arquivo [compose.yaml](compose.yaml) configura dois serviços.
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
Foram aplicadas configurações especificas em [*application.properties*](rh-api/src/main/resources/application.properties)

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```


### 3.5 Executando o projeto com Docker ###
Note: Estes comandos devem ser executados na pasta raíz do repositório.</br>
Isto levantará um container com mysql e outro executando a aplicação spring

```bash 
docker-compose up
```

#### 3.5.1 Executando apenas o container MySQL ####
Note: será executado o container configurado em [docker-compose.yml](rh-api/docker-compose.yml)</br>

**Dica**: crie um link-simbólico de .env na pasta rh-api

```bash
cd rh-api
ln -s ../.env .env
docker-compose up
```

### 3.6 Reconstruindo a imagem docker da aplicação ###
Gera o container com a imagens atualizadas.

```bash
docker-compose up --build
```

### 3.7 Paralizando o projeto ###

```bash
docker-compose down 
```

### 3.8 Dica ###
Para paralizar o container e deletar arquivos use: 

```bash
docker-compose down --rmi local -v
```

## 4 Notas de aula ##
## 5 Referências ##
[Docker Compose: Spring Boot and MySQL example ](https://www.bezkoder.com/docker-compose-spring-boot-mysql/</br>)</br>
[Connection Spring Boot-MySql : Public Key Retrieval is not allowed](https://stackoverflow.com/questions/57416600/connection-spring-boot-mysql-public-key-retrieval-is-not-allowed)</br>