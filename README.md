# ForumHub

## Descrição
Bem-vindo ao nosso desafio de back-end, **ForumHub**! Este projeto consiste na criação de uma API REST utilizando Spring, que serve como protótipo de um fórum. No ForumHub, usuários podem criar, listar, atualizar e deletar tópicos, bem como responder a esses tópicos. O objetivo é simular o funcionamento de um fórum, como o usado por alunos e alunas da Alura para tirar dúvidas sobre cursos e projetos.

## Funcionalidades
Nossa API oferece as seguintes funcionalidades:
- **Criar um novo tópico**
- **Listar todos os tópicos**
- **Mostrar detalhes de um tópico específico**
- **Atualizar um tópico**
- **Deletar um tópico**
- **Registrar novos usuários**
- **Login de usuários**
- **Responder a tópicos**
- **Listar cursos**
- **Registrar novos cursos**

## Tecnologias Utilizadas
Este projeto utiliza uma série de tecnologias modernas para garantir eficiência, segurança e escalabilidade:

- **Spring Boot**: Para a criação da API REST e gerenciamento de dependências.
- **Spring Security**: Para autenticação e autorização.
- **JWT (JSON Web Token)**: Para autenticação segura.
- **Hibernate**: Para mapeamento objeto-relacional.
- **MySQL**: Como banco de dados relacional.
- **Maven**: Para gerenciamento de dependências.
- **Lombok**: Para reduzir a verbosidade do código.
- **Flyway**: Para migração de banco de dados.
- **SpringDoc OpenAPI**: Para documentação da API.

### Dependências
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>

<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-mysql</artifactId>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>com.auth0</groupId>
    <artifactId>java-jwt</artifactId>
    <version>4.2.1</version>
</dependency>

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>

```


## Endpoints da API

### Tópicos
- **Criar Tópico**
  - **POST /topicos**
  - Request Body: `TopicDTO`
- **Listar Tópicos**
  - **GET /topicos**
  - Query Parameter: `pageable`
- **Mostrar Detalhes de Tópico**
  - **GET /topicos/{id}**
  - Path Variable: `id`
- **Atualizar Tópico**
  - **PUT /topicos/{id}**
  - Path Variable: `id`
  - Request Body: `UpdateTopicDTO`
- **Deletar Tópico**
  - **DELETE /topicos/{id}**
  - Path Variable: `id`

### Usuários
- **Registrar Usuário**
  - **POST /user/register**
  - Request Body: `UserDTO`
- **Login de Usuário**
  - **POST /user/login**
  - Request Body: `AuthenticationDTO`

### Respostas
- **Criar Resposta**
  - **POST /topicos/{id}/resposta**
  - Path Variable: `id`
  - Request Body: `ResponseDataDTO`

### Cursos
- **Listar Cursos**
  - **GET /cursos**
  - Query Parameter: `pageable`
- **Registrar Curso**
  - **POST /cursos**
  - Request Body: `CursoDTO`

## Segurança
A API utiliza autenticação baseada em JWT. Para acessar os endpoints protegidos, é necessário incluir o token JWT no header da requisição.

## Contato
Para mais informações, entre em contato com nosso time de backend:
- **Nome**: Time Backend
- **Email**: dinisde@gmail.com

## Licença
Este projeto está licenciado sob a licença Apache 2.0. Veja o arquivo [LICENSE](http://voll.med/api/licenca) para mais detalhes.

## Tecnologias Utilizadas

![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/-Spring%20Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![JWT](https://img.shields.io/badge/-JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white)
![Hibernate](https://img.shields.io/badge/-Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/-Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Lombok](https://img.shields.io/badge/-Lombok-7F52FF?style=for-the-badge&logo=lombok&logoColor=white)
![Flyway](https://img.shields.io/badge/-Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
![SpringDoc OpenAPI](https://img.shields.io/badge/-SpringDoc%20OpenAPI-3C873A?style=for-the-badge&logo=spring&logoColor=white)
