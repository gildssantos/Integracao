package br.com.caelum.estoque.rmi;


import java.io.Serializable;

public class ItemEstoque implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4159291848117153862L;
	
	private transient String codigo;
	private Integer quantidade;
	public String getCodigo() {
		return codigo;
		
		
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public ItemEstoque(String codigo, Integer quantidade) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
	}
	
	

}
