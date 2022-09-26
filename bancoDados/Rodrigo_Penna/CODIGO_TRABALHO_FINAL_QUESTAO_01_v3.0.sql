/*------------------------------------------------------------------------------------------------------------------------------------------
TRABALHO FINAL  
QUESTAO 01 - eCommerce
TURMA 06 - GRUPO 5

Adriene Bernardes da Cruz
Bernardo de Oliveira Souza
Felipe Ferreira Bordignon
Lucimary Azevedo
Mario Lucas Paulino Barriola
Rodolfo Carius Souza de Oliveira
Rodrigo Ladeira Penna

*/
--CRIACAO DO DATABASE

--CREATE DATABASE trabalho_final;

--CRIACAO DO SCHEMA

CREATE SCHEMA eCommerce;

--CRIACAO ENTIDADE CIDADE
CREATE TABLE eCommerce.cidade (
	idCidade serial primary key,
	nomeCidade varchar(150),
	uf varchar(2)
);
--PREENCHIMENTO DA TABELA CIDADE
--DADOS CIDADE
insert into eCommerce.cidade		( uf , nomeCidade )
				values	( 'RJ','Petrópolis'),
					( 'RJ','Teretrópolis'),
					( 'RJ','Areal'),
					( 'RJ','Nova Friburgo'),
					( 'RJ','Rio de Janeiro'),
					( 'MG','Belo Horizonte'),
					( 'MG','Diamantina'),
					( 'SP','Campinas'),
					( 'SP','São Paulo');

--CRIACAO ENTIDADE BAIRRO
CREATE TABLE eCommerce.bairro (
	idBairro serial primary key,
	nomeBairro varchar(150)

);
--PREENCHIMENTO DA ENTIDADE BAIRRO
--DADOS BAIRRO
insert into eCommerce.bairro	( nomeBairro )
			values	( 'Centro'),
				( 'Bela Vista'),
				( 'Bonsucesso'),
				( 'Cascatinha'),
				( 'Retiro'),
				( 'Taboão'),
				( 'Areão'),
				( 'Barreiro'),
				( 'Montebelo');
			
--CRIACAO ENTIDADE ENDERECO
CREATE TABLE eCommerce.endereco (
	idEndereco serial primary key,
	logradouro varchar(200),
	CEP varchar(8),
	--Chaves estrangeiras 
	idCidade int references eCommerce.Cidade(idCidade),
	idBairro int references eCommerce.Bairro(idBairro)
);
--PREENCHIMENTO DA ENTIDADE ENDERECO
--DADOS ENDERECO 
insert into eCommerce.endereco	( logradouro , CEP , idCidade , idBairro )
			values	
			--Cidade1, Bairro1
			( 'Rua São José' , '30620690' , 1 , 1 ),
			--Cidade1, Bairro2
			( 'Rua Quinze' , '14060680' , 1 , 2 ),
			--Cidade2, Bairro3
			( 'Rua São Francisco' , '25640071' , 2 , 3 ),
			--Cidade2, Bairro4
			( 'Rua Sete de Setembro' , '25635471' , 2 , 4 ),
			--Cidade3, Bairro1
			( 'Rua Dezesseis' , '25640020' , 3 , 1 ),
			--Cidade3, Bairro2
			( 'Rua Tiradentes' , '25685250' , 3 , 2 ),
			--Cidade4, Bairro3
			( 'Rua Paraná' , '25680275' , 4 , 3 ),
			--Cidade4, Bairro4
			( 'Rua Castro Alves' , '32628126' , 4 , 4 ),
			--Cidade5, Bairro1
			( 'Rua Santa Luzia' , '32628126' , 5 , 1 ),
			--Cidade5, Bairro2
			( 'Rua Duque de Caxias' , '31899191' , 5 , 2 ),
			--Cidade6, Bairro3
			( 'Rua Rui Barbosa' , '68926365' , 6 , 3 ),
			--Cidade6, Bairro4
			( 'Rua das Flores' , '66630115' , 6 , 4 ),
			--Cidade9, Bairro9
			( 'Rua Santos Dumont' , '72150110' , 9 , 9 );

