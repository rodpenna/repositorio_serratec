package dao.br.com.serratec;


//IMPORTACAO DE 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import classes.br.com.serratec.*;
import conexao.br.com.serratec.*;
import utils.br.com.serratec.Utils;


public class ProdutoDAO {

	//DECLARACAO DE VARIAVEIS
	private Conexao conexao;
	private PreparedStatement pInclusao;
	private PreparedStatement pAlteracao;
	
	public ProdutoDAO(Conexao conexao) {
		this.conexao = conexao;
		
		prepararSqlInclusao();
		prepararSqlAlteracao();
	}
	
	private void prepararSqlInclusao() {
		String sql = "insert into marketplace.produto";
		sql += " (nomeProduto, descricaoProduto, dataFabricacao, qntEstoque, valorUnitario, idCategoria )";
		sql += " values ";
		sql += " ( ? , ?, ?, ?, ? , ?)";
		
		try {
			pInclusao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

		
	private void prepararSqlAlteracao() {
		String sql = "UPDATE marketplace.produto set";
		sql += " nomeProduto = ?,";
		sql += " descricaoProduto = ?,";
		sql += " dataFabricacao = ?,";
		sql += " qntEstoque = ?,";
		sql += " valorUnitario = ?,";
		sql += " idCategoria = ?";
		sql += " where idProduto = ?";
				
		try {
			pAlteracao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	
	
	//METODO PARA VERIFICAR SE UM PRODUTO JA EXISTE PELO PRODUTO
	private boolean existeProduto(Produto produto , int idProduto , String nome) {
		ResultSet tabela;
		boolean retorno;
		String sql ="";
		
		if (produto == null && nome == null ) {
			sql = "select idProduto from marketplace.produto where idProduto = '" + idProduto +"'";
		} 
		if (nome == null && idProduto ==0){
			sql = "select idProduto from marketplace.produto where idProduto = '" + produto.getIdProduto() +"'";
		}
		if (produto == null && idProduto ==0){
			sql = "select nomeProduto from marketplace.produto where nomeProduto = '" + nome +"'";
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


	
	//METODO PARA INCLUIR PRODUTO
	public int incluirProduto(Produto produto) {
		//Verificando se ja existe o produto que deseja incluir
		if (!existeProduto(produto,0,null)) {
			try {
				
				//Preenchendo o objeto pInclusao com os dados do produto
				pInclusao.setString(1, produto.getNomeProduto());
				pInclusao.setString(2, produto.getDescricaoProduto());
				pInclusao.setTimestamp(3, produto.getDataFabProduto());
				pInclusao.setInt(4, produto.getQntProduto());
				pInclusao.setDouble(5, produto.getValorUnitProduto());
				pInclusao.setInt(6, produto.getIdCategoria());
				
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
	
	//METODO PARA ALTERAR PRODUTO
	public int alterarProduto(Produto produto) {
		
		if (existeProduto(null,produto.getIdProduto(),null)) {
			try {		
				//Preenchendo o objeto pInclusao com os dados do produto
				pAlteracao.setString(1, produto.getNomeProduto());;
				pAlteracao.setString(2, produto.getDescricaoProduto());
				pAlteracao.setTimestamp(3, produto.getDataFabProduto());
				pAlteracao.setInt(4, produto.getQntProduto());
				pAlteracao.setDouble(5, produto.getValorUnitProduto());
				pAlteracao.setInt(6, produto.getIdCategoria());
				pAlteracao.setInt(7, produto.getIdProduto());
				
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
	
	//METODO PARA APAGAR UM PRODUTO DO BD
	public void apagarProduto(Produto produto , int idProduto) {
		
		String sql = "";
		
		if (produto == null) {
			
			sql = "delete from marketplace.produto";
			sql += " where idproduto = " + idProduto;
		} else {
			
			sql = "delete from marketplace.produto";
			sql += " where nomeProduto = " + produto.getNomeProduto();
		}
		
		conexao.query(sql);		
	}

	//METODO PARA SELECIONAR PRODUTO
	public Produto localizarProduto(String nome , int idProduto ) {
			
			Produto produto = new Produto();
			ResultSet tabela;
			String sql="";
			
			//Montando a SQL
			if (nome != null){
				if (existeProduto(null,0,nome)) {
					sql = "select * from marketplace.produto where nomeProduto = '" + nome+"'";
				}
				else {
					System.out.println("PRODUTO NAO CADASTRADO");
				}
				
			}
			else {
				if (existeProduto(null,idProduto,null)) {
					sql = "select * from marketplace.produto where idProduto = " + idProduto;
				}else {
					System.out.println("PRODUTO NAO CADASTRADO");
				}
			}
			
			tabela = conexao.query(sql);
			
			//Preenchendo o objeto produto com os dados obtidos
			try {
				if (tabela.next()) {
					//Preenchendo o objeto produto com os dados obtidos do BD
					produto.setNomeProduto(tabela.getString("nomeProduto"));
					produto.setDescricaoProduto(tabela.getString("descricaoProduto"));
					produto.setDataFabProduto(tabela.getTimestamp("dataFabricacao"));
					produto.setQntProduto(tabela.getInt("qntEstoque"));
					produto.setValorUnitProduto(tabela.getDouble("valorUnitario"));
					produto.setIdCategoria(tabela.getInt("idCategoria"));
					produto.setIdProduto(tabela.getInt("idProduto"));
					
				}
				tabela.close();
			} catch  (Exception e) {
				System.err.println(e);
				e.printStackTrace();
			}
			//Retorno do produto
			return produto;
		}


	//METODO PARA LISTAR OS PRODUTOS
	public void listarProdutos() {
		
		ResultSet tabela;
		
		//Montagem do SQL
		String sql = "select * ";
		sql += " from marketplace.produto p";
		sql += " left join marketplace.categoria c on c.idcategoria = p.idcategoria";	
		sql += " order by p.idproduto";
				
		tabela = conexao.query(sql);		
		
		
		try {
			//Montagem do Cabecalho
			if (tabela.next()) {
				System.out.printf("idProduto\tNomeProduto\t\t\tDescricao\t\tDataFabricacao\tEstoque\tValorUnitario\tCategoria\n");
				
			} else {
				System.out.println("NAO HA DADOS PARA SEREM LISTADOS.");
				return;
			}
						
			tabela.beforeFirst();
			
			while (tabela.next()) {  
				
				Timestamp time = tabela.getTimestamp("dataFabricacao");
				
				String sData = time.toString();
				
				System.out.printf("%d \t%s \t\t\t%s \t\t%s \t%d \t%s \t%d \n", 
						tabela.getInt("idproduto"),
						tabela.getString("nomeProduto"),
						tabela.getString("descricaoProduto"),
						sData,
						tabela.getInt("qntEstoque"),
						Utils.doubleToString(tabela.getDouble("valorUnitario")),
						tabela.getInt("idCategoria")
						);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	
	
}
