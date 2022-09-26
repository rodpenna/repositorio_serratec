package interfaces.br.com.serratec;


//Importacoes de bibliotecas e classes
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import classes.br.com.serratec.Categoria;
import classes.br.com.serratec.Cliente;
import classes.br.com.serratec.Empresa;
import classes.br.com.serratec.Pedido;
import classes.br.com.serratec.PedidoItem;
import classes.br.com.serratec.Produto;
import conexao.br.com.serratec.Conexao;
import dao.br.com.serratec.CategoriaDAO;
import dao.br.com.serratec.ClienteDAO;
import dao.br.com.serratec.EmpresaDAO;
import dao.br.com.serratec.PedidoDAO;
import dao.br.com.serratec.PedidoItemDAO;
import dao.br.com.serratec.ProdutoDAO;


//CLASSE ATUAL DE TRABALHO
public class Principal {
	
	public static Scanner input = new Scanner(System.in);
	
	
	public static Timestamp receberTimestamp() {
		
		System.out.println("---------------------------------------");
		System.out.println("------- INFORMANDO O TIMESTAMP --------");
		System.out.println("---------------------------------------");
		Calendar c = Calendar.getInstance();
		System.out.println("DIGITE O ANO DO TIMESTAMP");
		int ano = input.nextInt();
		System.out.println("DIGITE O MES DO TIMESTAMP");
		int mes = input.nextInt();
		System.out.println("DIGITE O DIA DO TIMESTAMP");
		int dia = input.nextInt();
		System.out.println("DIGITE A HORA DO TIMESTAMP");
		int hora = input.nextInt();
		System.out.println("DIGITE O MIN DO TIMESTAMP");
		int min = input.nextInt();
		System.out.println("DIGITE OSEG DO TIMESTAMP");
		int seg = input.nextInt();
		
		c.set(ano, mes-1, dia, hora, min, seg);
								
		Date data = c.getTime();
		
		Timestamp timestamp = new Timestamp(data.getTime());
	
		return timestamp;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
			
		String bd = "trabalho_final";
		String porta = "5433";
		String senha = "123";
		
		Conexao con = new Conexao("PostgreSql", "localhost", porta , bd, "postgres", senha);	
		con.connect();		
		menuPrincipal(con);			
		con.disconnect();
		input.close();
	}

	
	//----------------------------------------------------------------------
	//----------------------------------------------------------------------
	//----------------------------------------------------------------------
	//METODO PARA MENU PRINCIPAL
	
	public static void menuPrincipal(Conexao con) {
		int opcao;
		//Scanner input = new Scanner(System.in);
			
		do {
			System.out.println("[HOME]---------------------------------");
			System.out.println("---------------------------------------");
			System.out.println("------------ MENU PRINCIPAL -----------");
			System.out.println("---------- SELECIONE UMA OPCAO --------");
			System.out.println("---------------------------------------");
			System.out.println("| 1- MENU EMPRESA		|");
			System.out.println("| 2- MENU CLIENTE		|");
			System.out.println("| 3- MENU CATEGORIA		|");
			System.out.println("| 4- MENU PRODUTO		|");
			System.out.println("| 5- MENU PEDIDO		|");
			System.out.println("| 0- Sair			|");
			System.out.println("|_______________________________|");
			
			opcao = Integer.parseInt(input.next());
			
			switch(opcao) {
			
			case 1: menuEmpresa(con);break;
			
			case 2: menuCliente(con ); break;
			
			case 3: menuCategoria(con ); break;
			
			case 4: menuProduto(con);break;
			
			case 5: menuPedido(con);break;
			
			case 0: System.out.println("Sistema encerrado.");break;
			default: System.out.println("Opcao invalida.");
			}
		} while (opcao != 0);
		
	}

	
	
	private static  void menuCRUD() {
	
		System.out.println("| 1 - INCLUIR	|");
		System.out.println("| 2 - ALTERAR	|");
		System.out.println("| 3 - EXCLUIR	|");
		System.out.println("| 4 - LOCALIZAR	|");
		System.out.println("| 5 - LISTAR	|");
		System.out.println("| 6 - VOLTAR	|");
		System.out.println("|_______________|");
				
	
	}
	
	/*----------------------------------------------------------------------
	//METODOS DO CLIENTE
	
	//METODOS AUXILIARES
	METODO PARA PREENCHIMENTO DOS DADOS DO CLIENTE*/
	public static Cliente informarCliente() {
		
		Cliente cliente = new Cliente();
	
		System.out.println("DIGITE O NOME DO CLIENTE");
		String nome = input.next();
		System.out.println("DIGITE O CPF DO CLIENTE");
		String cpf =  input.next();
		System.out.println("DIGITE O TELEFONE DO CLIENTE");
		String tel = input.next();
		System.out.println("DIGITE O ENDERECO: NOME RUA");
		String endereco = input.next();
		System.out.println("DIGITE O ENDERECO: NUMERO CASA ");
		String nrEndereco = input.next();
		System.out.println("DIGITE O ENDERECO: COMPLEMENTO ");
		String comple = input.next();
		System.out.println("DIGITE O ENDERECO: CEP ");
		String cep = input.next();
		System.out.println("DIGITE O ENDERECO: BAIRRO ");
		String bairro = input.next();
		System.out.println("DIGITE O ENDERECO: CIDADE ");
		String cidade = input.next();

		
		
		cliente.setNome(nome);
		cliente.setBairro(bairro);
		cliente.setCep(cep);
		cliente.setCidade(cidade);
		cliente.setCpf(cpf);
		cliente.setTel(tel);
		cliente.setComplemento(comple);
		cliente.setEndereco(endereco);
		cliente.setNrEndereco(nrEndereco);
		
		
		
		return cliente;
	}
	
