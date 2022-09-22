# API - HelloBank

Esta é uma RESTful API que permite o gerenciamento bancário. Aqui você cadastra clientes e suas transações bancárias.

## **Endpoints de Clientes**

### **Listar todos os clientes**
#### `GET` `/clientes`

Essa é a rota que será utilizada para listar todos os clientes cadastrados no sistema.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  


### **Listar cliente específico**
#### `GET` `/cliente/:id`

Essa é a rota que será utilizada para listar o cliente do id desejado.

-   **Requisição**  
    O parâmetro de rota será o id do cliente que deseja retornar.  
    
    
### **Cadastrar um cliente**
#### `POST` `/clientes`

Essa é a rota que será utilizada para cadastrar um novo cliente no sistema.

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
#### `DELETE` `/clientes:id`

Essa é a rota que será utilizada para deletar o cliente do id desejado.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  


## **Endpoints de Contas**

### **Listar todos as contas**
#### `GET` `/contass`

Essa é a rota que será utilizada para listar todos as contas cadastradas no sistema do HelloBank.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  


### **Listar conta específica**
#### `GET` `/contas/:id`

Essa é a rota que será utilizada para listar a conta especificada no id desejado pelo cliente.

-   **Requisição**  
    O parâmetro de rota será o id da conta que o cliente que deseja retornar.  
    
    
### **Cadastrar uma conta**
#### `POST` `/contas`

Essa é a rota que será utilizada para cadastrar uma nova conta do cliente no sistema, podendo ser do tipo corrente, poupança, salário e conta conjunta.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    O corpo (body) deverá possuir um objeto com as seguintes propriedades (respeitando estes nomes):

    -   tipo de conta
    -   id do cliente

### **Deletar informações de uma conta**
#### `DELETE` `/contas:id`

Essa é a rota que será utilizada para deletar todas as informações de uma conta com o id desejado.

-   **Requisição**  
    Sem parâmetros de rota ou de query.
    

## **Endpoints de Transações**

### **Listar todas as transações da conta**
#### `GET` `/transacoes`

Essa é a rota que será utilizada para listar todas as transações efetuadas por aquela conta do cliente.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  


### **Listar transação específica**
#### `GET` `/transacoes/:id`

Essa é a rota que será utilizada para listar os detalhes de uma transação específica pelo id desejado.

-   **Requisição**  
    O parâmetro de rota será o id da transação que deseja retornar.  
    
    
### **Cadastrar uma nova transferência**
#### `POST` `/transacoes/transferencia`

Essa é a rota que será utilizada para cadastrar uma nova transferência de valores para outra conta do HelloBank.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    O corpo (body) deverá possuir um objeto com as seguintes propriedades (respeitando estes nomes):

    -   valor de transferecia
    -   id da conta de destino
    
### **Cadastrar uma depósito**
#### `POST` `/transacoes/deposito`

Essa é a rota que será utilizada para registrar valores na conta do HelloBank.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    O corpo (body) deverá possuir um objeto com as seguintes propriedades (respeitando estes nomes):

    -   valor do depósito
    
### **Cadastrar uma saque**
#### `POST` `/transacoes/saque`

Essa é a rota que será utilizada para retirar valores da conta do HelloBank.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    O corpo (body) deverá possuir um objeto com as seguintes propriedades (respeitando estes nomes):

    -   valor do saque

### 😎 Contribuição

<p align="center">
 • <a href="https://github.com/WhoisAndreoli">Andre Silva</a> •
 <a href="https://github.com/carlostsa10">Carlos Tavares</a> • 
 <a href="https://github.com/evaldovisk">Evaldo Fonseca</a> • 
 <a href="https://github.com/TCLxEdu17">Luis Eduardo</a> • 
 <a href="https://github.com/jsuisjuan">Juan Carvalho</a> • 
 <a href="https://github.com/ManueleLim">Maria Manuele</a> • 
 
</p>
