package br.com.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
	private static Scanner ler;
	
	public static void pedido(Hotel hotel, ArrayList <Hospedagem> hospedagens) {
    	ler = new Scanner(System.in);
    	int codigo;
    	String resposta;
    	int quantidade;
    		
    	System.out.println("Deseja consumir algum produto? s/n");
    	resposta = ler.nextLine();
    	
    	if(resposta.contentEquals("s")) {
    		do {
    		System.out.println("****Lanches****");
        	System.out.println("1 - Água R$ 4,00");
        	System.out.println("2 - Biscoito R$ 3,00");
        	System.out.println("3 - Chocolate R$ 6,00");
        	System.out.println("4 - Refrigerante R$ 5,00");
        	codigo = ler.nextInt();
        	
        	}while(codigo < 1 || codigo > 4);
        	System.out.println("Quantas unidades você quer?");
        	quantidade = ler.nextInt();
        	
        	Consumo consumo = new Consumo(codigo, quantidade);
        	
        	System.out.println();
        	
        	System.out.println("***Hospedes do " + hotel.getNome() + "***");
    		for(int i = 0; i< hospedagens.size(); i++) {
    			System.out.println("Nome: " + hospedagens.get(i).getHospede().getNome());
    			System.out.println("Codigo: " + hospedagens.get(i).getHospede().getCodigo());
    			System.out.println();
    		}
    		
    		System.out.println("Digie o código do hospede: ");
    		codigo = ler.nextInt();
        	
        hospedagens.get(codigo).getConta().setConsumos(consumo);   	
    	}
	}
}
