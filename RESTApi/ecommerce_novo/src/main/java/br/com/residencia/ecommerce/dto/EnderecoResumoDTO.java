package br.com.residencia.ecommerce.dto;


public class EnderecoResumoDTO {
	
	private Integer idEndereco;
	
	private String cep;
	
	private String rua;
	
	private String bairro;
	
	private String cidade;
	
	private String numero;
	
	private String complemento;
	
	private String uf;

	//Relacoes
	private ClienteResumoDTO2 cliente;
	
	
	public ClienteResumoDTO2 getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResumoDTO2 cliente) {
		this.cliente = cliente;
	}

	//Construtores
	public EnderecoResumoDTO() {
		
	}
	
	//Get e Set
	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
