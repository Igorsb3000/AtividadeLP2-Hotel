package br.com.main;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import br.com.funcionarios.Camareiro;
import br.com.funcionarios.Recepcionista;
import br.com.hotel.Aposento;
import br.com.hotel.Hospedagem;
import br.com.hotel.Hotel;
import br.com.hotel.ServicoDeQuarto;
import br.com.menu.Cadastro;
import br.com.menu.ListarConsumos;
import br.com.menu.PagarConta;
import br.com.menu.Pedido;

import java.text.ParseException; 
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Main {
	/**
	 * 
	 * @param args
	 * @throws ParseException
	 */
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
		Aposento aposento_presidencial = new Aposento(123110, 50000, "Aposento de alto luxo equipado com o melhor da tecnologia e da sofisticacao", 110, 5);
		Aposento aposento_luxuoso = new Aposento(123103, 10000, "Aposento de alto luxo com vista privilegiada", 103, 4);
		Aposento aposento_mediano = new Aposento(12389, 1200, "Aposento confortavel com TV e frigobar", 89, 3);
		Aposento aposento_simples = new Aposento(12345, 600, "Aposento simples com TV e Wifi", 45, 2);
		aposentos_disponiveis.add(aposento_presidencial);
		aposentos_disponiveis.add(aposento_luxuoso);
		aposentos_disponiveis.add(aposento_mediano);
		aposentos_disponiveis.add(aposento_simples);
		
		Hotel hotel = new Hotel("Luxus Hotel", "123456789", hospedagens, recepcionistas, camareiros);

		int op_menu;
		Scanner ler = new Scanner(System.in);
			
		do{
			System.out.println();
			System.out.println(" ___________________ ");
			System.out.println("|  ---------------  |");
			System.out.println("|  MENU  PRINCIPAL  |");
			System.out.println("|  ---------------  |");
			System.out.println("|___________________|");
			System.out.println();
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar novo hospede");
			System.out.println("2 - Listar hospedes");
			System.out.println("3 - Procurar hospede pelo codigo");
			System.out.println("4 - Fazer pedido para sua conta");
			System.out.println("5 - Listar todos os consumos");
			System.out.println("6 - Pagar conta");
			System.out.println("7 - Realizar servico de quarto");
			System.out.println("8 - Agendar servico de quarto");
			op_menu = ler.nextInt();
		
			switch(op_menu) {
			case 1:
				int codigo = Cadastro.cadastro(aposentos_disponiveis, hotel, hospedagens);
				System.out.println();
				System.out.println(">>> Seu Codigo eh: " + codigo +" <<<");
				break;
			case 2:
				System.out.println("***Hospedes do " + hotel.getNome() + "***");
				for(int i = 0; i< hospedagens.size(); i++) {
					System.out.println("Nome: " + hospedagens.get(i).getHospede().get(i).getNome());
					System.out.println("Codigo: " + hospedagens.get(i).getHospede().get(i).getCodigo());
					System.out.println();
				}
		   		break;
			case 3:
				System.out.println("Digite o codigo do hospede: ");
		  		int cod = ler.nextInt();
		   		for(int i = 0; i < hospedagens.size(); i++) {
		   			if(hospedagens.get(i).getCodigo() == cod) {
		   				System.out.println("Hospede: " + hospedagens.get(i).getHospede().get(i).getNome());
		   			}else {
		   				System.out.println("Hospede nao existe!");
		   			}
		   		}
				break;
			case 4:
				Pedido.pedido(hospedagens);
				break;
			case 5:
				ListarConsumos.listarConsumos(hospedagens);
				break;
			case 6:
				PagarConta.pagarConta(hospedagens);
				break;
			case 7:
				boolean check;
				Date dataAtual = new Date();
				System.out.println("Insira o codigo do hospede: ");
				codigo = ler.nextInt();
				check = Hospedagem. checarExistencia(codigo, hospedagens);
				if(check) {
					Random rnd = new Random();
					int aleatorio = camareiros.size();
					for(int i = 0; i< hospedagens.size(); i++) {
						if(hospedagens.get(i).getHospede().get(i).getCodigo() == codigo) {
							ServicoDeQuarto servicoDeQuarto = new ServicoDeQuarto(dataAtual, hospedagens.get(i), camareiros.get(rnd.nextInt(aleatorio)), false);
							ServicoDeQuarto.realizarServicoQuarto(hospedagens.get(i), camareiros.get(rnd.nextInt(aleatorio)), servicoDeQuarto);
						}	
					}
				}else {
					System.out.println("Hospede nao existe!");
				}
				
				break;
			case 8:
				System.out.println("Insira o codigo do hospede: ");
				codigo = ler.nextInt();
				check = Hospedagem. checarExistencia(codigo, hospedagens);
				if(check) {
					Random rnd = new Random();
					int aleatorio = camareiros.size();
					for(int i = 0; i< hospedagens.size(); i++) {
						if(hospedagens.get(i).getHospede().get(i).getCodigo() == codigo) {
							ServicoDeQuarto.agendarServicoQuarto(hospedagens.get(i), camareiros.get(rnd.nextInt(aleatorio)));
						}	
					}
				}else {
					System.out.println("Hospede nao existe!");
				}
				
				break;
			default:
				System.out.println();
				System.out.println("Sistema finalizado com sucesso!");
				break;
			}
		}while(op_menu != 0);
		
		System.out.println();
		ler.close();
	}
}



