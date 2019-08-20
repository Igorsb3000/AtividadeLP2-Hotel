package br.com.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
	private static Scanner ler;
	
	public static void pedido(ArrayList <Hospedagem> hospedagens) {
    	ler = new Scanner(System.in);
    	Consumo consumo;
    	int opcao, codigo_produto = 0, codigo, quantidade, cont = 0;
    	double valor_unitario = 0;
    	String resposta, descricao = null;
    	boolean check = false;
    		
    	System.out.println("Deseja consumir algum produto? s/n");
    	resposta = ler.nextLine();
    	
    	if(resposta.contentEquals("s")) {
    		do {
	    		System.out.println("****Lanches****");
	        	System.out.println("1 - Agua         R$/Unid. 4,00");
	        	System.out.println("2 - Biscoito     R$/Unid. 3,00");
	        	System.out.println("3 - Chocolate    R$/Unid. 6,00");
	        	System.out.println("4 - Refrigerante R$/Unid. 5,00");
	        	opcao = ler.nextInt();
	        	
        	}while(opcao < 1 || opcao > 4);
    		
    		switch(opcao) {
    		case 1: 
    			codigo_produto = 1400;
    			descricao = "Agua";
    			valor_unitario = 4;
    			break;
    		case 2:
    			codigo_produto = 2300;
    			descricao = "Biscoito";
    			valor_unitario = 3;
    			break;
    		case 3:
    			codigo_produto = 3600;
    			descricao = "Chocolate";
    			valor_unitario = 6;
    			break;
    		case 4: 
    			codigo_produto = 4500;
    			descricao = "Refrigerante";
    			valor_unitario = 5;
    			break;
    		}
        	
    		System.out.println("Quantas unidades ?");
        	quantidade = ler.nextInt();
        	
        	System.out.println();
    		
    		System.out.println("Digite o codigo do hospede: ");
    		codigo = ler.nextInt();
 
    		//Checando para saber se o codigo existe
    		check = Hospedagem. checarExistencia(codigo, hospedagens);
    		
    		if(check) {
	    		consumo = new Consumo(codigo_produto, descricao, quantidade, valor_unitario);
	        	
	    		for(int i = 0; i < hospedagens.size(); i++) {
	    			if(hospedagens.get(i).getHospede().getCodigo() == codigo) {
	    				hospedagens.get(i).getConta().getConsumos().add(consumo);
	    			}
	    		}
	    		
    		}else {
    			System.out.println("Hospede nao existe, tente novamente!");
    			return;
    		}
    		
    		
    	}
	}
}
