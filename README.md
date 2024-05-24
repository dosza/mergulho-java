
# Mergulho Java

 Códigos ensinados no evento mergulho java da Algaworks

## API RH v0.0.1 ##
Link da  especificação da [API](api.md)

## compose.yaml ##

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
Foram aplicadas configurações especificas em [*application.properties*](rh-api/src/main/resources/application.properties)

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
## Referências ##
[Docker Compose: Spring Boot and MySQL example ](https://www.bezkoder.com/docker-compose-spring-boot-mysql/</br>)</br>
[Connection Spring Boot-MySql : Public Key Retrieval is not allowed](https://stackoverflow.com/questions/57416600/connection-spring-boot-mysql-public-key-retrieval-is-not-allowed)</br>

## Pré-requisitos ##
1.  Instalar docker
2.  Instalar docker-compose
3.  Configurar o arquivo [.env](#env)
4.  [Executar o projeto](#executando-o-projeto)

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
## Executando o projeto ##
Note: Estes comandos devem ser executados na pasta raíz do repositório.</br>
Isto levantará um container com mysql e outro executando a aplicação spring

```bash 
docker-compose up
```

## Reconstruindo a aplicação ##
Gera o container com a imagens atualizadas.

```bash
docker-compose up --build
```

## Paralizando o projeto ## 

```bash
docker-compose down 
```

## Executando apenas o Mysql ##
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