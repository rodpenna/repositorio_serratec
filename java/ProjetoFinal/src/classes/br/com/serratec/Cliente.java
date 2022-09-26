package classes.br.com.serratec;


//Classe principal de clientes
public class Cliente extends Pessoa{
		
	//DECLARACAO DE VARIAVEL
	private int idCliente;
			
		
	//CONSTRUTOR
	public Cliente () {
			
	}
		
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return 	"Dados Cliente : "+
				"\nidCliente = " + idCliente + 
				"\nNome = " + getNome() + 
				"\nCpf = " + getCpf() + 
				"\nTel = "+ getTel() + 
				"\nEndereco = " + getEndereco() + 
				"\nNrEndereco = " + getNrEndereco()+ 
				"\nComplemento = " + getComplemento() + 
				"\nBairro = " + getBairro() + 
				"\nCidade = "+ getCidade() + 
				"\nCep = " + getCep() ;
	}

		
	
	
	
	
	
	
	
	
	
}
