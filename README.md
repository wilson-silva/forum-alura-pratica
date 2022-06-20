# forum-alura-pratica - API REST e Testes com Spring Boot
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/wilson-silva/forum-alura-pratica/blob/main/LICENSE)

## Sobre o projeto

Esta aplicação tem a função de cadastrar, editar, listar, alterar e excluir tópidos de forum de um
determinado curso, este pequeno projeto serviu para revisar os conceitos visto no curso 
disponibilizado pela Alura.
Devido algumas alterações do Spring desde a data de criação do curso, o desenvolvimento foi bem desafiador
uma vez que tinha que pesquisar e encontrar a solução de problemas relacionados a versões.

Com este curso acabei entrando em contato com vários
temas como:
- API REST
- Segurança via JWT para poder tornar a api Stateless
- Cache
- Monitoramento a partir do Spring Boot Admin /Actuator
- Testes em Repository e Controller
- Profiles (para testar módulo de teste adicionar as runs configurations ->
  Modify Options -> add VM options e adicionar -D.spring.profiles.active=dev),
  assim não precisará se autenticar.

## Como executar o projeto

Pré-requisitos: 

* Java 17 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Intellj IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.

```bash

# clonar repositório
git clone https://github.com/wilson-silva/forum-alura-pratica

# entrar na pasta do projeto forum-pratica
cd forum-pratica ou abrir o bash dentro da pasta

# executar o projeto
./mvnw spring-boot:run

```

## Como testar o projeto
### Swagger documentação 
OBS: Se quiser poderá testar pelo POSTMAN.

```bash
# para acessar a documentação desta API
localhost:8080/swagger-ui.html

# obs: para autenticar endpoints apos gerar o token deve colocar "Bearer" no campo
"Header para token JWT" antes do token:
Bearer xxxxx...

# usuario e senha para acessar a aplicação
Roles : ROLE_MODERADOR, ROLE_ALUNO
Somente o moderador pode excluir um tópico.

MODERADOR:
usuario: moderador@email.com
senha":"123456"

ALUNO:
usuario: aluno@email.com
senha: 123456
```

![Modelo Conceitual](https://github.com/wilson-silva/forum-alura-pratica/blob/main/tela1.png)


## Tecnologias utilizadas
### Back end
- Java
- Spring MVC
- Spring Boot
- Spring Data
- JPA/Hibernet
- Bean Validation
- Flyway
- Maven
- Mysql
- Swagger


## Autor
Wilson Gimenes da Silva
https://github.com/wilson-silva/forum-alura-pratica