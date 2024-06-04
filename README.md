# API Web Service :rocket:

## Descrição :scroll:
API REST desenvolvida utilizando Spring Boot e PostgreSQL para alimentar o back-end de uma plataforma de E-commerce

## Operando na nuvem :dash:
- Este serviço está sendo hospedado gratuitamente, portanto, não garante desempenho nem tempo de resposta rapido. :turtle:
- URL: :large_blue_diamond: https://ecommerce-bv6o.onrender.com :large_blue_diamond:


## Endpoint Disponíveis
- User 
- Category
- Product
- Order

## Tecnologias Utilizadas :octopus:
- **Persistência**: JPA Hibernate
- **Database**: PostgreSQL
- **Testes**: JUnit,Mockito,Database H2
- **Container**: Docker

## :rat::rat:Utilizando o Postman para Acesso ao Backend :rat::rat:
O Postman é uma ferramenta poderosa que facilita o teste e a interação com APIs. Recomendo o uso do Postman para explorar e testar os endpoints da API de e-commerce.

## Exemplo de interação

### Inserção de Usuário
- **Endpoint**: `/users`
- **Método**: POST
- **Exemplo de requisição**:
  ```json
  {
    "name": "Leonardo Silva",
    "email": "Leozinho@gmail.com",
    "phone": "(87)3937-0136",
    "password": "123456"
  }
- **Resultado**:
- **ID gerado automaticamente**:
  ```json
  {
    "id": 7,
    "name": "Leonardo Silva",
    "email": "Leozinho@gmail.com",
    "phone": "(87)3937-0136",
    "password": "123456"
  }

### Busca de Usuário por ID
- **Endpoint**: `/users/{id}` 
- **Método**: GET
- **Exemplo de requisição**: (id = 7) `/users/7`:
- **Exemplo de resposta**:
  ```json
  {
    "id": 7,
    "name": "Leonardo Silva",
    "email": "Leozinho@gmail.com",
    "phone": "(87)3937-0136"
  }
  
### Deletar Usuário por ID
- **Endpoint**: `/users/{id}` 
- **Método**: DELETE
- **Exemplo de requisição**: (id = 6) `/users/6`:
  
  
### Listagem de Todos os Usuários
- **Endpoint**: `/users`
- **Método**: GET
- **Exemplo de requisição**: `/users`:
- **Exemplo de resposta**:
  ```json
  [
    {
      "id": 1,
      "name": "Nome do Primeiro Usuário",
      "email": "email1@example.com",
      "phone": "telefone1"
    },
    
    {
      "id": 10,
      "name": "Nome do Último Usuário",
      "email": "emailn@example.com",
      "phone": "telefonen"
    }
  ]

## Atualização de Usuário

- **Endpoint**: `/users/{id}`
- **Método**: PUT
- **Descrição**: Atualiza as informações do usuário com o ID especificado.
- **Exemplo de requisição**: (id = 7) `/users/7`
  ```json
   {
     "name": "Mario Silva",
     "email": "Mario@gmail.com",
     "phone": "(18) 93561-1354"
   }
- **Exemplo de resposta**:
  ```json
  {
      "id": 7,
      "name": "Mario Silva",
      "email": "Mario@gmail.com",
      "phone": "(18) 93561-1354"
  }

> Status do Projeto: Em desenvolvimento :construction:


