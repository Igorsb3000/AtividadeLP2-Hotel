package br.com.funcionarios;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Funcionario {
	protected String matricula;
	private String nome;
	private double salario;
	/**
	 * 
	 * @param matricula
	 * @param nome
	 * @param salario
	 */
	public Funcionario(String matricula, String nome, double salario) {
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
