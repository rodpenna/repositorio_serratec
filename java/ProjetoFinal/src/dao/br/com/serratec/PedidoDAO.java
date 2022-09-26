package dao.br.com.serratec;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

//import classes.br.com.serratec.Cliente;
import classes.br.com.serratec.Pedido;
import conexao.br.com.serratec.Conexao;
import utils.br.com.serratec.Utils;



public class PedidoDAO {
	//DECLARACAO DE VARIAVEIS
	private Conexao conexao;
	private PreparedStatement pInclusao;
	private PreparedStatement pAlteracao;
	
	public PedidoDAO(Conexao conexao) {
		this.conexao = conexao;
		
		prepararSqlInclusao();
		prepararSqlAlteracao();
	}

	
	private void prepararSqlInclusao() {
		String sql = "insert into marketplace.pedido";
		sql += " ( idEmpresa , idCliente, valorTotal, dataEmissao )";
		sql += " values ";
		sql += " ( ?, ? , ? , ?)";
		
		try {
			pInclusao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
		
	private void prepararSqlAlteracao() {
		String sql = "update marketplace.pedido set";
		sql += " idCliente = ?,";
		sql += " dataEmissao = ?,";
		sql += " valorTotal = ?";
		sql += " where idPedido = ?";
				
		try {
			pAlteracao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	
	
	
	//METODO PARA VERIFICAR SE UM PRODUTO JA EXISTE PELO ID_PEDIDO_ITEM
	public boolean existePedido(Pedido pedido , int idPedido , int idCliente , Timestamp dataEmissao) {
		ResultSet tabela;
		boolean retorno;
		String sql = "";
		
		if (idPedido ==0 && idCliente==0 && dataEmissao==null) {
			sql = "select idPedido from marketplace.pedido where idPedido = '" + pedido.getIdPedido() +"'";
			
		}
		if (pedido ==null && idCliente==0&& dataEmissao==null) {
			sql = "select idPedido from marketplace.pedido where idPedido = '" + idPedido +"'";
			
		}
		if (pedido ==null && idPedido==0&& dataEmissao==null) {
			sql = "select idCliente from marketplace.pedido where idCliente = '" + idCliente +"'";
			
		}
		if (pedido ==null && idPedido==0 && idCliente==0 ) {
			sql = "select dataEmissao from marketplace.pedido where dataEmissao = '" + dataEmissao +"'";
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
	
	//METODO PARA INCLUIR UM PEDIDO NO BD
	public int incluirPedido(Pedido pedido) {
	//Verificando se ja existe o produto que deseja incluir
		
		if (!existePedido(pedido,0,0 , null)){
			try {
				//Preenchendo o objeto pInclusao com os dados do produto
				
				pInclusao.setInt(1, pedido.getIdEmpresa());
				pInclusao.setInt(2, pedido.getIdCliente());
				pInclusao.setDouble(3, pedido.getValorTotal());
				pInclusao.setTimestamp(4, pedido.getDataEmissao());
				
				
				//Executando a inclusao do produto no database
				return pInclusao.executeUpdate();
				
			} catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
				return 0;
			}
		}
		else {
			return 0;
		}
		
	}
			
	//METODO PARA ALTERAR UM PEDIDO NO BD
	public int alterarPedido(Pedido pedido) {
		//VERIFICANDO SE EXISTE PEDIDO
		if (existePedido(null,pedido.getIdPedido(),0,null)) {
			try {		
					
				pAlteracao.setInt(1, pedido.getIdCliente());;
				pAlteracao.setTimestamp(2, pedido.getDataEmissao());
				pAlteracao.setDouble(3, pedido.getValorTotal());
				pAlteracao.setInt(4, pedido.getIdPedido());;
				
				return pAlteracao.executeUpdate();
			} 
			catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
				return 0;
			}		
		} 
		else {
			System.out.println("O PEDIDO NAO EXISTE");
			return 0;
		}
	}
		
	//METODO PARA RECEBER UMA LISTA DE PEDIDOS APARTIR DE UM
	public ArrayList<Pedido> localizarPedido (Pedido pedido , int idPedido , int idCliente , Timestamp dataEmissao) {
		//Criando as variaveis
		ArrayList<Pedido> listaPedido = new ArrayList<>();
		String sql = "";
		ResultSet tabela;
		
		//DEFININDO A FORMA DE CONSULTA NO DATABASE
		//CONSULTA PELO IDPEDIDO RECEBIDO PELO PARAMETRO
		if (pedido == null && idCliente ==0 && dataEmissao == null) {
			if (existePedido(null,idPedido,0,null)) {
				sql =	"select * from marketplace.pedido";
				sql +=	" where idPedido = '" + idPedido +"'";
			}
			else {
			System.out.println("PEDIDO NAO CADASTRADO");
			}
		}
		
		//CONSULTA PELO ID PEDIDO DENTRO DO PEDIDO RECEBIDO COMO PARAMETRO
		if (idPedido == 0 && idCliente ==0 && dataEmissao == null) {
			if (existePedido(pedido,0,0,null)) {
				sql = "select * from marketplace.pedido";
				sql += " where idPedido = '" + pedido.getIdPedido() +"'";
			}
			else {
			System.out.println("PEDIDO NAO CADASTRADO");
			}
		}
		
		//CONSULTA PELA DATA DE EMISSAO RECEBIDO COMO PARAMETRO
		if (pedido == null && idPedido == 0 && idCliente ==0 ) {
			if (existePedido(null,0,0,dataEmissao)) {
				sql = "select * from marketplace.pedido";
				sql += " where dataEmissao = '" + dataEmissao +"'";
			}
			else {
			System.out.println("PEDIDO NAO CADASTRADO");
			}
		}
		//CONSULTA PELO ID DO CLIENTE
		if (pedido == null && idPedido ==0 && dataEmissao == null) {
			if (existePedido(null,0,idCliente,null)) {
				sql = "select * from marketplace.pedido";
				sql += " where idCliente = '" + idCliente +"'";
			}
			else {
			System.out.println("PEDIDO NAO CADASTRADO");
			}
		}
		
		
		tabela = conexao.query(sql);
			
		try {
			
			while (tabela.next()) {
				Pedido pedidoDatabase = new Pedido();
				pedidoDatabase.setDataEmissao(tabela.getTimestamp("dataEmissao"));
				pedidoDatabase.setIdCliente(tabela.getInt("idCliente"));
				pedidoDatabase.setIdEmpresa(tabela.getInt("idEmpresa"));
				pedidoDatabase.setIdPedido(tabela.getInt("idPedido"));
				pedidoDatabase.setValorTotal(tabela.getDouble("valorTotal"));
									
				listaPedido.add(pedidoDatabase);
			}			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
		return listaPedido;
	}
	
	//METODO PARA LISTAR OS PEDIDOS 
	public void listarPedido() {
				
		ResultSet tabela;
			
		//Montagem do SQL
		String sql = "select * ";		
		sql += " from marketplace.pedido p";
		sql += " order by p.idPedido";
			
		
		tabela = conexao.query(sql);		
				
		try {
			//Montagem do Cabecalho
			if (tabela.next()) {
				System.out.println("-------------------------------------------------------------------------------------------");
				System.out.printf("\nidEmpresa\tidPedido\tidCliente\tValor_Total\t\tData_Emissao\n");
				
			} else {
				System.out.println("Nao ha dados para serem listados.");
				return;
			}
						
			tabela.beforeFirst();
			String sPreco = "";
			
			while (tabela.next()) {  
				
				sPreco = Utils.doubleToString(tabela.getDouble("valorTotal"));
				
				System.out.printf("%d \t\t %d \t\t %d \t\t %s \t\t %s \n", 
						tabela.getInt("idEmpresa"),
						tabela.getInt("idPedido"),
						tabela.getInt("idCliente"),
						sPreco,
						tabela.getString("dataEmissao")
						);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}

	
	//METODO PARA APAGAR TODOS OS ITENS DE UM PEDIDO DO BD PELO IDPEDIDO
	public void apagarPedido(int idpedido,Conexao con) {
		
		PedidoItemDAO itens = new PedidoItemDAO(con);
		itens.apagarItensPedido(idpedido);
		
		//Montando a SQL
		String sql = "delete from marketplace.pedido";
		sql += " where idpedido = " + idpedido;
		//Enviando o SQL
		conexao.query(sql);		
				
	}
	
	//METODO PARA ACHAR O ID DE UM PEDIDO PELA DATA DE EMISSAO
	public int acharPedidoData (Timestamp dataEmissao) {
		
		//Criando as variaveis
		int idPedido = 0;
		ResultSet tabela;
		
		//Montando a SQL
		String sql = "select idPedido from marketplace.pedido";
		sql += " where dataEmissao = '" + dataEmissao +"'";
		
		tabela = conexao.query(sql);
				
		try {
			if (tabela.next()) {
				idPedido = tabela.getInt("idPedido");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	
		return idPedido;
	}
	
	
	//METODO PARA ACHAR O ID DE UM PEDIDO PELA DATA DE EMISSAO
	public Pedido acharPedidoID (int idPedido) {
		
		//Criando as variaveis
		ResultSet tabela;
		Pedido pedido = new Pedido();
		
		//Montando a SQL
		String sql = "select * from marketplace.pedido";
		sql += " where idPedido = '" + idPedido +"'";
		
		tabela = conexao.query(sql);
				
		try {
			if (tabela.next()) {
				
				pedido.setIdPedido(tabela.getInt("idPedido"));
				pedido.setIdCliente(tabela.getInt("idCliente"));
				pedido.setIdEmpresa(tabela.getInt("idEmpresa"));
				pedido.setDataEmissao(tabela.getTimestamp("dataEmissao"));
				pedido.setValorTotal(tabela.getDouble("valorTotal"));
									
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	
		return pedido;
	}
	

	
	
}
