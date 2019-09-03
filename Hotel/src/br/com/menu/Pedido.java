package br.com.menu;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.clientes.Consumo;
import br.com.hotel.Reserva;

/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Pedido {
	private static Scanner ler;
	/**
	 * 
	 * @param hospedagens
	 */
	public static void pedido(ArrayList <Reserva> reservas) {
    	ler = new Scanner(System.in);
    	Consumo consumo;
    	int opcao, codigo_produto = 0, codigo, quantidade;
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
    		check = Reserva.checarExistencia(codigo, reservas);
    		
    		if(check) {
	    		consumo = new Consumo(codigo_produto, descricao, quantidade, valor_unitario);
	        	
	    		for(int i = 0; i < reservas.size(); i++) {
	    			if(reservas.get(i).getHospedes().get(i).isResponsavel()) {
	    				//if(reservas.get(i).getHospedes().get(i).isResponsavel())
	    				reservas.get(i).getConta().getConsumos().add(consumo);
	    			}
	    		}
	    		
    		}else {
    			System.out.println("Hospede nao eh o responsavel, tente novamente!");
    			return;
    		}
    		
    		
    	}
	}
}
