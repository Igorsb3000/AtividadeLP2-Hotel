package br.com.hotel;
import java.util.ArrayList;

public class Recepcionista extends Funcionario {
	private ArrayList<String> IdiomaQueDomina = new ArrayList<String>();

    public ArrayList<String> getIdiomaQueDomina() {
        return this.IdiomaQueDomina;
    }
    
    public void setIdiomaQueDomina(String idioma) {
        this.IdiomaQueDomina.add(idioma);
    }
    
    public Recepcionista(String matricula, String nome, double salario, ArrayList<String> IdiomaQueDomina) {
    	super(matricula, nome, salario);
    	this.IdiomaQueDomina = IdiomaQueDomina;
    }
	
}
