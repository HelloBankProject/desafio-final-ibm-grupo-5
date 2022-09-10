create database hellobankbd;
use hellobankbd;

create table Cliente (
	id integer primary key auto_increment,
    cpf char(14) not null,
    nome varchar(50) not null,
    email varchar(80) not null,
    senha varchar(20) not null,
    endereco varchar(80) not null,
    estado varchar(50) not null,
    cidade varchar(80) not null,
    bairro varchar(80) not null,
    complemento varchar(50) null,
    telefone char(11) not null
);

create table Conta (
	id integer primary key auto_increment,
    tipo varchar(50) not null,
    saldo double not null,
    credito double null,
    id_cliente integer not null,
    id_outro_cliente integer null,
    foreign key(id_cliente) references Cliente(id) ON UPDATE CASCADE,
    foreign key(id_outro_cliente) references Cliente(id) ON UPDATE CASCADE
);

create table Transacao (
	id integer primary key auto_increment,
    valor double not null,
    data_transacao date not null,
    modo_envio varchar(50) not null,
    id_recebedor integer not null,
    id_fornecedor integer not null,
    foreign key(id_recebedor) references Conta(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(id_fornecedor) references Conta(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- INSERÇÃO DE DADOS

select * from cliente;
insert into Cliente (cpf,nome,email,senha,endereco,estado,cidade,bairro,complemento,telefone) values
("174.774.077-29","Juan Carvalho Silva de Lima","juanc.s.delima@gmail.com","juaN01md","Rua José Saly, 185","Rio de Janeiro","São Gonçalo","Porto Novo","Sobrado","21989447785"),
("029.999.037-07", "Fabio da Silva Almeida","fabios.almeida@gmail.com","faBio88jew","Travessia Maria Rita","Pernambuco","Recife","Ipojuca",null,"06783332424"),
("672.229.492-44", "Ana Claudia da Silva","anacclaudia.amada@gmail.com","lind0lfU","Rua Vinte e Sete","Maranhão","Caxias","Bela Vista","Casa Amarela","53999874652"),
("113.777.230-15", "Mariane Rodrigues Menedes","mari03.menedes@gmail.com","mariM4r1.PjC","Rua São Vicente de Paula, 632","Mato Grosso do Sul","Nova Andradina","Vila Operária",null,"23883345678"),
("066.666.234-66","Thomas Cavalcante Sotero","thomaScaval135@gmail.com","ttfweCavalfq45.Jdsa","Rua Graciliano Ramos, B5","Paraná","Cascavel","Alto Alegre","Edifício Recanto Verde", "55976433123");


select * from conta;
insert into Conta (tipo,saldo,credito,id_cliente,id_outro_cliente) values
("corrente",23450.35,450,1,null),("poupanca",10000.00,null,2,null),("corrente",3445.20,7000.0,2,null),("salario","1875.90",null,1,null),
("conjunta",500000.00,null,3,5),("poupanca",560.90,null,3,null),("corrente",1000,700,3,null),("corrente",5320,7080,4,null),("salario",230.00,null,4,null),("corrente",236300.98,10,5,null),
("salario",25000.00,null,5,null);

select * from Transacao;
insert into Transacao (valor,data_transacao,modo_envio,id_recebedor,id_fornecedor) values
(220.00,'2022-12-22',"pix",1,3),(500.90,'2022-12-25',"pix",1,5),(4000.00,'2017-04-11',"TED",2,4),(150.00,'2007-02-05',"TED",1,5),(50.00,'2019-08-12',"pix",2,1),
(700.00,'2001-05-02',"TED",2,10),(100.00,'2010-09-07',"TED",2,1),(425.35,'2013-06-30',"TED",3,5),(75.90,'2020-10-07',"pix",6,2),(350.90,'2020-11-15',"TED",3,4),(32.50,'2020-12-01',"pix",1,3),
(50.00,'2003-08-22',"TED",4,7),(600.75,'1997-08-08',"TED",4,5),(25.50,'2003-04-20',"TED",9,4),(15000.00,'2022-01-01',"pix",1,5),(450.00,'2001-05-05',"TED",2,10),
(889.90,'2006-07-04',"pix",5,4),(900.00,'2005-03-14',"TED",3,8),(1533.45,'2007-07-24',"pix",5,2);
