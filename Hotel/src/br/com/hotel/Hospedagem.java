package br.com.hotel;
import java.util.ArrayList;
import java.util.Date;

public class Hospedagem {
	private int codigo;
	private Date dataEntrada;
	private Date dataSaida;
	private Hospede hospede;
	private Aposento aposento;
	private Conta conta;
	
	public static boolean checagemDeCodigo(int codigo, ArrayList <Hospedagem> hospedagens) {
		for(int i = 0; i< hospedagens.size(); i++) {
			if(codigo == hospedagens.get(i).getCodigo()) {
				return false;
			}
		}
		return true;
			
	}
	public Hospedagem(int codigo, Date dataEntrada, Date dataSaida, Hospede hospede, Aposento aposento, Conta conta) {
		this.codigo = codigo;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.hospede = hospede;
		this.aposento = aposento;
		this.conta = conta;
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Aposento getAposento() {
		return aposento;
	}
	public void setAposento(Aposento aposento) {
		this.aposento = aposento;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
}
