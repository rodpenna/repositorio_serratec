package classes.br.com.serratec;

import java.sql.Timestamp;

import utils.br.com.serratec.Utils;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private Timestamp dataFabProduto;
	private int qntProduto;
	private Double valorUnitProduto;
		
	private int idCategoria;
	
	
	public Produto() {

	}


	public int getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public String getDescricaoProduto() {
		return descricaoProduto;
	}


	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}


	public Timestamp getDataFabProduto() {
		return dataFabProduto;
	}


	public void setDataFabProduto(Timestamp dataFabProduto) {
		this.dataFabProduto = dataFabProduto;
	}


	public int getQntProduto() {
		return qntProduto;
	}


	public void setQntProduto(int qntProduto) {
		this.qntProduto = qntProduto;
	}


	public Double getValorUnitProduto() {
		return valorUnitProduto;
	}


	public void setValorUnitProduto(Double valorUnitProduto) {
		this.valorUnitProduto = valorUnitProduto;
	}


	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idSubcategoria) {
		this.idCategoria = idSubcategoria;
	}


	@Override
	public String toString() {
		return "Dados do Produto :"+
				"\n\tid Produto = "+this.getIdProduto() + 
				"\n\tNome Produto = "+this.getNomeProduto() +
				"\n\tDescricao Produto = "+this.getDescricaoProduto() + 
				"\n\tData Fabricacao = "+this.getDataFabProduto()+ 
				"\n\tEstoque Produto = "+this.getQntProduto()+ 
				"\n\tPreco Produto = "+Utils.doubleToString(this.getValorUnitProduto())+ 
				"\n\tidCategoria = " +this.getIdCategoria();
	}

	
	
	
	
	
	
	
	
	
}