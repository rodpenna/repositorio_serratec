package dao.br.com.serratec;

//IMPORTACAO DE BIBLIOTECAS E CLASSES
import conexao.br.com.serratec.*;
import classes.br.com.serratec.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class EmpresaDAO {
	
	//DECLARACAO DE VARIAVEIS
	private Conexao conexao;
	private PreparedStatement pInclusao;
	private PreparedStatement pAlteracao;
	
	//CONSTRUTOR
	public EmpresaDAO(Conexao conexao) {
		this.conexao = conexao;
				
		prepararSqlInclusao();
		prepararSqlAlteracao();
		
	}
		
	private void prepararSqlInclusao() {
		String sql = "insert into marketplace.empresa";
		sql += " (cnpj, razaoSocial , endereco , nrEndereco , telefone , complemento , bairro , cidade , cep)";
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
		String sql = "update marketplace.empresa set";
		sql += " cnpj = ?,";
		sql += " razaoSocial = ?,";
		sql += " endereco = ?,";
		sql += " nrEndereco = ?,";
		sql += " telefone = ?,";
		sql += " complemento = ?,";
		sql += " bairro = ?,";
		sql += " cidade = ?,";
		sql += " cep = ?";
		sql += " where idEmpresa = ?";
				
		try {
			pAlteracao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	
	
	//METODO PARA VERIFICAR SE UM EMPRESA JA EXISTE PELO EMPRESA
	private boolean existeEmpresa(Empresa empresa , int idEmpresa) {
		ResultSet tabela;
		boolean retorno;
		String sql = "";
		
		
		if (empresa==null) {
			sql = "select idEmpresa from marketplace.empresa where idEmpresa = '" + idEmpresa +"'";
		}
		else {
			sql = "select cnpj from marketplace.empresa where cnpj = '" + empresa.getCnpj() +"'";
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

		
	//METODO INCLUIR EMPRESA NO DATABASE
	public int incluirEmpresa(Empresa empresa) {
		//Verificando se ja existe o produto que deseja incluir
		if (!existeEmpresa(empresa,0)) {
			try {
				//Preenchendo o objeto pInclusao com os dados do produto
				pInclusao.setString(1, empresa.getCnpj());
				pInclusao.setString(2, empresa.getRazaoSocial());
				pInclusao.setString(3, empresa.getEndereco());
				pInclusao.setString(4, empresa.getNrEndereco());
				pInclusao.setString(5, empresa.getTelefone());
				pInclusao.setString(6, empresa.getComplemento());
				pInclusao.setString(7, empresa.getBairro());
				pInclusao.setString(8, empresa.getCidade());
				pInclusao.setString(9, empresa.getCep());
					
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

	//METODO ALTERANDO EMPRESA
	public int alterarEmpresa(Empresa empresa) {
		
		if (existeEmpresa(null,empresa.getIdEmpresa())) {
			try {		

				//Preenchendo o objeto pInclusao com os dados do produto
				pAlteracao.setString(1, empresa.getCnpj());
				pAlteracao.setString(2, empresa.getRazaoSocial());
				pAlteracao.setString(3, empresa.getEndereco());
				pAlteracao.setString(4, empresa.getNrEndereco());
				pAlteracao.setString(5, empresa.getTelefone());
				pAlteracao.setString(6, empresa.getComplemento());
				pAlteracao.setString(7, empresa.getBairro());
				pAlteracao.setString(8, empresa.getCidade());
				pAlteracao.setString(9, empresa.getCep());
				pAlteracao.setInt(10, empresa.getIdEmpresa());
				
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

	
	//METODO PARA APAGAR UM EMPRESA
	public void apagarEmpresa(Empresa empresa , int idEmpresa) {
		
		String sql = "";
				
		if (empresa == null) {
			
			if (existeEmpresa(null,idEmpresa)) {
				//MONTAGEM DO SQL
				sql = "delete from marketplace.empresa";
				sql += " where idEmpresa = " + idEmpresa;	
			}

		} else {
			if (existeEmpresa(empresa,0)) {
				//MONTAGEM DO SQL
				sql = "delete from marketplace.empresa";
				sql += " where idEmpresa = " + empresa.getIdEmpresa();	
			}
		}
		conexao.query(sql);	
		System.out.println("EMPRESA APAGADA COM SUCESSO");
	}

	
	//METODO PARA LOCALIZAR EMPRESA ATRAVES DO NOME OU DO IDEMPRESA
	public Empresa localizarEmpresa(String nomeEmpresa, int idEmpresa) {
		//DECLARACAO DE VARIAVEIS
		Empresa empresa = new Empresa();
		ResultSet tabela;
		String sql;
		
		//MONTAGEM DO SQL
		//CASO TENHA O NOME PROCURA DIRETO POR ELE, SENAO PROCURA PELO ID
		if (nomeEmpresa == null) {
			//PROCURANDO PELO ID
			sql = "select * from marketplace.empresa where idempresa = " + idEmpresa;
		} else {
			//PROCURANDO PELO NOME
			sql = "select * from marketplace.empresa where razaoSocial = '" + nomeEmpresa + "'";
		}
		
		//ARMAZENANDO OS DADOS RECEBIDOS
		tabela = conexao.query(sql);
		
		//PREECHIMENTO DO OBJETO CLIENTE COM OS DADOS OBTIDOS
		try {
			if (tabela.next()) {	
				
				empresa.setIdEmpresa(tabela.getInt("idEmpresa"));
				empresa.setCnpj(tabela.getString("cnpj"));
				empresa.setRazaoSocial(tabela.getString("razaoSocial"));
				empresa.setEndereco(tabela.getString("endereco"));
				empresa.setNrEndereco(tabela.getString("nrEndereco"));
				empresa.setTelefone(tabela.getString("telefone"));
				empresa.setComplemento(tabela.getString("complemento"));
				empresa.setBairro(tabela.getString("bairro"));
				empresa.setCidade(tabela.getString("cidade"));
				empresa.setCep(tabela.getString("cep"));
								
			} else {
				
				System.out.println("\nEMPRESA NAO ENCONTRADA.");
			}
		} catch  (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		//RETORNO DO OBJETO
		return empresa;
	}

		
	//METODO PARA LISTAR EMPRESA
	public void listarEmpresas() {
		ResultSet tabela;		
		
		//MONTAGEM DO SQL
		String sql;
		sql = "select * from marketplace.empresa order by idEmpresa";
		
		tabela = conexao.query(sql);
		
		//Preenchimento do objeto
		try {			
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("QUANTIDADE DE EMPRESAS: " +rowCount);			
			
			if (rowCount > 0) {
				System.out.println("\n\n");
				System.out.printf("IdEmpresa\tRazaoSocial\t\tCNPJ\t\tTelefone\t\tEndereco\t\tNrEndereco\t\tCidade\t\t\tCEP\n");
			} else {
				System.out.println("\nNao possui dados.");
				return;
			}
			
			tabela.beforeFirst();
			
			while (tabela.next()) {
				
				System.out.printf("%d\t\t%s\t\t\t%s\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s\n",
					tabela.getInt("idEmpresa"),
					tabela.getString("razaoSocial"),
					tabela.getString("cnpj"),
					tabela.getString("telefone"),
					tabela.getString("endereco"),
					tabela.getString("nrendereco"),
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