--DADOS DA EMPRESA
CREATE TABLE eCommerce.empresa (
	idEmpresa serial primary key,
	cnpj varchar(14),
	razaoSocial varchar(100),
	--Chave estrangeira
	idEndereco int references eCommerce.endereco(idEndereco)
);
--PREENCHIMENTO DA ENTIDADE EMPRESA
--DADOS EMPRESA
insert into eCommerce.empresa	( cnpj , razaoSocial , idEndereco )
			values	( '22702969000147', 'Asterix', 13 );


--CRIACAO ENTIDADE NOME
CREATE TABLE eCommerce.nome (
	idNome serial primary key,
	primeiroNome varchar(150)
);
--PREENCHIMENTO DA ENTIDADE NOME
--DADOS NOME
insert into eCommerce.nome	( primeiroNome )
			values	('Miguel'),
				('Arthur'),
				('Gael'),
				('Heitor'),
				('Helena'),
				('Alice'),
				('Theo'),
				('Laura'),
				('Heloísa'),
				('Sophia'),
				('Valentina'),
				('Samuel');

--CRIACAO ENTIDADE SOBRENOME
CREATE TABLE eCommerce.sobrenome (
	idSobrenome serial primary key,
	sobrenome varchar(150)
);
--PREENCHIMENTO DA ENTIDADE SOBRENOME		
--DADOS SOBRENOME
insert into eCommerce.sobrenome	( sobreNome )
			values	( 'Silva'),
				( 'Santos'),
				( 'Oliveira'),
				( 'Souza'),
				( 'Rodrigues'),
				( 'Ferreira'),
				( 'Alves'),
				( 'Pereira'),
				( 'Lima'),
				( 'Gomes'),
				( 'Ribeiro'),
				( 'Martins');

--CRIACAO ENTIDADE CLIENTE
CREATE TABLE eCommerce.cliente(
	idCliente serial primary key,
	telefoneCliente varchar(11),
	nomeUsuario varchar(150),
	email varchar(150),
	cpfCliente varchar(11),
	dataNasc date,
	--Chaves estrangeiras
	idNome int references eCommerce.nome(idNome),
	idSobrenome int references eCommerce.sobrenome(idSobrenome),
	idEndereco int references eCommerce.endereco(idEndereco)
);
--PREENCHIMENTO DA ENTIDADE CLIENTE
--DADOS CLIENTES
insert into eCommerce.cliente	( telefoneCliente , nomeUsuario , email, cpfCliente, dataNasc , idNome , idSobrenome , idEndereco )
			values	
				--TELEFONE   	NOMEUSUARIO	 EMAIL			CPF		DATANASC	idNome	idSobrenome idEndereco
				( '24999999999' , 'Miguel22', 	'miguel@gmail.com', 	'98989889' ,  '2000-02-18' , 	1,		1,	1),
				( '24999999999' , 'Arthur2576', 'arthur@gmail.com', 	'79979979' ,  '2002-05-21' , 	2,		2,	2),
				( '24999999999' , 'Gael654', 	'gael@gmail.com',	'89795949' ,  '1992-08-01' , 	3,		3,	3),
				( '24999999999' , 'Heitor432', 	'heitor@gmail.com', 	'19429398' ,  '1999-10-23' , 	4,		1,	4),
				( '24999999999' , 'Helena242',	'helena@gmail.com',	 '92996699' ,  '1982-02-13' , 	5,		2,	5),
				( '24999999999' , 'Alice321',	'alice@gmail.com', 	'99989972' ,  '2002-04-19' , 	6,		3,	6),
				( '24999999999' , 'Theo221',	'theo@gmail.com', 	'99339912' ,  '2001-11-20' , 	7,		1,	7),
				( '24999999999' , 'Laura223', 	'laura@gmail.com',	 '49329259' ,  '2000-01-01' , 	8,		2,	8);
