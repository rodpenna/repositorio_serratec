package classes.br.com.serratec;

public class Categoria {
	private int idcategoria;
	private String nomeCategoria;
	private String descricaoCategoria;
	
	public Categoria() {
		
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	@Override
	public String toString() {
		return 	"Dados Categoria : "+
				"\nIdcategoria = " + getIdcategoria() + 
				"\nNomeCategoria = " + getNomeCategoria()+ 
				"\nDescricao Categoria = " + getDescricaoCategoria() ;
	}
	

	
	
	
	
}
