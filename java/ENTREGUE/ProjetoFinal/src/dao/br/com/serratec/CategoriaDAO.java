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
	public boolean existeCategoriaID(int idCategoria) {
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
	
	public boolean existeCategoriaNome(String nomeCategoria) {
		ResultSet tabela;
		boolean retorno;
							
		//MONTAGEM DE SQL
		String sql = "select * from marketplace.categoria where nomecategoria = '" + nomeCategoria +"'";
		
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
				if (nomeCategoria == null) {
					System.out.println("IdCategoria nao localizado.");
				} else
					System.out.println("Categoria '" + nomeCategoria + "' nao localizado.");
				
				//categoria = null;
			}
			
		
		tabela.close();
			
		} catch  (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		//RETORNANDO OBJETO PREENCHIDO
		return categoria;
	}
	
	private boolean existeCategoria(Categoria categoria , int idCategoria , String nome) {
		ResultSet tabela;
		boolean retorno;
		String sql ="";
		
		if (categoria == null && nome == null ) {
			sql = "select idCategoria from marketplace.categoria where idCategoria = '" + idCategoria +"'";
		} 
		if (nome == null && idCategoria ==0){
			sql = "select idCategoria from marketplace.categoria where idCategoria = '" + categoria.getIdcategoria() +"'";
		}
		if (categoria == null && idCategoria ==0){
			sql = "select nomeCategoria from marketplace.categoria where nomeCategoria = '" + nome +"'";
		}
		
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
	
	public Categoria localizarCategorias(String nomeCategoria, int idCategoria) {
		//DECLARACAO DE VARIAVEIS
		Categoria categoria = new Categoria();
		ResultSet tabela;
		String sql ="";
		
		
		if (nomeCategoria != null){
			if (existeCategoria(null,0,nomeCategoria)) {
				sql = "select * from marketplace.categoria where nomecategoria = '" + nomeCategoria+"'";
			}
			else {
				System.out.println("categoria NAO CADASTRADO");
			}
			
		}
		else {
			if (existeCategoria(null,idCategoria,null)) {
				sql = "select * from marketplace.categoria where idCategoria = " + idCategoria;
			}else {
				System.out.println("PRODUTO NAO CADASTRADO");
			}
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
				if (nomeCategoria == null) {
					System.out.println("IdCategoria nao localizado.");
				} else
					System.out.println("Categoria '" + nomeCategoria + "' nao localizado.");
				
				//categoria = null;
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
				
			
				System.out.printf("%d\t\t%-20s\t%s\n", 
						tabela.getInt("idCategoria"),
						tabela.getString("nomeCategoria"),
						tabela.getString("descricaoCategoria")
						);
			}

			System.out.println("\n\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
		
	public boolean contemCategoria() {				
		//MONTAGEM DE SQL
		String sql = "select * from marketplace.categoria";
		
		
		try (ResultSet tabela = conexao.query(sql)){
			if (tabela.next()) {
				//SE A CATEGORIA JA EXISTIR
				tabela.close();
				return true;
			} else return false;	
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		}
	}
	
	public void retornaCategorias() {
		
		ResultSet tabela;
		
		//Montagem do SQL
		String sql = "select * ";
		sql += " from marketplace.categoria c";	
		sql += " order by c.idCategoria";
				
		tabela = conexao.query(sql);		
		
		
		try {
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
			tabela.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}	
}
