package br.com.hotel;
import java.util.Date;

public class ServicoDeQuarto {
	private Date data;
	private Hospedagem hospedagem;
	private Camareiro camareiro;
	private boolean realizado;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	public Camareiro getCamareiro() {
		return camareiro;
	}
	public void setCamareiro(Camareiro camareiro) {
		this.camareiro = camareiro;
	}
	public boolean isRealizado() {
		return realizado;
	}
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	/**
	 * Os parametros dos tipos Hospedagem e Camareiro indicam relacao de DEPENDENCIA entre
	 * ServicoDeQuarto -> Hospedagem & ServicoDeQuarto -> Camareiro.
	 */
	
	public void realizarServicoQuarto(Hospedagem hospedagem, Camareiro camareiro) {
		
	}
	public void agendarServicoQuarto(Hospedagem hospedagem, Camareiro camareiro) {
		
	}
	
	
}