--CRIACAO ENTIDADE FUNCIONARIO
CREATE TABLE eCommerce.funcionario (
	idFuncionario serial primary key,
	cpfFuncionario varchar(11),
	--Chave estrangeira
	idNome int references eCommerce.nome(idNome),
	idsobreNome int references eCommerce.sobreNome(idsobreNome)
);
--PREENCHIMENTO DA ENTIDADE FUNCIONARIO
--DADOS FUNCIONARIO
insert into eCommerce.funcionario( cpfFuncionario , idNome , idSobrenome )
			values	
				( '19748523489' , 2 , 4),
				( '32148542189' , 3 , 5),
				( '25342562891' , 4 , 6),
				( '33148562889' , 5 , 7),
				( '74148542388' , 9 , 8),
				( '74554085015' , 10 , 9),
				( '35274790070' , 11 , 12);


--CRIACAO ENTIDADE CATEGORIA
CREATE TABLE eCommerce.categoria (
	idCategoria serial primary key,
	nomeCategoria varchar(150),
	descricaoCategoria varchar(200)
);
--PREENCHIMENTO DA ENTIDADE CATEGORIA
--DADOS CATEGORIA
insert into eCommerce.categoria	( nomeCategoria , descricaoCategoria )
			values	( 'Vestuário' , 'Produtos de vestúario'),
				( 'Alimentos' , 'Comidas e bebidas em geral'),
				( 'PetShop' , 	'Produtos para animais de estimação'),
				( 'Eletrônicos','Produtos EletroEletrônicos'),
				( 'Papelaria' , 'Produtos de papelaria'),
				( 'Informática','Produtos de Informática'),
				( 'Saúde' , 	'Produtos de saúde'),
				( 'Construção', 'Produtos de Material de Construção');
		
--CRIACAO ENTIDADE PRODUTO
CREATE TABLE eCommerce.produto (
	idProduto serial primary key,
	nomeProduto varchar(150),
	descricaoProduto varchar(200),
	dataFabricacao date,
	qntEstoque int,
	valorUnitario double precision,
	--Chave estrangeira
	idCategoria int references eCommerce.categoria(idCategoria),
	idFuncionario int references eCommerce.funcionario(idFuncionario)
);
--PREENCHIMENTO DA ENTIDADE PRODUTO
--DADOS PRODUTO
insert into eCommerce.produto	( nomeProduto , descricaoProduto , dataFabricacao , qntEstoque , valorUnitario , idCategoria , idFuncionario )
			values	
				--Nome 			Descricao	     		DataFabri		Estoque		Preco	categoria	funcionario  
				( 'Camisa Polo' , 	'Camisa Polo marca x' ,		'2000-01-01' ,		100 ,		45.00 ,		1 ,		1),
				( 'Camisa Lisa' , 	'Camisa Lisa marca x',		'2001-02-10' , 		200 , 		28.00 ,		1 ,		2),
				( 'Calça Jeans' , 	'Calca Jeans' ,		 	'2002-03-11' , 		300 , 		80.00 , 	1 , 		3),
				( 'Biscoito' , 		'Biscoito Sabor Chocolate' , 	'2003-04-21' , 		100 , 		3.00 , 		2 , 		4),
				( 'Cerveja' , 		'Cerveja Kaskatinha 473ml' ,	'2004-05-11' , 		200 , 		4.00 , 		2 , 		5),
				( 'Refrigerante',	'Refrigerante Joja 2L' ,	'2005-06-01' , 		300 , 		10.00 , 	2 , 		1),
				( 'Celular' , 		'Smartphone Zamzung ' ,		'2006-07-21' , 		100 , 		1200.00 ,	3 , 		2),
				( 'Televisão' , 	'Televisao 50"' , 		'2007-08-11' , 		200 , 		3000.00 ,	3 , 		3),
				( 'Geladeira' , 	'Geladeira 2 portas' , 		'2008-09-21' , 		300 , 		2500.00 ,	3 , 		4),
				( 'Cimento' , 		'Cimento CPIII' , 		'2009-01-01' , 		100 , 		90.00 ,		8 , 		5),
				( 'Tijolo' , 		'Tijolo 6 furos' , 		'2009-01-01' , 		100 , 		1.20 , 		8 , 		1);

