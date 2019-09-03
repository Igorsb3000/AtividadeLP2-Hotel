package br.com.hotel;

import java.util.ArrayList;

import br.com.clientes.Hospede;

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
	private int capacidade;
	private int ocupacao = 0;
	
	public Aposento() {
		
	}
	/**
	 * 
	 * @param codigo
	 * @param valor
	 * @param descricao
	 * @param numero
	 * @param capacidade
	 */
	public Aposento(int codigo, double valor, String descricao, int numero, int capacidade) {
		this.codigo = codigo;
		this.valor = valor;
		this.descricao = descricao;
		this.numero = numero;
		this.capacidade = capacidade;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	public double getValor() {
		return this.valor;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public int getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao() {
		this.ocupacao += 1;
	}
	/**
	 * 
	 * @param hospedes
	 * @return
	 */
	public boolean checkCapacidade(ArrayList<Hospede> hospedes) {
		if(hospedes.size() < getCapacidade()) {
			return true;
		}
		return false;
	}

}
