package br.com.funcionarios;
import java.util.ArrayList;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Recepcionista extends Funcionario {
	private ArrayList<String> IdiomaQueDomina = new ArrayList<String>();

    public ArrayList<String> getIdiomaQueDomina() {
        return this.IdiomaQueDomina;
    }
    
    public void setIdiomaQueDomina(String idioma) {
        this.IdiomaQueDomina.add(idioma);
    }
   //Metodo sobrescrito da classe Funcionario	
    public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
    /**
     * 
     * @param matricula
     * @param nome
     * @param salario
     * @param IdiomaQueDomina
     */
    public Recepcionista(String matricula, String nome, double salario, ArrayList<String> IdiomaQueDomina) {
    	super(matricula, nome, salario);
    	this.IdiomaQueDomina = IdiomaQueDomina;
    }
	
}
