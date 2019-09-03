package br.com.clientes;

import java.util.ArrayList;

import br.com.hotel.Reserva;

/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */

public class Hospede {
	private int codigo;
	private String nome;
	private String CPF;
	private String RG;
	private String telefone;
	private boolean responsavel;	

	/**
	 * 
	 * @param codigo
	 * @param nome
	 * @param CPF
	 * @param RG
	 * @param telefone
	 * @param responsavel
	 */
	public Hospede(int codigo, String nome, String CPF, String RG, String telefone, boolean responsavel) {
		this.codigo = codigo;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.telefone = telefone;
		this.responsavel = responsavel;
	}
	
	public static boolean CheckCPF(String CPF, ArrayList<Reserva> reservas) {
		for(int i = 0; i<reservas.size(); i++) {
			for(int j = 0; j < reservas.get(i).getHospedes().size(); j++) {
				if(reservas.get(i).getHospedes().get(j).getCPF().contentEquals(CPF)) {
					return true;
				}
			}
			
		}
		return false;
		
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isResponsavel() {
		return responsavel;
	}
	public void setResponsavel(boolean responsavel) {
		this.responsavel = responsavel;
	}

}