--CRIACAO ENTIDADE NOTA 
CREATE TABLE eCommerce.nota (
	idNota serial primary key,
	serieNota varchar(5),
	valorTotalNota double precision,
	numeroNota varchar(10),
	dataNota timestamp,
	--Chave estrangeira
	idCliente int references eCommerce.cliente(idCliente),
	idEmpresa int references eCommerce.empresa(idEmpresa)
);
--CRIACAO ENTIDADE NotaItem
create table eCommerce.notaItem (
	idNotaItem serial primary key,
	qntNotaItem int,
	valorUnitarioNota double precision,
	dataNotaItem timestamp,

	--Chave estrangeira
	idProduto int references eCommerce.produto(idProduto),
	idNota int references eCommerce.Nota(idNota)
);

/*FIM CRIACAO ENTIDADES
----------------------------------------------
INICIO ENTRADA DE DADOS:
--PREENCHIMENTO DA NOTA FISCAL 
PRIMEIRA VENDA
--PREENCHIMENTO DA ENTIDADE NOTA - SEM VALOR DA VENDA
*/
insert into eCommerce.nota	( serieNota ,  numeroNota , 	dataNota , 		idCliente , idEmpresa )
			values
				('0001', 	'0001', 	'2022-01-01: 00:00:00',  1 , 		1); 

--PREENCHIMENTO DA ENDIDADE NOTAITEM
insert into eCommerce.notaItem( qntNotaItem , valorUnitarioNota , idProduto , dataNotaItem ,idNota )
			values	--Primeira Compra
				--qntPedido 	, valorUnitario 						, idProduto 	, dataPedido , 		idNota
				( 5 		, (select valorUnitario from eCommerce.produto where idProduto =1) , 	1 ,	 '2021-01-01 00:00:00', 1),
				( 10 		, (select valorUnitario from eCommerce.produto where idProduto =2) , 	2 ,	 '2021-01-01 00:00:00', 1),
				( 15 		, (select valorUnitario from eCommerce.produto where idProduto =3) , 	3 ,	 '2021-01-01 00:00:00', 1),
				( 20 		, (select valorUnitario from eCommerce.produto where idProduto =4) , 	4 ,	 '2021-01-01 00:00:00', 1),
				( 25		, (select valorUnitario from eCommerce.produto where idProduto =5) , 	5 ,	 '2021-01-01 00:00:00', 1),
				( 30 		, (select valorUnitario from eCommerce.produto where idProduto =6) , 	6 ,	 '2021-01-01 00:00:00', 1);

--PREECHIMENTO DO VALOR DA ENDIDADE NOTA
update eCommerce.nota set valorTotalNota = (select sum(qntNotaItem*valorUnitarioNota) from eCommerce.notaItem ) where idNota = 1;

----------
--SEGUNDA VENDA
--PREENCHIMENTO DA ENTIDADE NOTA - SEM VALOR DA VENDA
insert into eCommerce.nota	( serieNota , 	 numeroNota ,	 dataNota , 		idCliente , idEmpresa )
			values
				('0002', 	'0002', 	'2022-01-02: 00:00:00',  2 , 		1); 

--PREENCHIMENTO DA ENDIDADE NOTAITEM
insert into eCommerce.notaItem( qntNotaItem , valorUnitarioNota , idProduto , dataNotaItem ,idNota )
			values	--Segunda Compra
				--qntPedido 	, valorUnitario 						, idProduto 	 dataPedido , 		idNota
				( 5 		, (select valorUnitario from eCommerce.produto where idProduto =5) , 	5 ,	 '2021-01-01 00:00:00', 2),
				( 10 		, (select valorUnitario from eCommerce.produto where idProduto =6) , 	6 ,	 '2021-01-01 00:00:00', 2),
				( 15 		, (select valorUnitario from eCommerce.produto where idProduto =7) , 	7 ,	 '2021-01-01 00:00:00', 2),
				( 20 		, (select valorUnitario from eCommerce.produto where idProduto =8) , 	8 ,	 '2021-01-01 00:00:00', 2),
				( 25		, (select valorUnitario from eCommerce.produto where idProduto =9) , 	9 ,	 '2021-01-01 00:00:00', 2),
				( 30 		, (select valorUnitario from eCommerce.produto where idProduto =10) , 	10 ,	 '2021-01-01 00:00:00', 2);

--PREECHIMENTO DO VALOR DA ENDIDADE NOTA
update eCommerce.nota set valorTotalNota = (select sum(qntNotaItem*valorUnitarioNota) from eCommerce.notaItem )where idNota = 2;

