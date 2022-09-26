package dao.br.com.serratec;

//IMPORTACAO DE BIBLIOTECAS E CLASSES
import conexao.br.com.serratec.*;
import classes.br.com.serratec.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ClienteDAO {
	
	//DECLARACAO DE VARIAVEIS
	private Conexao conexao;
	private PreparedStatement pInclusao;
	private PreparedStatement pAlteracao;
	
	
	//CONSTRUTOR
	public ClienteDAO(Conexao conexao) {
		this.conexao = conexao;
				
		prepararSqlInclusao();
		prepararSqlAlteracao();
		
	}
	
	
	private void prepararSqlInclusao() {
		String sql = "insert into marketplace.cliente";
		sql += " (nome, cpf , tel , endereco , nrendereco , complemento , bairro , cidade , cep)";
		sql += " values ";
		sql += " ( ? , ?, ?, ?, ? , ? , ? , ? , ? )";
		
		try {
			pInclusao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
		
	
	private void prepararSqlAlteracao() {
		String sql = "update marketplace.cliente set";
		sql += " nome = ?,";
		sql += " cpf = ?,";
		sql += " tel = ?,";
		sql += " endereco = ?,";
		sql += " nrendereco = ?,";
		sql += " complemento = ?,";
		sql += " bairro = ?,";
		sql += " cidade = ?,";
		sql += " cep = ?";
		sql += " where idCliente = ?";
				
		try {
			pAlteracao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	
	public boolean existeClienteID(int idCliente) {
		ResultSet tabela;
		boolean retorno;
							
		//MONTAGEM DE SQL
		String sql = "select * from marketplace.cliente where idCliente = '" + idCliente +"'";
		
		tabela = conexao.query(sql);
		
		try {
			if (tabela.next()) {
				//se cliente existir
				tabela.close();
				retorno = true;
			} 
			else {
				retorno = false;
			}
			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return true;
		}
		
		return retorno;
		}
	
	public boolean existeClienteNome(String nomeCliente) {
		ResultSet tabela;
		boolean retorno;
							
		//MONTAGEM DE SQL
		String sql = "select * from marketplace.cliente where nome = '" + nomeCliente +"'";
		
		tabela = conexao.query(sql);
		
		try {
			if (tabela.next()) {
				//SE A CATEGORIA JA EXISTIR
				tabela.close();
				retorno = true;
			} 
			else {
				retorno = false;
			}
			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return true;
		}
		
		return retorno;
		}
		
	//METODO PARA VERIFICAR SE UM CLIENTE JA EXISTE PELO CLIENTE
	public boolean existeCliente(Cliente cliente , int idCliente) {
		ResultSet tabela;
		boolean retorno;
		String sql = "";
		
		
		if (cliente==null) {
			sql = "select * from marketplace.cliente where idCliente = '" + idCliente +"'";
		}
		else {
			sql = "select * from marketplace.cliente where cpf = '" + cliente.getCpf() +"'";
		}		
			
		//Guardando os dados da resposta obtida
		tabela = conexao.query(sql);
		
		try {
			//Conferindo se possui registro com o nome do produto informado
			if (tabela.next()) {
					tabela.close();
					retorno = true;
			} 
			else {
				//Se nao possui retorna falso
				retorno = false;
			}
			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return true;
		}
		//Retornando verdadeiro se existe e falso senao
		return retorno;
	}
			
	//METODO INCLUIR CLIENTE NO DATABASE
	public int incluirCliente(Cliente cliente) {
		//Verificando se ja existe o produto que deseja incluir
		if (!existeCliente(cliente,0)) {
			try {
				
				//Preenchendo o objeto pInclusao com os dados do produto
				pInclusao.setString(1, cliente.getNome());
				pInclusao.setString(2, cliente.getCpf());
				pInclusao.setString(3, cliente.getTel());
				pInclusao.setString(4, cliente.getEndereco());
				pInclusao.setString(5, cliente.getNrEndereco());
				pInclusao.setString(6, cliente.getComplemento());
				pInclusao.setString(7, cliente.getBairro());
				pInclusao.setString(8, cliente.getCidade());
				pInclusao.setString(9, cliente.getCep());
					
				//Executando a inclusao do produto no database
				return pInclusao.executeUpdate();
				
			} catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
				return 0;
			}
		} else 
			return 0;
	}
		
	//METODO ALTERANDO CLIENTE
	public int alterarCliente(Cliente cliente) {
		
		if (existeCliente(null,cliente.getIdCliente())) {
			try {		
				//Preenchendo o objeto pInclusao com os dados do produto
				pAlteracao.setString(1, cliente.getNome());
				pAlteracao.setString(2, cliente.getCpf());
				pAlteracao.setString(3, cliente.getTel());
				pAlteracao.setString(4, cliente.getEndereco());
				pAlteracao.setString(5, cliente.getNrEndereco());
				pAlteracao.setString(6, cliente.getComplemento());
				pAlteracao.setString(7, cliente.getBairro());
				pAlteracao.setString(8, cliente.getCidade());
				pAlteracao.setString(9, cliente.getCep());
				pAlteracao.setInt(10, cliente.getIdCliente());
				
				return pAlteracao.executeUpdate();
			} 
			catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
				return 0;
			}		
		} 
		else {
			return 0;
		}
	}
	
	//METODO PARA APAGAR UM CLIENTE
	public void apagarCliente(int idCliente) {
		
		String sql = "";
		
		if (existeCliente(null,idCliente)) {
			//MONTAGEM DO SQL
			sql = "delete from marketplace.cliente";
			sql += " where idcliente = " + idCliente;	
			
		}
		
		conexao.query(sql);	
		
	}
	
	//METODO PARA LOCALIZAR CLIENTE ATRAVES DO NOME OU DO IDCLIENTE
	public Cliente localizarCliente(String nome, int idCliente) {
		//DECLARACAO DE VARIAVEIS
		Cliente cliente = new Cliente();
		ResultSet tabela;
		String sql;
		
		//MONTAGEM DO SQL
		//CASO TENHA O NOME PROCURA DIRETO POR ELE, SENAO PROCURA PELO ID
		if (nome == null) {
			//PROCURANDO PELO ID
			sql = "select * from marketplace.cliente where idcliente = " + idCliente;
		} else {
			//PROCURANDO PELO NOME
			sql = "select * from marketplace.cliente where nome = '" + nome + "'";
		}
		
		//ARMAZENANDO OS DADOS RECEBIDOS
		tabela = conexao.query(sql);
		
		//PREECHIMENTO DO OBJETO CLIENTE COM OS DADOS OBTIDOS
		try {
			if (tabela.next()) {	
				
				cliente.setIdCliente(tabela.getInt("idcliente"));
				cliente.setNome(tabela.getString("nome"));
				cliente.setCpf(tabela.getString("cpf"));
				cliente.setTel(tabela.getString("tel"));
				cliente.setEndereco(tabela.getString("endereco"));
				cliente.setNrEndereco(tabela.getString("nrendereco"));
				cliente.setComplemento(tabela.getString("complemento"));
				cliente.setBairro(tabela.getString("bairro"));
				cliente.setCidade(tabela.getString("cidade"));
				cliente.setCep(tabela.getString("cep"));
				
			} else {
				
				System.out.println("\nCLIENTE NAO ENCONTRADO.");
			}
		} catch  (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		//RETORNO DO OBJETO
		return cliente;
	}

	
	//METODO PARA LSITAR CLIENTES
	public void listarClientes() {
		ResultSet tabela;		
		
		//MONTAGEM DO SQL
		String sql;
		sql = "select * from marketplace.cliente order by idcliente";
		
		tabela = conexao.query(sql);
		
		//Preenchimento do objeto
		try {			
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("Quantidade de clientes: " +rowCount);	
			if (rowCount > 0) {
				System.out.println("\n");
				System.out.printf("IdCliente\tNome\t\tCPF\t\tTelefone\tEndereco\tNrEndereco\tComplemento\tBairro\t\tCidade\t\tCEP\n");
			} else {
				System.out.println("\nNao possui dados.");
				return;
			}
			
			tabela.beforeFirst();
			
			while (tabela.next()) {
					
				System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
					tabela.getInt("idcliente"),
					tabela.getString("nome"),
					tabela.getString("cpf"),
					tabela.getString("tel"),
					tabela.getString("endereco"),
					tabela.getString("nrendereco"),
					tabela.getString("complemento"),
					tabela.getString("bairro"),
					tabela.getString("cidade"),
					tabela.getString("cep")
					);
			}
			
			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	
	
}