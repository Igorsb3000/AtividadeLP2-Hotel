package br.com.hotel;
import java.util.ArrayList;

import br.com.funcionarios.Camareiro;
import br.com.funcionarios.Recepcionista;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Hotel {
    private String nome;
    private String cnpj;
    private ArrayList<Reserva> reservas;
    private ArrayList<Recepcionista> recepcionistas;
    private ArrayList<Camareiro> camareiros;
    /**
     * 
     * @param nome
     * @param cnpj
     * @param reservas
     * @param recepcionistas
     * @param camareiros
     */
    public Hotel(String nome, String cnpj, ArrayList<Reserva> reservas, ArrayList<Recepcionista> recepcionistas, ArrayList<Camareiro> camareiros) {
    	this.nome = nome;
    	this.cnpj = cnpj;
    	this.reservas = reservas;
    	this.recepcionistas = recepcionistas;
    	this.camareiros = camareiros;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public void setHospedagens(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    public ArrayList<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }
    public void setRecepcionistas(ArrayList<Recepcionista> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }
    public ArrayList<Camareiro> getCamareiros() {
        return camareiros;
    }
    public void setCamareiros(ArrayList<Camareiro> camareiros) {
        this.camareiros = camareiros;
    }
}

