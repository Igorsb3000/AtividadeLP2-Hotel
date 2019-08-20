package br.com.hotel;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Aposento {
	private int codigo;
	private double valor;
	private String descricao;
	private int numero;
	
	public Aposento(){	
	}
	/**
	 * 
	 * @param codigo
	 * @param valor
	 * @param descricao
	 * @param numero
	 */
	public Aposento(int codigo, double valor, String descricao, int numero) {
		this.codigo = codigo;
		this.valor = valor;
		this.descricao = descricao;
		this.numero = numero;
	}
	
	int getCodigo() {
		return this.codigo;
	}
	double getValor() {
		return this.valor;
	}
	String getDescricao() {
		return this.descricao;
	}
	int getNumero() {
		return this.numero;
	}
	void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	void setValor(double valor) {
		this.valor = valor;
	}
	void setNumero(int numero) {
		this.numero = numero;
	}

}
