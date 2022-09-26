package classes.br.com.serratec;

import utils.br.com.serratec.Utils;

public class PedidoItem {
	
	private int idPedidoItem;
	private int idProduto;
	private int idPedido;
	private Double precoUnit;
	private int qntPedido;
	private Double valorDesc;
	private Double percDesc;
	private Double valorParcial;
	
	
	public PedidoItem() {
		
	}
	
	public Double getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(Double valorParcial) {
		this.valorParcial = valorParcial;
	}

	public int getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(int idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Double getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(Double precoUnit) {
		this.precoUnit = precoUnit;
	}

	public int getQntPedido() {
		return qntPedido;
	}

	public void setQntPedido(int qntPedido) {
		this.qntPedido = qntPedido;
	}

	public Double getValorDesc() {
		return valorDesc;
	}

	public void setValorDesc(Double valorDesc) {
		this.valorDesc = valorDesc;
	}

	public Double getPercDesc() {
		return percDesc;
	}

	public void setPercDesc(Double percDesc) {
		this.percDesc = percDesc;
	}

	@Override
	public String toString() {
		return "Itens do Pedido : "+
				"\nIdPedidoItem = "+this.getIdPedidoItem() + 
				"\nIdProduto = " + this.getIdProduto()+
				"\nIdPedido = " + this.getIdPedido() + 
				"\nPrecoUnit = " +Utils.doubleToString( this.getPrecoUnit()) + 
				"\nQntPedido = "+ this.getQntPedido() + 
				"\nValorDesc = " + Utils.doubleToString(this.getValorDesc()) + 
				"\nPercDesc = " + Utils.doubleToString(this.getPercDesc()) +
				"\nValorParcial = "+ Utils.doubleToString(this.getValorParcial());
	}
	
}
