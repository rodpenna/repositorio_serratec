package conexao.br.com.serratec;

//Importacao de bibliotecas e classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Classe utilizada para realizar as conexoes entre o banco de dados e o java
public class Conexao {
	//DECLARACAO DE VARIAVEIS
	private String local;
	private String user;
	private String senha;
	private String str_conexao;
	private String driverjdbc;
	//Tipo de variaveis proprias do SQL
	private Connection c;
	private Statement statment;
	
	//CONSTRUTOR
	//Exemplo de preenchimento
	//				"PostgreSql", 	"localhost",	"5433",			"nomeBD", 		"postgres",		 "senhaBD"
	public Conexao(	String bd,	 	String local,	String porta,	String banco,	String user,	String senha) {
		if (bd.equals("PostgreSql")){
			setStr_conexao("jdbc:postgresql://"+ local +":" + porta +"/"+ banco);
  			setLocal(local);
  			setSenha(senha);
  			setUser(user);
  			setDriverjdbc("org.postgresql.Driver");
		}
	}
	
	//Metodo para configurar o usuario e senha (setUser e setSenha)
	public void configUser(String user, String senha) {
		setUser(user);
		setSenha(senha);
	}
	
	//Metodo para configuracao do local (setLocal)
	public void configLocal(String banco) {
		setLocal(banco);
	}
	
	//Metodo para realizar a conexao com o BD
	public void connect(){
		try {
			Class.forName(getDriverjdbc());
			setC(DriverManager.getConnection(getStr_conexao(), getUser(), getSenha()));
			//setStatment(getC().createStatement());
			setStatment(getC().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE));
		}catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	//Metodo para desconctar
	public void disconnect(){
		try {
			getC().close();
		}catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}
	
	public ResultSet query(String query){
		try {
			return getStatment().executeQuery(query);
		}catch (SQLException ex) {
			if (!ex.getLocalizedMessage().contentEquals("Nenhum resultado foi retornado pela consulta.")) {
				//System.out.println(ex.getMessage());
				//System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
			return null;
		}
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Connection getC() {
		return c;
	}

	public void setC(Connection c) {
		this.c = c;
	}

	public Statement getStatment() {
		return statment;
	}

	public void setStatment(Statement statment) {
		this.statment = statment;
	}

	public String getStr_conexao() {
		return str_conexao;
	}

	public void setStr_conexao(String str_conexao) {
		this.str_conexao = str_conexao;
	}

	public String getDriverjdbc() {
		return driverjdbc;
	}

	public void setDriverjdbc(String driverjdbc) {
		this.driverjdbc = driverjdbc;
	}
}
