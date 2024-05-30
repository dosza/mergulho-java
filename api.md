## RH API v0.1.0 ##

### Métodos GET ### 

#### Listar todos os funcionarios ####
http://localhost:8080/funcionarios 


#### Buscar um funcionário pelo id  ####
http://localhost:8080/funcionarios/{funcionarioId}

### Métodos POST ###
#### Criar funcionário ####
#### Parâmetros (body) ####
Obs: enviar no corpo da requisição (body) em formato JSON.

Parâmetros | Tipo   | Valor
-----------|--------|-----------
nome        | string | Nome de funcionario
email       | string | email@server.com
salario     | numeral | 12000
dataAdmissao| string   |YYYY-MM-DD
status      | string    | ATIVO\|INATIVO

http://localhost:8080/funcionarios/{funcionarioId}

### Método PUT ###

#### Atualizar dados de funcionário (id) ####

http://localhost:808/funcionarios/{funcionarioId}

### Método DELETE ###
1.  Deletar funcionário pelo (id)

## Diferenças desse projeto ##

Recurso		|Projeto original   | v0.1.0
---------------	|---------------|
Banco de dados | H2	| MySQL	|
Docker compose para MySQL | ❌️	|✅️
Método DELITE | ❌️	|✅️