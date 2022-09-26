package classes.br.com.serratec;

public class Empresa {

	private int idEmpresa;
	private String cnpj;
	private String razaoSocial;
	private String endereco;
	private String nrEndereco;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private String telefone;
	
	public Empresa() {
		
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNrEndereco() {
		return nrEndereco;
	}

	public void setNrEndereco(String nrEndereco) {
		this.nrEndereco = nrEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	@Override
	public String toString() {
		return 	"Dados da Empresa : "+
				"\n\tIdEmpresa = "+ getIdEmpresa() +
				"\n\tCnpj = "+ getCnpj() + 
				"\n\tRazao Social = "+ getRazaoSocial() + 
				"\n\tEndereco = "+ getEndereco() + 
				"\n\tNrEndereco = "+ getNrEndereco()+
				"\n\tComplemento = "+ getComplemento() + 
				"\n\tBairro = "+ getBairro() + 
				"\n\tCidade = "+ getCidade() + 
				"\n\tCep = " + getCep() + 
				"\n\tTelefone() "+ getTelefone();
	}
	
	
	
	
	
	
	
	
	
	
}