----------
--TERCEIRA VENDA
--PREENCHIMENTO DA ENTIDADE NOTA - SEM VALOR DA VENDA
insert into eCommerce.nota	( serieNota ,  	numeroNota , 		dataNota ,	 idCliente , idEmpresa )
			values
				('0003', 	'0003',		 '2022-01-02: 00:00:00',  3 , 		1); 

--PREENCHIMENTO DA ENDIDADE NOTAITEM
insert into eCommerce.notaItem( qntNotaItem , valorUnitarioNota , idProduto , dataNotaItem ,idNota )
			values	--Terceira Compra
				--qntPedido 	, valorUnitario 						, idProduto 	 dataPedido , 		idNota
				( 5 		, (select valorUnitario from eCommerce.produto where idProduto =1) , 	1 ,	 '2021-01-01 00:00:00', 3),
				( 10 		, (select valorUnitario from eCommerce.produto where idProduto =2) , 	2 ,	 '2021-01-01 00:00:00', 3),
				( 15 		, (select valorUnitario from eCommerce.produto where idProduto =3) , 	3 ,	 '2021-01-01 00:00:00', 3),
				( 20 		, (select valorUnitario from eCommerce.produto where idProduto =8) , 	8 ,	 '2021-01-01 00:00:00', 3),
				( 25		, (select valorUnitario from eCommerce.produto where idProduto =9) , 	9 ,	 '2021-01-01 00:00:00', 3),
				( 30 		, (select valorUnitario from eCommerce.produto where idProduto =10) , 	10 ,	 '2021-01-01 00:00:00', 3);

--PREECHIMENTO DO VALOR DA ENDIDADE NOTA
update eCommerce.nota set valorTotalNota = (select sum(qntNotaItem*valorUnitarioNota) from eCommerce.notaItem ) where idNota = 3;


----------
--QUARTA VENDA
--PREENCHIMENTO DA ENTIDADE NOTA - SEM VALOR DA VENDA
insert into eCommerce.nota	( serieNota ,  	numeroNota , 	dataNota , 		idCliente , idEmpresa )
			values
				('0004', 	'0004', 	'2022-01-04: 00:00:00',  1 , 		1); 

--PREENCHIMENTO DA ENDIDADE NOTAITEM
insert into eCommerce.notaItem( qntNotaItem , valorUnitarioNota , idProduto , dataNotaItem ,idNota )
			values	--Terceira Compra
				--qntPedido 	, valorUnitario 						, idProduto 	 dataPedido , 		idNota
				( 1 		, (select valorUnitario from eCommerce.produto where idProduto =1) , 	1 ,	 '2021-01-01 00:00:00', 4),
				( 2 		, (select valorUnitario from eCommerce.produto where idProduto =2) , 	2 ,	 '2021-01-01 00:00:00', 4),
				( 3 		, (select valorUnitario from eCommerce.produto where idProduto =3) , 	3 ,	 '2021-01-01 00:00:00', 4),
				( 4 		, (select valorUnitario from eCommerce.produto where idProduto =8) , 	8 ,	 '2021-01-01 00:00:00', 4),
				( 5		, (select valorUnitario from eCommerce.produto where idProduto =9) , 	9 ,	 '2021-01-01 00:00:00', 4),
				( 6 		, (select valorUnitario from eCommerce.produto where idProduto =10) , 	10 ,	 '2021-01-01 00:00:00', 4);

--PREECHIMENTO DO VALOR DA ENDIDADE NOTA
update eCommerce.nota set valorTotalNota = (select sum(qntNotaItem*valorUnitarioNota) from eCommerce.notaItem ) where idNota = 4;


----------
--QUINTA VENDA
--PREENCHIMENTO DA ENTIDADE NOTA - SEM VALOR DA VENDA
insert into eCommerce.nota	( serieNota ,  numeroNota , dataNota , idCliente , idEmpresa )
			values
				('0005', '0005', '2022-01-05: 00:00:00',  7 , 	1); 