	//METODO DO MENU PRINCIPAL DO CLIENTE
	public static void menuCliente(Conexao con) {
		
		
		int opcao;
		
		do {
			System.out.println("[HOME/CLIENTE]-------------------------");
			System.out.println("---------------------------------------");
			System.out.println("------------- MENU CLIENTE ------------");
			System.out.println("---------- SELECIONE UMA OPCAO --------");
			System.out.println("---------------------------------------");
			
			menuCRUD();
			opcao = Integer.parseInt(input.next());
			
			switch(opcao) {
			case 1: incluirCliente(con ); break;
			case 2: alterarCliente(con); break;
			case 3: excluirCliente(con); break;
			case 4: localizarCliente(con); break;
			case 5: listarCliente(con); break;
			case 6:  break;
			default: System.out.println("Opcao invalida.");
			}
		} while (opcao != 6);
	
	}
	
	//METODO PARA INCLUIR CLIENTE NO CRUD
	public static void incluirCliente(Conexao con) {
		
		ClienteDAO clienteDAO = new ClienteDAO(con);
				
		Cliente cliente = informarCliente();
						
		clienteDAO.incluirCliente(cliente);
				
	}
	
	//METODO PARA ALTERAR CLIENTES NO CRUD
	public static void alterarCliente(Conexao con) {
		
		
		ClienteDAO clienteDAO = new ClienteDAO(con);
		Cliente cliente = new Cliente();
				
		System.out.println("[HOME/CLIENTE/ALTERAR]-----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU CLIENTE ------------");
		System.out.println("--- SELECIONE O CLIENTE PARA ALTERAR --");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO NOME DO CLIENTE	|");
		System.out.println("| 2- PELO ID DO CLIENTE		|");
		System.out.println("| 0- SAIR					|");
		System.out.println("|___________________________|");
		
		int resp = input.nextInt();
				
		switch(resp) {
			case 1:
				System.out.println("DIGITE O NOME DO CLIENTE PARA ALTERAR");
				String resp2 = input.next();
				
				cliente = clienteDAO.localizarCliente(resp2, 0);
								
				break;
				
			case 2:
				System.out.println("DIGITE O ID DO CLIENTE PARA ALTERAR");
				int resp3 = input.nextInt();
				
				cliente = clienteDAO.localizarCliente(null, resp3);
							
				break;
			case 0:
				break;
			default:
				System.out.println("OPCAO INVALIDA");
		}
		
		int id = cliente.getIdCliente();		
		
		Cliente novoCliente = informarCliente();
		novoCliente.setIdCliente(id);
					
		clienteDAO.alterarCliente(novoCliente);
		
	}
		
	//METODO PARA LOCALIZAR CLIENTES NO CRUD
	public static void localizarCliente(Conexao con) {
		
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO(con);

		System.out.println("[HOME/CLIENTE/LOCALIZAR]---------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU CLIENTE ------------");
		System.out.println("-- SELECIONE O CLIENTE PARA LOCALIZAR -");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO NOME DO CLIENTE	|");
		System.out.println("| 2- PELO ID DO CLIENTE		|");
		System.out.println("| 0- SAIR					|");
		System.out.println("|___________________________|");
		int resp = input.nextInt();
		
		switch(resp) {
		case 1:
			System.out.println("DIGITE O NOME DO CLIENTE");
			String nome = input.next();
			cliente = clienteDAO.localizarCliente(nome, 0);
			System.out.println(cliente);
			
			break;
			
		case 2:
			System.out.println("DIGITE O ID DO CLIENTE");
			int id = input.nextInt();
			cliente = clienteDAO.localizarCliente(null, id);
			System.out.println(cliente);
			break;
		case 0:
			break;
		}
				
	}
	
	//METODO PARA LISTAR OS CLIENTES NO CRUD
	public static void listarCliente(Conexao con) {
		
		System.out.println("[HOME/CLIENTE/LISTAR]------------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU CLIENTE ------------");
		System.out.println("-- EXIBINDO OS CLIENTES CADASTRADOS ---");
		System.out.println("---------------------------------------");
		
		ClienteDAO clienteDAO = new ClienteDAO(con);
		clienteDAO.listarClientes();
		
		
		
	}
		
