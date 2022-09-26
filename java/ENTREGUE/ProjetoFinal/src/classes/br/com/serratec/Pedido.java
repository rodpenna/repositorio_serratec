package classes.br.com.serratec;

import java.sql.Timestamp;

import utils.br.com.serratec.Utils;

public class Pedido {

	private int idPedido;
	private int idCliente;
	private Double valorTotal;
	private Timestamp dataEmissao;
	private int idEmpresa;
	
	public Pedido() {
		
	}

	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCLiente) {
		this.idCliente = idCLiente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Timestamp getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Timestamp dataEmissao) {
		this.dataEmissao = dataEmissao;
	}


	@Override
	public String toString() {
		return 	"Dados do Pedido "+
				"\n\tIdPedido = " + this.getIdPedido() +
				"\n\tIdCliente = " + this.getIdCliente() + 
				"\n\tValor Total = "+ Utils.doubleToString(this.getValorTotal()) + 
				"\n\tData Emissao = " + this.getDataEmissao();
	}


	public int getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	

	
		
	
	
	
	
}