--PREENCHIMENTO DA ENDIDADE NOTAITEM
insert into eCommerce.notaItem( qntNotaItem , valorUnitarioNota , idProduto , dataNotaItem ,idNota )
			values	--Terceira Compra
				--qntPedido 	, valorUnitario 						, idProduto 	 dataPedido , 		idNota
				( 5 		, (select valorUnitario from eCommerce.produto where idProduto =1) , 	5 ,	 '2021-01-01 00:00:00', 5),
				( 2 		, (select valorUnitario from eCommerce.produto where idProduto =2) , 	2 ,	 '2021-01-01 00:00:00', 5),
				( 3 		, (select valorUnitario from eCommerce.produto where idProduto =3) , 	8 ,	 '2021-01-01 00:00:00', 5),
				( 8 		, (select valorUnitario from eCommerce.produto where idProduto =8) , 	6 ,	 '2021-01-01 00:00:00', 5),
				( 3		, (select valorUnitario from eCommerce.produto where idProduto =9) , 	1 ,	 '2021-01-01 00:00:00', 5),
				( 1 		, (select valorUnitario from eCommerce.produto where idProduto =10) , 	10 ,	 '2021-01-01 00:00:00', 5);

--PREECHIMENTO DO VALOR DA ENDIDADE NOTA
update eCommerce.nota set valorTotalNota = (select sum(qntNotaItem*valorUnitarioNota) from eCommerce.notaItem ) where idNota = 5;


/*
3. SQL de criação das tabelas
	CODIGO ACIMA
*/

/*
4. SQL de inserção de dados nas tabelas (pelo menos 5 registros em
cada uma)
	CODIGO ACIMA
*/
--5. Um comando SQL de atualização em algum registro em uma tabela

update eCommerce.produto set qntEstoque = 999 where idProduto = 1;


--6. Um comando SQL de exclusão de algum registro em uma tabela

delete from eCommerce.funcionario where idFuncionario = 7;

/*SELECT
7. 5 SQLs de consulta
	a. Pelo menos 2 com algum tipo de junção
	b. Pelo menos 1 com usando count() e group by()
	c. 1 SQL para construção de nota fiscal
*/

--SELECT COM JOIN
SELECT
    primeiroNome as nome_funcionario,
    sobrenome as sobrenome_funcionario,
    cpffuncionario as cpf_funcionario
FROM ecommerce.funcionario fu
LEFT JOIN ecommerce.nome  ON nome.idnome = fu.idnome
LEFT JOIN ecommerce.sobrenome ON sobrenome.idsobrenome = fu.idsobrenome;


--SELECT COM JOIN, SUM, GROUP BY E ORDER BY
SELECT 
	nomeProduto , 
	sum(qntEstoque) as Estoque_Total, 
	sum (qntEstoque*valorUnitario) as Valor_Estoque 
FROM eCommerce.produto p	
LEFT JOIN eCommerce.categoria as m on m.idCategoria = p.idcategoria
GROUP BY nomeProduto
ORDER BY Valor_Estoque;


--SELECT COM JOIN, COUNT E GROUP BY
SELECT 
	nomeCategoria , 
	count(*) as Produtos_cadastrados
FROM eCommerce.produto p
LEFT JOIN eCommerce.categoria c on c.idCategoria = p.idCategoria
GROUP BY nomeCategoria;


--SQL PARA CONSTRUÇÃO DE NOTA FISCAL
SELECT 
	razaosocial as empresa,
	cnpj as cnpj_empresa,
	primeiroNome as nome_cliente,
	nomeProduto as produto,
	valorUnitarioNota as valor_unitario,
	qntNotaItem as qnt_nota,
	(valorUnitarioNota*qntNotaItem) as total_item_nota,
	valorTotalNota as valor_total_nota,
	dataNota as data_emissao_nota
	
FROM eCommerce.notaitem pdi
LEFT JOIN ecommerce.produto prd on prd.idproduto = pdi.idproduto
LEFT JOIN ecommerce.nota pdd on pdd.idnota = pdi.idnota 
LEFT JOIN ecommerce.cliente cli on cli.idcliente = pdd.idcliente
LEFT JOIN ecommerce.nome nome on nome.idnome = cli.idnome
LEFT JOIN ecommerce.empresa emp on emp.idempresa = 1;