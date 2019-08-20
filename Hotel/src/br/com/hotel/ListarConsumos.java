package br.com.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class ListarConsumos {
	private static Scanner ler;
	
	public static void listarConsumos(ArrayList <Hospedagem> hospedagens) {
		ler = new Scanner(System.in);
		int codigo;
		double valor_conta = 0;
		boolean check = false;
		
		System.out.println("Insira o codigo do hospede: ");
		codigo = ler.nextInt();
		
		//Checando para saber se o codigo existe e é unico
		check = Hospedagem. checarExistencia(codigo, hospedagens);
		
		if(check) {
			for(int i = 0; i < hospedagens.size(); i++) {
				if(hospedagens.get(i).getHospede().getCodigo() == codigo) {
					System.out.println("CODIGO ENCONTRADO: " + hospedagens.get(i).getHospede().getCodigo());
					for(int j = 0; j < hospedagens.get(i).getConta().getConsumos().size(); j++) {
						System.out.println("Codigo do Produto: " + hospedagens.get(i).getConta().getConsumos().get(j).getCodigo());
						System.out.println("Descricao: " + hospedagens.get(i).getConta().getConsumos().get(j).getDescricao());
						System.out.println("Quant.: " + hospedagens.get(i).getConta().getConsumos().get(j).getQuantidade());
						System.out.println("Valor unit.: R$" + hospedagens.get(i).getConta().getConsumos().get(j).getValorUnitario());
						valor_conta += hospedagens.get(i).getConta().getConsumos().get(j).getValorUnitario() * hospedagens.get(i).getConta().getConsumos().get(j).getQuantidade();
					}
					System.out.println();
					System.out.println("Total a pagar: R$ " + valor_conta);
					return;
							
				}else {
					System.out.println("Hospede nao existe ou nao consumiu nada");
					return;
				}
				
			}	
		}
		return;
	
		
	
	
	}

}
