package classes.br.com.serratec;


public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	private String tel;
	private String endereco;
	private String nrEndereco;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	

	public Pessoa() {
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
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


	@Override
	public String toString() {
		return "Dados Pessoa : "+
				"\nNome = "+ getNome() +
				"\nCpf = " + getCpf() + 
				"\nTel = " + getTel()+ 
				"\nEndereco = " + getEndereco() + 
				"\nNrEndereco = " + getNrEndereco() + 
				"\nComplemento = "+ getComplemento() + 
				"\nBairro = " + getBairro() + 
				"\nCidade = " + getCidade() + 
				"\nCep = "+ getCep() ;
	}
	

	
	
	
	
	
	
}
	

