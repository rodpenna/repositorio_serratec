package dao.br.com.serratec;


//IMPORTACAO DE BIBLIOTECAS E CLASSES
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import classes.br.com.serratec.Categoria;
import conexao.br.com.serratec.Conexao;


//CLASSE CATEGORIADAO
public class CategoriaDAO {
		
	//DECLARACAO DE VARIAVEIS
	private Conexao conexao;
	private PreparedStatement pInclusao;
	private PreparedStatement pAlteracao;
		
	//CONSTRUTOR
	public CategoriaDAO (Conexao conexao) {
		this.conexao = conexao;
			
		prepararSqlInclusao();
		prepararSqlAlteracao();
	}
		
	//METODOS AUXILIARES
	//METODO PARA PREPARAR A INCLUSAO
	private void prepararSqlInclusao() {
		String sql = "insert into marketplace.categoria";
		sql += " (nomeCategoria , descricaoCategoria)";
		sql += " values ";
		sql += " (? , ?)";
			
		try {
			pInclusao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
		
	//METODO PARA PREPARAR A ALTERACAO
	private void prepararSqlAlteracao() {
		String sql = "update marketplace.categoria set";
		sql +=  " nomeCategoria = ?,";
		sql +=  " descricaoCategoria = ?";
		sql +=  " where idcategoria = ?";
		
		try {
			pAlteracao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	//METODO PARA VERIFICAR SE EXISTE CATEGORIA PELO ID
	private boolean existeCategoriaID(int idCategoria) {
		ResultSet tabela;
		boolean retorno;
							
		//MONTAGEM DE SQL
		String sql = "select * from marketplace.categoria where idCategoria = '" + idCategoria +"'";
		
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
	
	//METODO PARA VERIFICAR SE EXISTE CATEGORIA PELA CATEGORIA
	private boolean existeCategoria(Categoria categoria) {
		ResultSet tabela;
		boolean retorno;
							
		//MONTAGEM DE SQL
		String sql = "select nomeCategoria from marketplace.categoria where nomeCategoria = '" + categoria.getNomeCategoria() +"'";
		
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

	//METODOS PRINCIPAIS
	//METODO PARA ADICIONAR CATEGORIA NO BANCO DE DADOS
	public int incluirCategoria(Categoria categoria) {
		if (!existeCategoria(categoria)) {
			try {
				
				pInclusao.setString(1, categoria.getNomeCategoria());
				pInclusao.setString(2, categoria.getDescricaoCategoria());
				
				return pInclusao.executeUpdate();
				
			} catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
				return 0;
			}
		} else 
			return 0;
	}
	
	//METODO PARA ALTERAR UMA CATEGORIA NO BANCO DE DADOS
	public int alterarCategoria(Categoria categoria) {
				
		try {		
			pAlteracao.setString(1, categoria.getNomeCategoria());
			pAlteracao.setString(2, categoria.getDescricaoCategoria());
			pAlteracao.setInt(3, categoria.getIdcategoria());
			
			return pAlteracao.executeUpdate();
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return 0;
		}
		
	}
				
	//Metodo para APAGAR categoria
	public void apagarCategoria(int idCategoria) {
		
		String sql = "";
		
		if (existeCategoriaID(idCategoria)) {
			//MONTAGEM DO SQL
			sql = "delete from marketplace.categoria";
			sql += " where idcategoria = " + idCategoria;
			
		}
		else {
			System.out.println("NAO EXISTE ESTA ID CADASTRADA");
		}
						
		//ENVIO PARA A QUERY
		conexao.query(sql);	
		
		System.out.println("CATEGORIA APAGADA COM SUCESSO");
	}
	
	//Metodo para Selecionar uma Categoria
	public Categoria localizarCategoria(int idCategoria , String nomeCategoria) {
		//DECLARACAO DE VARIAVEIS
		Categoria categoria = new Categoria();
		String sql ="";
		ResultSet tabela;
		
		if (nomeCategoria == null) {
			//MONTAGEM DO SQL
			sql = "select * from marketplace.categoria where idcategoria = " + idCategoria;
			
		} else {
			
			sql = "select * from marketplace.categoria where nomeCategoria = "+ nomeCategoria;
		}
						
		//ENVIANDO O QUERY
		tabela = conexao.query(sql);
		
		//PEGANDO OS DADOS RECEBIDOS
		try {
			if (tabela.next()) { 
				//PEGANDO OS DADOS RECEBIDOS E COLOCANDO EM UM OBJETO
				categoria.setIdcategoria(tabela.getInt("idcategoria"));
				categoria.setNomeCategoria(tabela.getString("nomeCategoria"));
				categoria.setDescricaoCategoria(tabela.getString("descricaoCategoria"));
			} else {
				
			}
		
		tabela.close();
			
		} catch  (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		//RETORNANDO OBJETO PREENCHIDO
		return categoria;
	}

	
	//METODO PARA LISTAR OS PRODUTOS
	public void listarCategorias() {
		
		ResultSet tabela;
		
		//Montagem do SQL
		String sql = "select * ";
		sql += " from marketplace.categoria c";	
		sql += " order by c.idCategoria";
				
		tabela = conexao.query(sql);		
		
		
		try {
			//Montagem do Cabecalho
			if (tabela.next()) {
				System.out.printf("idCategoria\tNomeCategoria\t\tDescricao\n");
				
			} else {
				System.out.println("Nao ha dados para serem listados.");
				return;
			}
						
			tabela.beforeFirst();
			
			while (tabela.next()) {  
				
			
				System.out.printf("%d\t\t%s\t\t\t%s\n", 
						tabela.getInt("idCategoria"),
						tabela.getString("nomeCategoria"),
						tabela.getString("descricaoCategoria")
						);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
		
	
	
		
}
