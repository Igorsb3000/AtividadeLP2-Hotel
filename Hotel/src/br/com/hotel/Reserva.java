
package br.com.hotel;
import java.util.ArrayList;
import java.util.Date;

import br.com.clientes.Conta;
import br.com.clientes.Hospede;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Reserva { //antiga class Hospedagem
	private int codigo;
	private Date dataEntrada;
	private Date dataSaida;
	private ArrayList<Hospede> hospedes;
	private Hospede responsavel;
	private Aposento aposento;
	private Conta conta;
	private int quantidadeHospedes;
	
	//Checar pra saber se ja existe o codigo, se existir retorna false
	/**
	 * 
	 * @param codigo
	 * @param reservas
	 * @return
	 */
	public static boolean checagemDeCodigo(int codigo, ArrayList <Reserva> reservas) {
		for(int i = 0; i < reservas.size(); i++) {
			if(codigo == reservas.get(i).getCodigo()) {
				return false;
			}
		}
		return true;
	}
	//Checar se o codigo pertence a algum hospede
	/**
	 * 
	 * @param codigo
	 * @param reservas
	 * @return
	 */
	public static boolean checarExistencia(int codigo, ArrayList <Reserva> reservas) {
		for(int i = 0; i < reservas.size(); i++) {
			//for(int j=0; j < reservas.get(i).getQuantidadeHospedes(); j++) {
				if(codigo == reservas.get(i).getHospedes().get(i).getCodigo()) {
					//if(reservas.get(i).getHospedes().get(i).isResponsavel()) {
						return true;
					//}
						//getResponsavel().getCodigo()) {
					
				}
			//}
			
		}
		return false;
	}
	/**
	 * 
	 * @param codigo
	 * @param dataEntrada
	 * @param dataSaida
	 * @param hospede
	 * @param aposento
	 * @param conta
	 */
	public Reserva(int codigo, Date dataEntrada, Date dataSaida, ArrayList<Hospede> hospedes, Aposento aposento, Conta conta, int quantidadeHospedes) {
		this.codigo = codigo;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.hospedes = hospedes;
		this.aposento = aposento;
		this.conta = conta;
		this.quantidadeHospedes = quantidadeHospedes;
		
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
	public ArrayList<Hospede> getHospedes() {
		return hospedes;
	}	
	public void setHospedes(ArrayList<Hospede> hospedes) {
		this.hospedes = hospedes;
	}
	public void setHospede(Hospede hospede) {
		this.hospedes.add(hospede);
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
	
	public Hospede getResponsavel(ArrayList<Hospede> hospedes) {
		for(int i=0; i < hospedes.size(); i++) {
			if(hospedes.get(i).isResponsavel() == true) {
				setResponsavel(hospedes.get(i));
			}
		}
		return responsavel;
	}
	public Hospede getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Hospede responsavel) {
		this.responsavel = responsavel;
	}
	
	public int getQuantidadeHospedes() {
		return hospedes.size();
	}
}
