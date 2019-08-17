package br.com.hotel;

import java.util.ArrayList;

public class Hotel {
    private String nome;
    private String cnpj;
    private ArrayList<Hospedagem> hospedagens;
    private ArrayList<Recepcionista> recepcionistas;
    private ArrayList<Camareiro> camareiros;
    
    public Hotel(String nome, String cnpj, ArrayList<Hospedagem> hospedagens, ArrayList<Recepcionista> recepcionistas, ArrayList<Camareiro> camareiros) {
    	this.nome = nome;
    	this.cnpj = cnpj;
    	this.hospedagens = hospedagens;
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
    public ArrayList<Hospedagem> getHospedagens() {
        return hospedagens;
    }
    public void setHospedagens(ArrayList<Hospedagem> hospedagens) {
        this.hospedagens = hospedagens;
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

