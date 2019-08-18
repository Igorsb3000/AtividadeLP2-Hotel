package br.com.hotel;

public class Consumo {
    int codigo;
    String descricao;
    int quantidade;
    double valorUnitario;
    
    public Consumo(){ 
    	
    }
    	
    public Consumo(int codigo, int quantidade) {
    	switch(codigo) {
    	case 1:
    		this.descricao = "Água";
    		this.valorUnitario = 4;
    	case 2:
    		this.descricao = "Biscoito";
    		this.valorUnitario = 3;
    	case 3:
    		this.descricao = "Chocolate";
    		this.valorUnitario = 6;
    	case 4:
    		this.descricao = "Refrigerante";
    		this.valorUnitario = 5;
    	}
    	this.codigo = codigo;
    	this.quantidade = quantidade;
    }	
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
	
}

