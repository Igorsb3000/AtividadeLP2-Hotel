package br.com.hotel;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException; 

public class Main {
	public static void main(String[] args) throws ParseException {
		ArrayList <Hospedagem> hospedagens = new ArrayList<Hospedagem>();
		
		//Camareiros
		ArrayList <Camareiro> camareiros = new ArrayList<Camareiro>();
		Camareiro camareiro_1 = new Camareiro("123", "Luiz Pereira", 998.00 );
		Camareiro camareiro_2 = new Camareiro("124", "Luiza Costa", 998.00 );
		Camareiro camareiro_3 = new Camareiro("125", "Laura Souza", 998.00 );
		camareiros.add(camareiro_1);
		camareiros.add(camareiro_2);
		camareiros.add(camareiro_3);
		
		//Recepcionistas
		ArrayList <Recepcionista> recepcionistas = new ArrayList<Recepcionista>();
		
		ArrayList <String> IdiomaQueDomina = new ArrayList<String>();
		IdiomaQueDomina.add("Ingles");
		IdiomaQueDomina.add("Espanhol");
		Recepcionista recepcionista_1 = new Recepcionista("1234", "Carla Silva", 1200.00, IdiomaQueDomina);
		recepcionistas.add(recepcionista_1);
		
		IdiomaQueDomina = new ArrayList<String>();
		IdiomaQueDomina.add("Ingles");
		IdiomaQueDomina.add("Frances");
		IdiomaQueDomina.add("Italiano");
		Recepcionista recepcionista_2 = new Recepcionista("1245", "Silvia Bittencout", 1200.00, IdiomaQueDomina);
		recepcionistas.add(recepcionista_2);
		
		//Aposentos do Hotel
		ArrayList <Aposento> aposentos_disponiveis = new ArrayList<Aposento>();
		Aposento aposento_presidencial = new Aposento(123110, 50000, "Aposento de alto luxo equipado com o melhor da tecnologia e da sofisticacao", 110);
		Aposento aposento_luxuoso = new Aposento(123103, 10000, "Aposento de alto luxo com vista privilegiada", 103);
		Aposento aposento_mediano = new Aposento(12389, 1200, "Aposento confortavel com TV e frigobar", 89);
		Aposento aposento_simples = new Aposento(12345, 600, "Aposento simples com TV e Wifi", 45);
		aposentos_disponiveis.add(aposento_presidencial);
		aposentos_disponiveis.add(aposento_luxuoso);
		aposentos_disponiveis.add(aposento_mediano);
		aposentos_disponiveis.add(aposento_simples);
		
		
		Hotel hotel = new Hotel("Luxus Hotel", "123456789", hospedagens, recepcionistas, camareiros);

		String op_menu;
		Scanner ler = new Scanner(System.in);
		do {	
			System.out.println("***MENU***");
			System.out.println("1 - Cadastrar novo hospede");
			System.out.println("2 - Fazer pedido para sua conta");
			System.out.println("3 - Sair");
			op_menu = ler.nextLine();

			switch(op_menu) {
			case "1":
				Cadastro.cadastro(aposentos_disponiveis, hotel, hospedagens);
				break;
			default:
				System.out.println("erro");
				break;
			}
				
		}while(!(op_menu.contentEquals("3")));//
		
		System.out.println("***Hospedes do " + hotel.getNome() + "***");
		for(int i = 0; i< hospedagens.size(); i++) {
			System.out.println("Nome: " + hospedagens.get(i).getHospede().getNome());
			System.out.println("Codigo: " + hospedagens.get(i).getHospede().getCodigo());
			System.out.println();
		}
	
		ler.close();
	}
}



