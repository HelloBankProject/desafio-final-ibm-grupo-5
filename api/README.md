# API - HelloBank

Esta é uma RESTful API que permite o gerenciamento bancário. Aqui você cadastra clientes e suas transações bancárias.

## **Endpoints**

### **Listar todos os clientes**
<<<<<<< HEAD

=======
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
#### `GET` `/clientes`

Essa é a rota que será utilizada para listar todos os clientes cadastrados no sistema.

<<<<<<< HEAD
- **Requisição**  
  Sem parâmetros de rota ou de query.

### **Listar cliente específico**

=======
-   **Requisição**  
    Sem parâmetros de rota ou de query.  


### **Listar cliente específico**
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
#### `GET` `/cliente/:id`

Essa é a rota que será utilizada para listar o cliente do id desejado.

<<<<<<< HEAD
- **Requisição**  
  O parâmetro de rota será o id do cliente que deseja retornar.

### **Cadastrar um cliente**

=======
-   **Requisição**  
    O parâmetro de rota será o id do cliente que deseja retornar.  
    
    
### **Cadastrar um cliente**
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
#### `POST` `/clientes`

Essa é a rota que será utilizada para cadastrar um novo cliente no sistema.

<<<<<<< HEAD
- **Requisição**  
  Sem parâmetros de rota ou de query.  
  O corpo (body) deverá possuir um objeto com as seguintes propriedades (respeitando estes nomes):

  - CPF
  - nome
  - email
  - senha
  - endereco
  - estado
  - cidade
  - bairro
  - complemento
  - telefone

### **Atualizar dados de um cliente**

#### `PUT` `/clientes`

Essa é a rota que será utilizada para atualizar as informações do cliente do id desejado.

- **Requisição**  
  Sem parâmetros de rota ou de query.  
  O corpo (body) deverá possuir um objeto com as propriedades que serão atualizadas.

### **Deletar informações de um cliente**

=======
-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    O corpo (body) deverá possuir um objeto com as seguintes propriedades (respeitando estes nomes):

    -   CPF
    -   nome
    -   email
    -   senha
    -   endereco
    -   estado
    -   cidade
    -   bairro
    -   complemento
    -   telefone

### **Atualizar dados de um cliente**
#### `PUT` `/clientes`

Essa é a rota que será utilizada para atualizar as informações  do cliente do id desejado.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    O corpo (body) deverá possuir um objeto com as propriedades que serão atualizadas.


### **Deletar informações de um cliente**
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
#### `DELETE` `/clientes:id`

Essa é a rota que será utilizada para listar o cliente do id desejado.

<<<<<<< HEAD
- **Requisição**  
  Sem parâmetros de rota ou de query.

=======
-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    
    
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
### 😎 Contribuição

<p align="center">
 • <a href="https://github.com/WhoisAndreoli">Andre Silva</a> •
 <a href="https://github.com/carlostsa10">Carlos Tavares</a> • 
 <a href="https://github.com/evaldovisk">Evaldo Fonseca</a> • 
 <a href="https://github.com/TCLxEdu17">Luis Eduardo</a> • 
 <a href="https://github.com/jsuisjuan">Juan Carvalho</a> • 
 <a href="https://github.com/ManueleLim">Maria Manuele</a> • 
 
</p>
