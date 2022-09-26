
create table vendas.empresa
(
	idEmpresa serial primary key,
	CNPJ varchar(14),
	RazaoSocial varchar(100),
	Endereco varchar(150) 
);

create table vendas.bairro 
(
    idBairro serial primary key,
	nmBairro varchar(100)
);

create table vendas.cidade
(
	idCidade serial primary key,
	nmCidade varchar(100),
	uf varchar(2)
);


create table vendas.endereco 
(
    idEndereco serial primary key,
	Logradouro varchar(160),
	idBairro integer REFERENCES vendas.bairro (idBairro),
	idCidade integer REFERENCES vendas.cidade (idCidade),
	CEP varchar(8)
);

create table vendas.cliente
( 
    idCliente serial primary key,
	CPF_CNPJ varchar(14),
	Nome varchar(100),
	Telefone varchar(20),
	idEndereco integer REFERENCES vendas.bairro (idBairro),
	nr_Endereco varchar(10)
);

create table vendas.marcas 
(
	idMarca serial primary key,
	nmMarca varchar(60)
);

create table vendas.produto
(
    idProduto serial primary key,
	nmProduto varchar(100),
	qtEstoque integer,
	vlVenda double precision,
	Marca varchar(100),
	idMarca integer REFERENCES vendas.marcas (idMarca),
	perc_imposto double precision,
	vlCusto double precision
		
);

create table vendas.documento 
(
    idDocumento serial primary key,
	Serie varchar(5),
	idCliente integer REFERENCES  vendas.cliente (idCliente),
	idEmpresa integer REFERENCES vendas.empresa (idEmpresa),
	vlTotal double precision,
	Numero varchar(10),
	dtEmissao timestamp
	
); 

create table vendas.docItem 
(
  idDocItem serial primary key,
  idProduto integer REFERENCES vendas.produto (idProduto),
  idDocumento integer REFERENCES vendas.documento (idDocumento),
  quantidade integer,
  vlUnitario double precision,
  vlImposto double precision,
  vlCusto double precision,
  vlDescontoUnitario double precision	
);


INSERT INTO vendas.empresa 
(CNPJ,RazaoSocial)
values
('88803928000155','Walmart'),
('07431092000103','Extra')

INSERT INTO  vendas.bairro
(nmBairro)
values
('Planalto'),('Santo Antônio'),
('São Francisco'),('Industrial'),
('Bela Vista')

INSERT INTO vendas.cidade
(nmCidade,uf)
values
('Campo Grande','MS'),('Paulo Afonso','BA'),
('Parnaíba','PI'),('Itapipoca','CE')

INSERT INTO vendas.endereco
(Logradouro,CEP)
values
('Dezesseis','60914284'),('Maranhão','49026453'),
('Bela Vista','71360883'),('Quinze','65586328')

INSERT INTO vendas.cliente
(CPF_CNPJ,Nome,Telefone,nr_Endereco)
values
('35205289000160','Felipe','2227307596','910'),
('18811868000137','Mary','2131648666','5903'),
('52233853000177','Mario','6528151872','2482'),
('14923379000116','Lucas','3332852076','4938')

INSERT INTO vendas.marcas 
(nmMarca)
values
('Optima Esportes'),('Storm calçados'),('C wars'),
('Versátil'),('PeakPeformance'),('jumpstart')

INSERT INTO vendas.produto
(nmProduto,qtEstoque,vlVenda,Marca,perc_imposto,vlCusto)
values
('Blusa Esportiva', 2 , 60,'Optima Esportes',6,20),
('Tenis Esportivo',10,240,'Optima Esportes',24,120),
('Short Esportivo', 20,50,'Optima Esportes',4,22),
('Chinelo branco',40,22,'Storm calçados',2,10),
('Tenis nike',10,33,'Storm calçados',4,14),
('Bolsa de couro',2,4000,'Versátil',405,1200),
('Action Figure',40,230,'C wars',23,100),
('Card forced wordship',5,304,'jumpstart',42,120),
('Casaco Goretex Pac',5,212,'PeakPeformance',32,45),
('Jaqueta Frost Ski',3,320,'PeakPeformance',32,42)


INSERT INTO vendas.documento
(Serie,vlTotal,Numero,dtEmissao)
values
('21313',204,'551000003','2022/05/14 11:20:00'),('23255',1500,'551000007','2002/05/14 12:40:30'),
('53535',203,'551000001','2000/06/04 05:10:20'),('15567',1500,'551000008','2012/10/24 17:42:30'),
('21532',1200,'551000009','2021/06/14 11:50:10')


INSERT INTO vendas.docItem
(quantidade,vlUnitario,vlImposto,vlCusto,vlDescontoUnitario)
values
(10,204,20,120,10),(320,20,2,5,3),
(30,320,23,100,20),(40,100,10,20,30),
(30,100,20,5,10)


select * from vendas.empresa ves
left join vendas.endereco en on en.cep = en.cep
left join vendas.bairro vb on vb.nmBairro = vb.nmBairro

