package br.com.clientes;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Consumo {
    int codigo;
    String descricao;
    int quantidade;
    double valorUnitario;
    /**
     * 
     * @param codigo
     * @param descricao
     * @param quantidade
     * @param valorUnitario
     */
    public Consumo(int codigo, String descricao, int quantidade, double valorUnitario) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    	this.quantidade = quantidade;
    	this.valorUnitario = valorUnitario;	
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

