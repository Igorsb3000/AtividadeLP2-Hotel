package br.com.hotel;

public class Hospede {
	private int codigo;
	private String nome;
	private String CPF;
	private String RG;
	private String telefone;
	
	public Hospede(int codigo, String nome, String CPF, String RG, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.telefone = telefone;
	}

	public int getCodigo() {
		return this.codigo;
	}
	public String getNome() {
		return this.nome;
	}
	public String getCPF() {
		return this.CPF;
	}
	public String getRG() {
		return this.RG;
	}
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setcodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public void setRG(String RG) {
		this.RG = RG;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
