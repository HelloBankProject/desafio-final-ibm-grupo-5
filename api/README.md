# API - Tudo de Bom

Esta é uma RESTful API que permite o cadastro de novos clientes, incluindo dados pessoais, dados para contato e controle de estoque de produtos.

## **Endpoints**

### **Cadastrar um cliente**
#### `POST` `/cliente`

Essa é a rota que será utilizada para cadastrar um novo cliente no sistema.

-   **Requisição**  
    Sem parâmetros de rota ou de query.  
    O corpo (body) deverá possuir um objeto com as seguintes propriedades (respeitando estes nomes):

    -   nome
    -   CPF
    -   email

#### **Exemplo de requisição**

```
// POST /cliente
{
      "nome": "Uallace Gomes",
      "CPF": "032.565.984-76",
      "email": "uallace@gmail.com"
      
}
```

#### **Exemplos de resposta**

```
{
      "nome": "Uallace Gomes",
      "CPF": "032.565.984-76",
      "email": "uallace@gmail.com",
      "idcliente": 12
}
```