	//METODO PARA EXCLUIR CLIENTE NO CRUD
	public static void excluirCliente(Conexao con) {
		
		
		ClienteDAO clienteDAO = new ClienteDAO(con);
		
		System.out.println("[HOME/CLIENTE/EXCLUIR]-----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU CLIENTE ------------");
		System.out.println("--- SELECIONE O CLIENTE PARA EXCLUIR --");
		System.out.println("---------------------------------------");	
		System.out.println("| 1- PELO NOME DO CLIENTE	|");
		System.out.println("| 2- PELO ID DO CLIENTE		|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		int resp = input.nextInt();
		
		switch (resp) {
			case 2:
				System.out.println("DIGITE O ID DO CLIENTE PARA EXCLUIR");
				int resp2 = input.nextInt();
				clienteDAO.apagarCliente(resp2);
				break;
				
				
			case 1:
				System.out.println("DIGITE O NOME DO CLIENTE PARA EXCLUIR");
				String resp3= input.next();
				
				Cliente cliente = clienteDAO.localizarCliente(resp3, 0);
				
				clienteDAO.apagarCliente(cliente.getIdCliente());
				break;
			case 0:
				break;
			
			default:
				System.out.println("Opcao invalida");
		}	
		
	}
	
		

	
	//---------------------------------------------------------------------------------------------------------------------
	//METODO CATEGORIA
	
		
	public static void menuCategoria(Conexao con) {
		
		int opcao;
			
		do {
			System.out.println("[HOME/CATEGORIA]-----------------------");
			System.out.println("---------------------------------------");
			System.out.println("------------ MENU CATEGORIA -----------");
			System.out.println("---------- SELECIONE UMA OPCAO --------");
			System.out.println("---------------------------------------");
			menuCRUD();
			opcao = input.nextInt();
			
			switch(opcao) {
			case 1: incluirCategoria(con ); break;
			case 2: alterarCategoria(con); break;
			case 3: excluirCategoria(con); break;
			case 4: localizarCategoria(con); break;
			case 5: listarCategoria(con); break;
			case 6:  break;
			default: System.out.println("Opcao invalida.");
			}
		} while (opcao != 6);
		
	}
	
	private static Categoria informarCategoria() {
		Categoria categoria = new Categoria();
		
		System.out.println("DIGITE O NOME DA CATEGORIA");
		String nome = input.next();
		System.out.println("DIGITE A DESCRICAO DA CATEGORIA");
		String descricao = input.next();
		
		categoria.setDescricaoCategoria(descricao);
		categoria.setNomeCategoria(nome);
		
		
		return categoria;
	}
		
	//METODO PARA INCLUIR CATEGORIA NO CRUD
	public static void incluirCategoria(Conexao con) {
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(con);
		
		System.out.println("[HOME/CATEGORIA/INCLUIR]---------------");
		System.out.println("---------------------------------------");
		System.out.println("------------ MENU CATEGORIA -----------");
		System.out.println("---------------------------------------");
		
		Categoria categoria = informarCategoria();
		
		categoriaDAO.incluirCategoria(categoria);
		
	}
	
	//METODO PARA ALTERAR UM CATEGORIA NO CRUD
	public static void alterarCategoria(Conexao con) {
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(con);
		
		
		System.out.println("[HOME/CATEGORIA/ALTERAR]---------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU CATEGORIA ----------");
		System.out.println("- SELECIONE O CATEGORIA PARA ALTERAR --");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO NOME DA CATEGORIA	|");
		System.out.println("| 2- PELO ID DA CATEGORIA	|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		
		int resp = input.nextInt();
		
		Categoria categoria = new Categoria();
		
		switch(resp) {
			case 1:
				System.out.println("DIGITE O NOME DA CATEGORIA");
				String resp2 = input.next();
				
				categoria = categoriaDAO.localizarCategoria(0,resp2);
				break;
				
			case 2:
				System.out.println("DIGITE O ID DA CATEGORIA");
				int resp3 = input.nextInt();
				
				categoria = categoriaDAO.localizarCategoria(resp3, null);
				
				break;
			case 0:
				break;
			default:
				System.out.println("OPCAO INVALIDA");
		
		}
		
		int id = categoria.getIdcategoria();		
		
		System.out.println("---------------------------------------");
		System.out.println("- DIGITE OS NOVOS DADOS DA CATEGORIA --");
		System.out.println("---------------------------------------");
		Categoria novaCategoria = informarCategoria();
		novaCategoria.setIdcategoria(id);
		
		categoriaDAO.alterarCategoria(novaCategoria);
					
		System.out.println("\n----\nPRODUTO ALTERADO COM SUCESSO");
			
	
	}
	
	//METODO PARA EXCLUIR UM CATEGORIA NO CRUD
	public static void excluirCategoria(Conexao con) {
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(con);
		
		
		System.out.println("[HOME/CATEGORIA/EXCLUIR]---------------");
		System.out.println("---------------------------------------");
		System.out.println("------------ MENU CATEGORIA -----------");
		System.out.println("- SELECIONE A CATEGORIA PARA EXCLUIR --");
		System.out.println("---------------------------------------");	
		System.out.println("| 1- PELO NOME DA CATEGORIA	|");
		System.out.println("| 2- PELO ID DA CATEGORIA	|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		
		int resp = input.nextInt();
		
		Categoria categoria = new Categoria();
		
		switch(resp) {
			case 1:
				System.out.println("DIGITE O NOME DA CATEGORIA");
				String resp2 = input.next();
				
				categoria = categoriaDAO.localizarCategoria(0,resp2);
				categoriaDAO.apagarCategoria(categoria.getIdcategoria());
				
				break;
				
			case 2:
				System.out.println("DIGITE O ID DA CATEGORIA");
				int resp3 = input.nextInt();
				
				categoriaDAO.apagarCategoria(resp3);
				
				break;
			case 0:
				break;
			default:
				System.out.println("OPCAO INVALIDA");
		
		}	
		
	}
	
	//METODO PARA LOCALIZAR UM CATEGORIA NO CRUD
	public static void localizarCategoria(Conexao con) {
				
		Categoria categoria = new Categoria();
		CategoriaDAO categoriaDAO = new CategoriaDAO(con);
		
		System.out.println("[HOME/CATEGORIA/LOCALIZAR]-------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PRODUTO ------------");
		System.out.println("-- SELECIONE O PRODUTO PARA LOCALIZAR -");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO NOME DO PRODUTO	|");
		System.out.println("| 2- PELO ID DO PRODUTO		|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		int resp = input.nextInt();
		
		switch(resp) {
		case 1:
			System.out.println("DIGITE O NOME DA CATEGORIA");
			String nome =input.next();
			
			categoria = categoriaDAO.localizarCategoria(0,nome);
			break;
			
		case 2:
			System.out.println("DIGITE O ID DA CATEGORIA");
			int id =input.nextInt();
			categoria = categoriaDAO.localizarCategoria(id,null);
			break;
		case 0:
			break;
		}		
		System.out.println(categoria);		
	}
	
	//METODO PARA LISTAR OS PRODUTOS NO CRUD
	public static void listarCategoria(Conexao con) {
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(con);
		
		System.out.println("[HOME/CATEGORIA/LISTAR]----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU CATEGORIA ----------");
		System.out.println("- EXIBINDO AS CATEGORIAS CADASTRADAS --");
		System.out.println("---------------------------------------");
		
		categoriaDAO.listarCategorias();		
	}
	
		
	//METODO DOS PRODUTOS
	
	private static Produto informarProduto() {
		
		System.out.println("DIGITE O NOME DO PRODUTO");
		String nomeProduto = input.next();
		System.out.println("DIGITE A DESCRICAO DO PRODUTO");
		String descricaoProd = input.next();
		System.out.println("DIGITE A DATA DE FABRICACAO DO PRODUTO");
		Timestamp dataFab = receberTimestamp();
		System.out.println("DIGITE O ESTOQUE DO PRODUTO");
		int estoque = input.nextInt();
		System.out.println("DIGITE O PRECO DO PRODUTO");
		Double precoProduto = input.nextDouble();
		System.out.println("DIGITE O IDCATEGORIA DO PRODUTO");
		System.out.println("[ 1- INFORMATICA | 2- CELULARES | 3- GAMES ]");
		int idcategoria = input.nextInt();
				
		Produto produto = new Produto();
		
		produto.setNomeProduto(nomeProduto);
		produto.setDataFabProduto(dataFab);
		produto.setDescricaoProduto(descricaoProd);
		produto.setIdCategoria(idcategoria);
		produto.setQntProduto(estoque);
		produto.setValorUnitProduto(precoProduto);

		
		return produto;
	}
		
	
	//METODOS PRINCIPAIS
	//METODO DO MENU PRINCIPAL DO PRODUTO
	public static void menuProduto(Conexao con) {
		
		int opcao;
			
		do {
			System.out.println("[HOME/PRODUTO]-------------------------");
			System.out.println("---------------------------------------");
			System.out.println("------------- MENU PRODUTO ------------");
			System.out.println("---------- SELECIONE UMA OPCAO --------");
			System.out.println("---------------------------------------");
			menuCRUD();
			opcao = input.nextInt();
			
			switch(opcao) {
			case 1: incluirProduto(con ); break;
			case 2: alterarProduto(con); break;
			case 3: excluirProduto(con); break;
			case 4: localizarProduto(con); break;
			case 5: listarProdutos(con); break;
			case 6:  break;
			default: System.out.println("Opcao invalida.");
			}
		} while (opcao != 6);
		
	}
		
	//METODO PARA INCLUIR PRODUTO NO CRUD
	public static void incluirProduto(Conexao con) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		
		System.out.println("[HOME/PRODUTO/INCLUIR]-----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PRODUTO ------------");
		System.out.println("---------------------------------------");
		
		Produto produto = informarProduto();
		
		produtoDAO.incluirProduto(produto);
		
	}
		
	//METODO PARA ALTERAR UM PRODUTO NO CRUD
	public static void alterarProduto(Conexao con) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		
		
		System.out.println("[HOME/PRODUTO/ALTERAR]-----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PRODUTO ------------");
		System.out.println("--- SELECIONE O PRODUTO PARA ALTERAR --");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO NOME DO PRODUTO	|");
		System.out.println("| 2- PELO ID DO PRODUTO		|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		
		int resp = input.nextInt();
		
		Produto produto = new Produto();
		if (resp!=0) {
			switch(resp) {
				case 1:
						System.out.println("DIGITE O NOME DO PRODUTO");
						String resp2 = input.next();
						
						produto = produtoDAO.localizarProduto(resp2, 0);
						break;
						
				case 2:
						System.out.println("DIGITE O ID DO PRODUTO");
						int resp3 = input.nextInt();
						
						produto = produtoDAO.localizarProduto(null, resp3);
						
						break;
				
				default:
						System.out.println("OPCAO INVALIDA");
			}
		
			int id = produto.getIdProduto();		
			
			System.out.println("---------------------------------------");
			System.out.println("--- DIGITE OS NOVOS DADOS DO PRODUTO --");
			System.out.println("---------------------------------------");
			Produto novoProduto = informarProduto();
			novoProduto.setIdProduto(id);
			
			produtoDAO.alterarProduto(novoProduto);
						
			System.out.println("\n----\nPRODUTO ALTERADO COM SUCESSO");
		}
	
	}
	
	//METODO PARA EXCLUIR UM PRODUTO NO CRUD
	public static void excluirProduto(Conexao con) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		
		
		System.out.println("[HOME/PRODUTO/EXCLUIR]-----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PRODUTO ------------");
		System.out.println("--- SELECIONE O PRODUTO PARA EXCLUIR --");
		System.out.println("---------------------------------------");	
		System.out.println("| 1- PELO NOME DO PRODUTO	|");
		System.out.println("| 2- PELO ID DO PRODUTO		|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		
		int resp = input.nextInt();
		
		Produto produto = new Produto();
		
		switch(resp) {
			case 1:
				System.out.println("DIGITE O NOME DO PRODUTO");
				String resp2 = input.next();
				
				produto = produtoDAO.localizarProduto(resp2, 0);
				produtoDAO.apagarProduto(produto, 0);
				
				break;
				
			case 2:
				System.out.println("DIGITE O ID DO PRODUTO");
				int resp3 = input.nextInt();
				
				produtoDAO.apagarProduto(null, resp3);
				
				break;
			case 0:
				break;
			default:
				System.out.println("OPCAO INVALIDA");
		
		}	
		
	}
	
	//METODO PARA LOCALIZAR UM PRODUTO NO CRUD
	public static void localizarProduto(Conexao con) {
			
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		
		System.out.println("[HOME/PRODUTO/LOCALIZAR]---------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PRODUTO ------------");
		System.out.println("-- SELECIONE O PRODUTO PARA LOCALIZAR -");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO NOME DO PRODUTO	|");
		System.out.println("| 2- PELO ID DO PRODUTO		|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		int resp = input.nextInt();
		
		switch(resp) {
			case 1:
				System.out.println("DIGITE O NOME DO PRODUTO");
				String nome =input.next();
				
				produto = produtoDAO.localizarProduto(nome, 0);
				System.out.println(produto);
				break;
				
			case 2:
				System.out.println("DIGITE O ID DO PRODUTO");
				int id =input.nextInt();
				produto = produtoDAO.localizarProduto(null, id);
				System.out.println(produto);
				break;
			case 0:
				break;
			default:
					System.out.println("OPCAO INVALIDA");
		}		
		
	}
			
	//METODO PARA LISTAR OS PRODUTOS NO CRUD
	public static void listarProdutos(Conexao con) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		
		System.out.println("[HOME/PRODUTO/LISTAR]------------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PRODUTOS ------------");
		System.out.println("--- EXIBINDO OS PRODUTOS CADASTRADOS --");
		System.out.println("---------------------------------------");
		
		produtoDAO.listarProdutos();		
	}
		
	
	//-------------------------------------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------------------------------------------------
	//METODOS DO EMPRESA
	
	//METODOS AUXILIARES
	//METODO PARA PREENCHIMENTO DOS DADOS DA EMPRESA
	public static Empresa informarEmpresa() {
		
		Empresa empresa = new Empresa();
	
		
		System.out.println("DIGITE A RAZAO SOCIAL DA EMPRESA");
		String nome = input.next();
		System.out.println("DIGITE O CNPJ DA EMPRESA");
		String cpf =  input.next();
		System.out.println("DIGITE O TELEFONE DA EMPRESA");
		String tel = input.next();
		System.out.println("DIGITE O ENDERECO: NOME RUA");
		String endereco = input.next();
		System.out.println("DIGITE O ENDERECO: NUMERO CASA ");
		String nrEndereco = input.next();
		System.out.println("DIGITE O ENDERECO: COMPLEMENTO ");
		String comple = input.next();
		System.out.println("DIGITE O ENDERECO: CEP ");
		String cep = input.next();
		System.out.println("DIGITE O ENDERECO: BAIRRO ");
		String bairro = input.next();
		System.out.println("DIGITE O ENDERECO: CIDADE ");
		String cidade = input.next();
		
		empresa.setRazaoSocial(nome);
		empresa.setBairro(bairro);
		empresa.setCep(cep);
		empresa.setCidade(cidade);
		empresa.setCnpj(cpf);
		empresa.setTelefone(tel);
		empresa.setComplemento(comple);
		empresa.setEndereco(endereco);
		empresa.setNrEndereco(nrEndereco);
		
		return empresa;
	}
	
	
	public static void menuEmpresa(Conexao con) {
		
		int opcao;
			
		do {
			System.out.println("[HOME/EMPRESA]-------------------------");
			System.out.println("---------------------------------------");
			System.out.println("------------ MENU EMPRESA -------------");
			System.out.println("---------- SELECIONE UMA OPCAO --------");
			System.out.println("---------------------------------------");
			menuCRUD();
			opcao = input.nextInt();
			
			switch(opcao) {
			case 1: incluirEmpresa(con ); break;
			case 2: alterarEmpresa(con); break;
			case 3: excluirEmpresa(con); break;
			case 4: localizarEmpresa(con); break;
			case 5: listarEmpresa(con); break;
			case 6:  break;
			default: System.out.println("Opcao invalida.");
			}
		} while (opcao != 6);
		
	}
	
	
	
	//METODO PARA INCLUIR EMPRESA NO CRUD
	public static void incluirEmpresa(Conexao con) {
		
		EmpresaDAO empresaDAO = new EmpresaDAO(con);
				
		Empresa empresa = informarEmpresa();
						
		empresaDAO.incluirEmpresa(empresa);
				
	}
		
	
	//METODO PARA ALTERAR CLIENTES NO CRUD
	public static void alterarEmpresa(Conexao con) {
		
		
		EmpresaDAO empresaDAO = new EmpresaDAO(con);
		Empresa empresa = new Empresa();
				
		System.out.println("[HOME/EMPRESA/ALTERAR]-----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU EMPRESA ------------");
		System.out.println("--- SELECIONE A EMPRESA PARA ALTERAR --");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO NOME DA EMPRESA	|");
		System.out.println("| 2- PELO ID DA EMPRESA		|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		
		int resp = input.nextInt();
			
		if (resp!=0) {
			switch(resp) {
				case 1:
					System.out.println("DIGITE O NOME DA EMPRESA PARA ALTERAR");
					String resp2 = input.next();
					
					empresa = empresaDAO.localizarEmpresa(resp2, 0);
									
					break;
					
				case 2:
					System.out.println("DIGITE O ID DA EMPRESA PARA ALTERAR");
					int resp3 = input.nextInt();
					
					empresa = empresaDAO.localizarEmpresa(null, resp3);
								
					break;
				
				default:
					System.out.println("OPCAO INVALIDA");
			}
			
			int id = empresa.getIdEmpresa();		
			System.out.println("---------------------------------------");
			System.out.println("--------- ALTERANDO EMPRESA -----------");
			System.out.println("--- DIGITE OS NOVOS DADOS DA EMPRESA --");
			System.out.println("---------------------------------------");
			Empresa novaEmpresa = informarEmpresa();
			novaEmpresa.setIdEmpresa(id);
						
			empresaDAO.alterarEmpresa(novaEmpresa);
		}
	}
		
	//METODO PARA LOCALIZAR CLIENTES NO CRUD
	public static void localizarEmpresa(Conexao con) {
		
		
		Empresa empresa = new Empresa();
		EmpresaDAO empresaDAO = new EmpresaDAO(con);

		System.out.println("[HOME/EMPRESA/LOCALIZAR]---------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU EMPRESA ------------");
		System.out.println("-- SELECIONE A EMPRESA PARA LOCALIZAR -");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELA RAZAO SOCIAL DA EMPRESA	|");
		System.out.println("| 2- PELO ID DA EMPRESA			|");
		System.out.println("| 0- SAIR				|");
		System.out.println("|_______________________________________|");
		int resp = input.nextInt();
		
		switch(resp) {
		case 1:
			System.out.println("DIGITE A RAZAO SOCUAL DA EMPRESA");
			String nome = input.next();
			empresa = empresaDAO.localizarEmpresa(nome, 0);
			System.out.println(empresa);
			
			break;
			
		case 2:
			System.out.println("DIGITE O ID DA EMPRESA");
			int id = input.nextInt();
			empresa = empresaDAO.localizarEmpresa(null, id);
			System.out.println(empresa);
			break;
		case 0:
			break;
		}
				
	}
	
	//METODO PARA LISTAR OS CLIENTES NO CRUD
	public static void listarEmpresa(Conexao con) {
		
		System.out.println("[HOME/EMPRESA/LISTAR]------------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU EMPRESA ------------");
		System.out.println("-- EXIBINDO AS EMPRESAS CADASTRADAS ---");
		System.out.println("---------------------------------------");
		System.out.println("\n");
		EmpresaDAO empresaDAO = new EmpresaDAO(con);
		
		empresaDAO.listarEmpresas();
		
		System.out.println("\n\n");
		
	}
		  
	
	//METODO PARA EXCLUIR CLIENTE NO CRUD
	public static void excluirEmpresa(Conexao con) {
		
		
		EmpresaDAO empresaDAO = new EmpresaDAO(con);
		
		System.out.println("[HOME/EMPRESA/EXCLUIR]-----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU EMPRESA ------------");
		System.out.println("--- SELECIONE A EMPRESA PARA EXCLUIR --");
		System.out.println("---------------------------------------");	
		System.out.println("| 1- PELA RAZAO SOCIAL DA EMPRESA	|");
		System.out.println("| 2- PELO ID DA EMPRESA			|");
		System.out.println("| 0- SAIR				|");
		System.out.println("|_______________________________________|");
		int resp = input.nextInt();
		
		switch (resp) {
			case 2:
				System.out.println("DIGITE O ID DA EMPRESA PARA EXCLUIR");
				int resp2 = input.nextInt();
				empresaDAO.apagarEmpresa(null,resp2);
				break;
				
				
			case 1:
				System.out.println("DIGITE A RAZAO SOCIAL DA EMPRESA PARA EXCLUIR");
				String resp3= input.next();
				
				Empresa empresa = empresaDAO.localizarEmpresa(resp3, 0);
				
				empresaDAO.apagarEmpresa(null,empresa.getIdEmpresa());
				break;
			case 0:
				break;
			
			default:
				System.out.println("Opcao invalida");
		}	
		
	}
		
	
	
	//-------------------------------------------------------------------------------------------------
	
	
	
	//-------------------------------------------------------------------------------------------------
	//METODOS PEDIDOS
	//METODOS AUXILIARES	
		
	//METODO PARA PREENCHIMENTO DOS DADOS DO PEDIDO
	private static Pedido informarPedido() {
		
		
		Pedido pedido = new Pedido();
		
		System.out.println("DIGITE O ID DA EMPRESA VENDEDORA");
		int idEmpresa = input.nextInt();
		
		System.out.println("DIGITE O ID DO CLIENTE DO PEDIDO");
		int idCliente = input.nextInt();
		
		System.out.println("DIGITE A DATA DE EMISSAO DA NOTA");
		Timestamp dataNota = receberTimestamp();
		
		pedido.setIdEmpresa(idEmpresa);
		pedido.setDataEmissao(dataNota);
		pedido.setIdCliente(idCliente);
		pedido.setValorTotal(0.0);
		
		
		return pedido;
		
	}
	
	//METODO PARA PREENCHER ITENS DO PEDIDO - COMPRA
	private static PedidoItem informarItensPedido(int idPedido, Conexao con) {
		PedidoItem pedidoItem = new PedidoItem();
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		
					
		System.out.println("DIGITE O ID DO PRODUTO QUE DESEJA COMPRAR");
		int idProduto = input.nextInt();
		
		System.out.println("DIGITE A QUANTIDADE QUE DESEJA COMPRAR");
		int qntCompra = input.nextInt();
		
		System.out.println("DIGITE O VALOR DA % DE DESCONTO DA COMPRA (10% = 10)");
		Double percDesc = input.nextDouble();
				
		Produto produto = produtoDAO.localizarProduto(null, idProduto);
		
		Double precoUnit = produto.getValorUnitProduto();
		Double valorDesc = (qntCompra*precoUnit)*(percDesc/100); 
		Double valorParcial = (qntCompra*precoUnit)*(1-(percDesc/100));
				
		pedidoItem.setIdPedido(idPedido);
		pedidoItem.setIdProduto(idProduto);
		pedidoItem.setPrecoUnit(precoUnit);
		pedidoItem.setQntPedido(qntCompra);
		pedidoItem.setValorDesc(valorDesc);
		pedidoItem.setPercDesc(percDesc);
		pedidoItem.setValorParcial(valorParcial);
				
		return pedidoItem;
	}
	
	//METODO PARA PREPARAR O PEDIDO
	private static Pedido prepararPedido(Conexao con) {
		
		Pedido pedidoVazio = informarPedido();
		PedidoDAO pedVazioDAO = new PedidoDAO(con);
		
		pedVazioDAO.incluirPedido(pedidoVazio);
		
		int idPedido = pedVazioDAO.acharPedidoData(pedidoVazio.getDataEmissao());
		pedidoVazio.setIdPedido(idPedido);
				
		return pedidoVazio;
	}
		
	//METODO PARA LOCALIZAR UM PEDIDO PELO CLIENTE
	private static void localizarPedidoCliente (Conexao con) {
		PedidoDAO pedidoDAO = new PedidoDAO(con);
		PedidoItemDAO pedidoItemDAO = new PedidoItemDAO(con);
		ArrayList<Pedido> listaPedido = new ArrayList<>();
		ClienteDAO clienteDAO = new ClienteDAO(con);
		
		System.out.println("[HOME/PEDIDO/LOCALIZAR/CLIENTE]--------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("---------- LOCALIZANDO PEDIDO ---------");
		System.out.println("---------------------------------------");
		System.out.println("------ COMO DESEJA ACHAR O PEDIDO? ----");
		System.out.println("---------------------------------------");
		System.out.println("| 1- ID CLIENTE		|");
		System.out.println("| 2- NOME CLIENTE	|");
		System.out.println("| 0- SAIR		|");
		System.out.println("|_______________________|");
		int resp2 = input.nextInt();
		
	
		switch(resp2) {
			case 1:
				
				System.out.println("DIGITE O ID DO CLIENTE DESEJADO");
				int resp3 = input.nextInt();
				
				listaPedido = pedidoDAO.localizarPedido(null, 0, resp3, null);
				
				System.out.println("LISTA DE PEDIDOS DO CLIENTE");
				for (Pedido p: listaPedido) {
					System.out.println(p);
				}
				
				System.out.println("LISTA DE ITENS DOS PEDIDOS DO CLIENTE");
				for (Pedido p: listaPedido) {
					pedidoItemDAO.listarPedido(p, 0, 0);
				}			
				break;
				
			case 2:
				
				System.out.println("DIGITE O NOME DO CLIENTE DESEJADO");
				String resp4 = input.next();
				Cliente cliente = clienteDAO.localizarCliente(resp4,0);
				
				listaPedido = pedidoDAO.localizarPedido(null, 0, cliente.getIdCliente(), null);
				
				System.out.println("LISTA DE PEDIDOS DO CLIENTE");
				for (Pedido p: listaPedido) {
					System.out.println(p);
				}
					
				System.out.println("LISTA DE ITENS DOS PEDIDOS DO CLIENTE");
				for (Pedido p: listaPedido) {
					pedidoItemDAO.listarPedido(p, 0, 0);
				}	
					
				break;	
				
			case 0:
				break;
			}	
		
	}
	
	//METODO PARA LOCALIZAR UM PEDIDO PELO IDPEDIDO
	private static void localizarPedidoPedido(Conexao con) {
		
		
		PedidoItemDAO pedidoItemDAO = new PedidoItemDAO(con);
		PedidoDAO pedidoDAO = new PedidoDAO(con);
		ArrayList<Pedido> listaPedido = new ArrayList<>();
		
		System.out.println("[HOME/PEDIDO/LOCALIZAR/PEDIDO]--------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("---------- LOCALIZANDO PEDIDO ---------");
		System.out.println("---------------------------------------");
		System.out.println("------ COMO DESEJA ACHAR O PEDIDO? ----");
		System.out.println("---------------------------------------");
		System.out.println("| 1- ID PEDIDO		|");
		System.out.println("| 2- DATA PEDIDO	|");
		System.out.println("| 0- SAIR		|");
		System.out.println("|_______________________|");
		int resp = input.nextInt();
		
		switch(resp) {
		case 1:
			System.out.println("DIGITE O ID DO PEDIDO");
			int resp2 =  input.nextInt();
			
			listaPedido = pedidoDAO.localizarPedido(null, resp2, 0, null);
			
			System.out.println("LISTA DE PEDIDOS");
			for (Pedido p: listaPedido) {
				System.out.println(p);
			}
			
			System.out.println("LISTA DE PRODUDOS DO PEDIDO");
			pedidoItemDAO.listarPedido(null, resp2,0);
			
			break;
		
		case 2:
			System.out.println("DIGITE O A DATA DO PEDIDO");
			Timestamp resp3 = receberTimestamp();
			
			listaPedido = pedidoDAO.localizarPedido(null, 0, 0, resp3);
			
			System.out.println("LISTA DE PEDIDOS");
			for (Pedido p: listaPedido) {
				System.out.println(p);			
				
			}
			
			System.out.println("LISTA DE ITENS DO PEDIDO");
			for (Pedido p: listaPedido) {
				pedidoItemDAO.listarPedido(p, 0, 0);		
				
			}
			
			break;
		case 0:
			break;
		}
		
	}
	
	//METODO PARA LOCALIZAR UM PEDIDO PELO PRODUTO
	private static void localizarPedidoProduto (Conexao con) {
		
		
		PedidoItemDAO pedidoItemDAO = new PedidoItemDAO(con);
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		
		System.out.println("[HOME/PEDIDO/LOCALIZAR/PRODUTO]--------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("---------- LOCALIZANDO PEDIDO ---------");
		System.out.println("---------------------------------------");
		System.out.println("------ COMO DESEJA ACHAR O PEDIDO? ----");
		System.out.println("---------------------------------------");
		System.out.println("| 1- ID PRODUTO		|");
		System.out.println("| 2- NOME PRODUTO	|");
		System.out.println("| 0- SAIR		|");
		System.out.println("|_______________________|");
		int resp =  input.nextInt();
				
		switch(resp) {
			case 1:
				System.out.println("DIGITE O ID DO PRODUTO");
				int resp2 =  input.nextInt();
				
				pedidoItemDAO.listarPedido(null, 0, resp2);
				break;
						
			case 2:
				System.out.println("DIGITE O NOME DO PRODUTO");
				String resp3 =  input.next();
				
				Produto produto = produtoDAO.localizarProduto(resp3, 0);
				
				pedidoItemDAO.listarPedido(null, 0, produto.getIdProduto());
				break;
			case 0:
				break;
			default:
				System.out.println("OPCAO INVALIDA");
		}
		
	}
		
	//METODO DO MENU PRINCIAL DO PRODUTO
	public static void menuPedido(Conexao con) {
		
		int opcao;
		
		do {
			System.out.println("[HOME/PEDIDO]--------------------------");
			System.out.println("---------------------------------------");
			System.out.println("------------- MENU PEDIDO -------------");
			System.out.println("---------- SELECIONE UMA OPCAO --------");
			System.out.println("---------------------------------------");
			menuCRUD();
			opcao = input.nextInt();
			
			switch(opcao) {
			case 1: incluirPedido(con ); break;
			case 2: alterarPedido(con); break;
			case 3: excluirPedido(con); break;
			case 4: localizarPedido(con); break;
			case 5: listarPedido(con); break;
			case 6:  break;
			default: System.out.println("Opcao invalida.");
			}
		} while (opcao != 6);
		
	}
	
	//METODO PARA INCLUIR UM PEDIDO NO BD
	public static void incluirPedido(Conexao con) {
		
		
		System.out.println("[HOME/PEDIDO/INCLUIR]------------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("---------- INCLUINDO PEDIDO -----------");
		System.out.println("---------------------------------------");
		
		//DECLARACAO DE VARIAVEIS
		int resp =1;
		PedidoItemDAO pedidoItemDAO = new PedidoItemDAO(con);
		PedidoDAO pedidoDAO = new PedidoDAO(con);
		Double total=0.0;
			
		
		//CRIANDO UM PEDIDO VAZIO
		Pedido pedido = prepararPedido(con);
		
		do {
			switch(resp) {
			
			case 1:
				//CRIANDO UM OBJETO PEDIDOITEM COM OS DADOS DO PEDIDO DO CLIENTE
				//O idPedido E FIXO CRIANDO VARIAS LINHAS COM PRODUTOS DIFERENTES NO MESMO PEDIDO
				//O idCliente ESTA GRAVADO NO PEDIDO
				PedidoItem pedidoItem = informarItensPedido(pedido.getIdPedido(),con);
				pedidoItemDAO.incluirPedidoItem(pedidoItem);
				
				//CRIACAO DE VARIAVEL PARA SOMAR O TOTAL PARCIAL DOS ITENS COMPRADOS
				//PARA PREENCHER O valorTotal DENTRO DO PEDIDO
				total += pedidoItem.getValorParcial();
				break;
			
			case 0:
				break;
			default:
				System.out.println("OPCAO INVALIDA");
			}
							
			//PERGUNTA PARA FINALIZAR A COMPRA OU NAO
			System.out.println("DESEJA CONTINUAR ADICIONANDO PRODUTOS?");
			System.out.println("[1- SIM | 0- NAO ]");
			resp = input.nextInt();
		}while(resp!=0);
		//FINALIZANDO O PREENCHIMENTO DO PEDIDO COM O TOTAL DAS COMPRAS
		pedido.setValorTotal(total);
		
		//ENVIANDO OS DADOS OBTIDOS PARA O DATABASE
		pedidoDAO.alterarPedido(pedido);
		
	}

	//METODO PARA ALTERAR UM PEDIDO
	public static void alterarPedido(Conexao con) {
		
		
		PedidoDAO pedidoDAO = new PedidoDAO(con);
		
		System.out.println("[HOME/PEDIDO/ALTERAR]------------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("- DIGITE O ID DO PEDIDO PARA ALTERAR --");
		System.out.println("---------------------------------------");
		int resp =  input.nextInt();
	
		Pedido pedidoAntes = pedidoDAO.acharPedidoID(resp);
		
		Pedido pedidoNovo = informarPedido();
		
		pedidoNovo.setIdPedido(pedidoAntes.getIdPedido());
		pedidoNovo.setValorTotal(pedidoAntes.getValorTotal());
		
		pedidoDAO.alterarPedido(pedidoNovo);
	
		
	}
	
	//METODO PARA EXCLUIR UM PEDIDO DO BANCO DE DADOS
	public static void excluirPedido(Conexao con) {
		//CRIACAO DE VARIAVEIS
		PedidoDAO pedidoDAO = new PedidoDAO(con);
		ArrayList<Pedido> listaPedido = new ArrayList<>();
		
		
		System.out.println("[HOME/PEDIDO/EXCLUIR]------------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("---------- SELECIONE UMA OPCAO --------");
		System.out.println("---------------------------------------");
		System.out.println("| 1- PELO ID DO CLIENTE		|");
		System.out.println("| 2- PELO ID DO PEDIDO		|");
		System.out.println("| 0- SAIR			|");
		System.out.println("|_______________________________|");
		int resp = input.nextInt();
		
		switch (resp) {
		
		case 1:
			System.out.println("ESTE METODO IRA APAGAR TODOS OS PEDIDOS DE UM CLIENTE");
			System.out.println("DIGITE O ID DO CLIENTE");
			int resp2 = input.nextInt();
			
			listaPedido = pedidoDAO.localizarPedido(null, 0, resp2, null);
			
			for (Pedido p: listaPedido) {
				
				pedidoDAO.apagarPedido(p.getIdPedido(), con);
				
			}
			
			System.out.println("PEDIDOS APAGADOS COM SUCESSO");
			
			break;
		case 2:
			//ENTRADA DE DADOS		
			System.out.println("DIGITE O ID DO PEDIDO PARA DELETAR");
			int idPedido = input.nextInt();
			//APAGANDO O PEDIDO ATRAVES DO ID INFORMADO NO BANCO DE DADOS		
			pedidoDAO.apagarPedido(idPedido, con);
			break;
		case 0:
			break;
			
		default:
			System.out.println("OPCAO INVALIDA");
		
		}	
		
	}

	//METODO PARA LISTAR PEDIDO
	//METODO PARA LISTAR OS PEDIDOS DO BANCO DE DADOS
	public static void listarPedido(Conexao con) {
		
		//MENU PRINCIPAL DO LOCALIZAR
		System.out.println("[HOME/PEDIDO/LISTAR]-------------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("------- LISTANDO TODOS OS PEDIDOS -----");
		System.out.println("---------------------------------------");
		PedidoDAO pedidoDAO = new PedidoDAO(con);
		
		//LISTANDO TODOS OS PEDIDOS
		pedidoDAO.listarPedido();
		System.out.println("\n\n");
	}
	
	
	
	//METODO PARA LOCALIAR PEDIDO
	//METODO PARA LOCALIZAR UM PEDIDO NO BANCO DE DADOS
	
	public static void localizarPedido(Conexao con) {
		
		
		System.out.println("[HOME/PEDIDO/LOCALIZAR]----------------");
		System.out.println("---------------------------------------");
		System.out.println("------------- MENU PEDIDO -------------");
		System.out.println("---------- SELECIONE UMA OPCAO --------");
		System.out.println("---------------------------------------");
		System.out.println("------ COMO DESEJA ACHAR O PEDIDO? ----");
		System.out.println("---------------------------------------");
		System.out.println("| 1- CLIENTE		|");
		System.out.println("| 2- PEDIDO		|");
		System.out.println("| 3- PRODUTO		|");
		System.out.println("| 0- SAIR		|");
		System.out.println("|_______________________|");
		int resp = input.nextInt();
				
		switch(resp) {
			case 1:
				localizarPedidoCliente(con);		
				break;
									
			case 2:
				localizarPedidoPedido(con);			
				break;
				
			case 3:
				localizarPedidoProduto(con);
				break;
			case 0:
				break;
				
			default:
				System.out.println("OPCAO INVALIDA");	
		}
		
	}


	


}
	
	
	
	
	
	
	