package br.com.hotel;
import java.util.ArrayList;

public class Conta{
    private int codigo;
    private double valor;
    private boolean pago;
    private ArrayList<Consumo> consumos;
    
    public Conta(int codigo, double valor, boolean pago, ArrayList<Consumo> consumos) {
    	this.codigo = codigo;
    	this.valor = valor;
    	this.pago = pago;
    	this.consumos = consumos;
    }
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }
    public ArrayList<Consumo> getConsumos() {
        return consumos;
    }
    public void setConsumos(Consumo consumo) {
        consumos.add(consumo);
    }
    
}

