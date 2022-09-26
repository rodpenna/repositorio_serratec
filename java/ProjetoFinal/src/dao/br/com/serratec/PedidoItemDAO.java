package dao.br.com.serratec;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import classes.br.com.serratec.*;
import conexao.br.com.serratec.*;
import utils.br.com.serratec.Utils;

public class PedidoItemDAO {

	//DECLARACAO DE VARIAVEIS
	private Conexao conexao;
	private PreparedStatement pInclusao;
	
	
	public PedidoItemDAO(Conexao conexao) {
		this.conexao = conexao;
		
		prepararSqlInclusao();
	}

	
	//METODO PARA DEIXAR O COMANDO SQL PRONTO
	private void prepararSqlInclusao() {
		String sql = "insert into marketplace.pedidoItem";
		sql += " (idPedido, idProduto, precoUnit, qntPedido, valorDesc, percDesc , valorParcial)";
		sql += " values ";
		sql += " ( ? , ?, ?, ?, ? , ? , ?)";
		
		try {
			pInclusao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
			
	//METODO PARA VERIFICAR SE UM PRODUTO JA EXISTE PELO ID_PEDIDO_ITEM
	public boolean existePedidoItem(PedidoItem pedidoItem , int idPedido , int idPedidoItem) {
		
		ResultSet tabela;
		boolean retorno;
		boolean teste = false;
		String sql ="";
		
		if (pedidoItem == null && idPedido == 0) {
			sql = "select idPedidoItem from marketplace.pedidoItem where idPedidoItem = '" + idPedidoItem +"'";
		} 
		
		
		if(idPedido==0 && idPedidoItem ==0) {
			sql = "select * from marketplace.pedidoItem where idPedido = '" + pedidoItem.getIdPedido() +"'";
		}
		
		if (idPedidoItem==0 && pedidoItem == null) {
			
			sql = "select idPedido from marketplace.pedidoItem where idPedido = '" + idPedido +"'";
		}
	
		tabela = conexao.query(sql);
		
		
		if (pedidoItem!=null) {
			try {
				
				while (tabela.next()) {
				
					if (tabela.getInt("idPedido")==pedidoItem.getIdPedido() && 
						tabela.getInt("idProduto")==pedidoItem.getIdProduto() &&
						tabela.getInt("qntPedido")==pedidoItem.getQntPedido()) {
						tabela.close();
						teste =  true;
					}
					else {
						teste =  false;
					}
				}
				
				retorno = teste;
			} catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
				retorno =  true;
			}
		}else {
			
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

		}
		return retorno;
	}
	
	
	//METODO PARA INCLUIR PRODUTO
	public int incluirPedidoItem(PedidoItem pedidoItem) {
	//Verificando se ja existe o produto que deseja incluir
		if (!existePedidoItem(pedidoItem,0,0)) {
	
			try {
				//Preenchendo o objeto pInclusao com os dados do produto
				pInclusao.setInt(1, pedidoItem.getIdPedido());
				pInclusao.setInt(2, pedidoItem.getIdProduto());
				pInclusao.setDouble(3, pedidoItem.getPrecoUnit());
				pInclusao.setInt(4, pedidoItem.getQntPedido());
				pInclusao.setDouble(5, pedidoItem.getValorDesc());
				pInclusao.setDouble(6, pedidoItem.getPercDesc());
				pInclusao.setDouble(7, pedidoItem.getValorParcial());
				
				//Executando a inclusao do produto no database
				return pInclusao.executeUpdate();
				
			} catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
				return 0;
			}
		}
		else {
		System.out.println("PEDIDO JA REGISTRADO");
		return 0;
		}
	}
		
	
	//METODO PARA APAGAR UM ITEM DE UM PEDIDOITEM DO BD
	public void apagarPedidoItem(int idPedidoItem) {
		//Montando a SQL
		String sql = "delete from marketplace.pedidoItem";
		sql += " where idPedidoItem = " + idPedidoItem;
		//Enviando o SQL
		conexao.query(sql);		
	}
	
	
	//METODO PARA APAGAR TODOS OS ITENS DE UM PEDIDO DO BD
	public void apagarItensPedido(int idPedido) {
		//Montando a SQL
		String sql = "delete from marketplace.pedidoItem";
		sql += " where idPedido = " + idPedido;
		//Enviando o SQL
		conexao.query(sql);		
	}
	
	
	//METODO PARA LISTAR TODOS OS ITENS DE TODOS OS PEDIDOS 
	public void listarPedidoItem() {
			
		ResultSet tabela;
		
		//Montagem do SQL
		
		String sql = "select ";
		sql += " 	p.idPedidoItem, ";
		sql += " 	p.idPedido, ";
		sql += " 	p.idProduto, ";
		sql += " 	p.precoUnit, ";
		sql += " 	p.qntPedido, ";
		sql += " 	p.valorDesc, ";
		sql += " 	p.percDesc, ";
		sql += " 	p.valorParcial, ";
		
		sql += " from marketplace.pedidoItem p";
		sql += " order by p.idPedido";
				
		tabela = conexao.query(sql);		
		
		
		try {
			//Montagem do Cabecalho
			if (tabela.next()) {
				System.out.println("-------------------------------------------------------------------------------------------");
				System.out.println("idPedidoItem\tidPedido\tidProduto\tPrecoUnit\t\tQntPedido\tValorDesc\t\tPercDesc\tValorParcial");
				
			} else {
				System.out.println("Nao ha dados para serem listados.");
				return;
			}
						
			tabela.beforeFirst();
			String sPreco = "";
			String sValorDesc = "";
			String sPercDesc = "";
			String svalorParcial ="";
			
			while (tabela.next()) {  
				
				sPreco = Utils.doubleToString(tabela.getDouble("precoUnit"));
				sValorDesc = Utils.doubleToString(tabela.getDouble("valorDesc"));
				sPercDesc = Utils.doubleToString(tabela.getDouble("percDesc"));
				svalorParcial = Utils.doubleToString(tabela.getDouble("valorParcial"));
				
			
				System.out.printf("	%d \t %d \t %d \t %s \t\t	%d \t %s \t\t %s \t %s\n", 
						tabela.getInt("idPedidoitem"),
						tabela.getInt("idPedido"),
						tabela.getInt("idProduto"),
						sPreco,
						tabela.getInt("qntPedido"),
						sValorDesc,
						sPercDesc,
						svalorParcial
						);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	
	//METODO PARA LISTAR TODOS OS ITENS DE UM PEDIDO ESPECIFICO 
	public void listarPedido(Pedido pedido, int idPedido , int idProduto) {
			
		ResultSet tabela;
		String sql = "";
		
		if (pedido==null && idProduto==0) {
			sql = "select * ";			
			sql += " from marketplace.pedidoItem p";
			sql += " where idPedido = "+idPedido;
			sql += " order by p.idPedidoItem";
		}
		
		if (idProduto == 0 && idPedido ==0) {
			
			//Montagem do SQL
			sql = "select * ";
			sql += " from marketplace.pedidoItem p";
			sql += " where idPedido = "+pedido.getIdPedido();
			sql += " order by p.idPedidoItem";
		}
						
		if (pedido==null && idPedido==0) {
			
			//Montagem do SQL
			sql = "select * ";
			sql += " from marketplace.pedidoItem p";
			sql += " where idProduto = "+idProduto;
			sql += " order by p.idPedidoItem";		
		}
			
		
		tabela = conexao.query(sql);
		
		try {
			//Montagem do Cabecalho
			if (tabela.next()) {
				System.out.println("-------------------------------------------------------------------------------------------");
				System.out.println("idPedidoItem\tidPedido\tidProduto\tPrecoUnit\t\tQntPedido\tValorDesc\t\tPercDesc\tValorParcial");
				
			} else {
				System.out.println("Nao ha dados para serem listados.");
				return;
			}
						
			tabela.beforeFirst();
			String sPreco = "";
			String sValorDesc = "";
			String sPercDesc = "";
			String svalorParcial ="";
			
			while (tabela.next()) {  
				
				sPreco = Utils.doubleToString(tabela.getDouble("precoUnit"));
				sValorDesc = Utils.doubleToString(tabela.getDouble("valorDesc"));
				sPercDesc = Utils.doubleToString(tabela.getDouble("percDesc"));
				svalorParcial = Utils.doubleToString(tabela.getDouble("valorParcial"));
				
			
				System.out.printf("	%d \t %d \t %d \t %s \t\t	%d \t %s \t\t %s \t %s\n", 
						tabela.getInt("idPedidoitem"),
						tabela.getInt("idPedido"),
						tabela.getInt("idProduto"),
						sPreco,
						tabela.getInt("qntPedido"),
						sValorDesc,
						sPercDesc,
						svalorParcial
						);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
		
	

		
	
}
