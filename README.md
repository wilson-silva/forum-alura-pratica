# Api_Forum
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/wilson-silva/forum-alura-pratica/blob/main/LICENSE)

## Sobre o projeto

  Esta aplicação tem a função de cadastrar, editar, listar, alterar e excluir tópidos de forum de um
determinado curso. 
  Este pequeno projeto serviu para revisar os conceitos visto no curso disponibilizado pela Alura sobre Spring Boot.
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

## Autenticação

Roles : ROLE_MODERADOR, ROLE_ALUNO
Somente o moderador pode excluir um tópico.

MODERADOR:
````
{
    "usuario":"moderador@email.com",
    "senha":"123456"
}
````

ALUNO:
```
{
    "usuario":"aluno@email.com",
    "senha":"123456"
}
```


## Swagger endpoints

OBS: Se quiser poderá testar pelo POSTMAN.

Para acessar a documentação desta API
Acesso: localhost:8080/swagger-ui.html

Obs: para autenticar endpoints apos gerar o token deve colocar "Bearer" no campo
"Header para token JWT" antes do token:

Bearer xxxxx...


## Tecnologias e ferramentas utilizadas
- Java
- Spring MVC
- Spring Boot
- Spring Data
- JPA/Hibernet
- Bean Validation
- Flyway
- Maven
- Mysql
- Intellij
- Swagger


## Autor

Wilson Gimenes da Silva

https://github.com/wilson-silva/forum-alura-pratica
