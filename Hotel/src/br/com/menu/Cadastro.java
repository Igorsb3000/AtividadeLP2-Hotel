package br.com.menu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

import br.com.clientes.Consumo;
import br.com.clientes.Conta;
import br.com.clientes.Hospede;
import br.com.hotel.Aposento;
import br.com.hotel.Reserva;
import br.com.hotel.Hotel;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class Cadastro {
	private static Scanner ler;
	private static ArrayList<Hospede> hospedes;
	/**
	 * 
	 * @param aposentos_disponiveis
	 * @param hotel
	 * @param reservas
	 * @return
	 * @throws ParseException
	 */ 
	public static int cadastro(ArrayList <Aposento> aposentos_disponiveis, Hotel hotel, ArrayList <Reserva> reservas) throws ParseException {
		ler = new Scanner(System.in);
		double valor_conta = 0;
		boolean pago_conta = false, responsavel = false;
		boolean check = true;
		Random rnd = new Random();
		int codigo = rnd.nextInt(100)+1;  //Codigo unico de cada hospede
		int codigo_hospede, codigo_conta, opcao, quant_hospedes = 0;
		Date dataEntrada, dataSaida;
		String nome, CPF, RG, telefone, resposta;
		ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
		Aposento aposento_escolhido;
		
		System.out.println("Deseja se hospedar no " + hotel.getNome() + " ? s/n ");
		resposta = ler.nextLine();
		
		if(resposta.contentEquals("s")) {	
			System.out.println("Insira a quantidade de pessoas para essa reserva: ");
			quant_hospedes = ler.nextInt();
			//quant_hospedes = quant_hospedes+1;
			if(quant_hospedes > 5 || quant_hospedes < 1) {
				System.out.println("Nao possuimos um aposento para a quantidade de pessoas solicitadas");
				return -1;
			}
	
			String dataRecebida;
			System.out.println("Insira a data de entrada(dd/mm/yyyy): ");
			ler.nextLine();
			dataRecebida = ler.nextLine();
			System.out.println("data recebida: "+ dataRecebida);
		
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			dataEntrada = formato.parse(dataRecebida);
			
			//System.out.println("Data de entrada: " + formato.format(dataEntrada));
			System.out.println();
			
			System.out.println("Insira a data de saida(dd/mm/yyyy): ");
			dataRecebida = ler.nextLine();
			formato = new SimpleDateFormat("dd/MM/yyyy");
			dataSaida = formato.parse(dataRecebida);
			//System.out.println("Data de saida: " + formato.format(dataSaida));
			
			System.out.println();
			System.out.println("***Aposentos Disponiveis*** ");
			System.out.println();
			for(int i = 0; i < aposentos_disponiveis.size(); i++) {
				int j = i+1;
				System.out.println("Aposento " + j + ": ");
				System.out.println("Desricao: " + aposentos_disponiveis.get(i).getDescricao());
				System.out.println("Capacidade Max.: " + aposentos_disponiveis.get(i).getCapacidade());
				System.out.println("Ocupacao: " + aposentos_disponiveis.get(i).getOcupacao() + "/" + aposentos_disponiveis.get(i).getCapacidade() );
				System.out.println("Numero: " + aposentos_disponiveis.get(i).getNumero());
				System.out.println("Valor da diaria: R$" + aposentos_disponiveis.get(i).getValor());
				System.out.println();
			}
			
			System.out.println("Insira o numero do aposento que deseja: ");
			opcao = ler.nextInt();
			System.out.println("opcao: " + opcao);
			System.out.println("aposento escolhido: "+ aposentos_disponiveis.get(opcao-1).getValor());
			
			aposento_escolhido = aposentos_disponiveis.get(opcao-1);
			
			/**do {
				System.out.println("Insira o numero do aposento que deseja: ");
				opcao = ler.nextInt();
				System.out.println("opcao: " + opcao);
				System.out.println("aposento escolhido: "+aposentos_disponiveis.get(opcao-1).getValor());
			}while(quant_hospedes > aposentos_disponiveis.get(opcao-1).getCapacidade());
			 */
			for(int i=0; i<quant_hospedes; i++) {
				do{
					check = Reserva.checagemDeCodigo(codigo, reservas);
					codigo = rnd.nextInt(100)+1;
				}while(!check);
							
				do {
					System.out.println("Insira seu CPF sem espaco: ");
					ler.nextLine();
					CPF = ler.nextLine();
					check = Hospede.CheckCPF(CPF, reservas); //O hospede so pode se cadastrar uma vez
				}while(check == true);
				
				codigo_hospede = codigo;
				
				System.out.println();
				System.out.println("Insira seu nome: ");
				nome = ler.nextLine();
				System.out.println();
				System.out.println("Insira seu RG sem espaco: ");
				RG = ler.nextLine();
				System.out.println();
				System.out.println("Insira seu telefone (DD) 9 9999-9999: ");
				telefone = ler.nextLine();
							
				//Se for o primeiro a se hospedar entao ele sera o responsavel
				if(aposentos_disponiveis.get(opcao-1).getOcupacao() == 0) {
					responsavel = true;
					aposentos_disponiveis.get(opcao-1).setOcupacao(quant_hospedes);
					
					/*
					 * codigo_conta = codigo;
					 * 
					 * ArrayList<Consumo> consumos = new ArrayList<Consumo>();
					 */
					
					//Conta conta = new Conta(codigo_conta, valor_conta, pago_conta, consumos);
					
				}else{
					responsavel = false;
				}
				
				
				//Remove o aposento escolhido da lista de aposentos disponiveis se a capacidade for preenchida
				if(aposentos_disponiveis.get(opcao-1).getOcupacao() == aposentos_disponiveis.get(opcao-1).getCapacidade()) {
					aposentos_disponiveis.remove(opcao - 1);
				}
				
				Hospede hospede = new Hospede(codigo_hospede, nome, CPF, RG, telefone, responsavel);
				hospedes.add(hospede);
				
				//int controle = 0;
				//int quantidadeReservas = 0;
				/*
				for(int i=0; i < reservas.size(); i++) {
					if(reservas.get(i).getAposento().getCodigo() == codigo) {
						quantidadeReservas++;
						//Compara se a data de entrada inserida eh menor que a data de entrada
						if(dataEntrada.compareTo(reservas.get(i).getDataEntrada()) < 0) {
							if(dataSaida.compareTo(reservas.get(i).getDataEntrada()) < 0) {
								controle++;
							}
						}
						//Compara se a data de entrada e saída são maiores que a data de saída
						if(dataEntrada.compareTo(reservas.get(i).getDataSaida()) > 0) {
							controle++;
						}	
					}
				}
				
				if(controle != quantidadeReservas) {
					System.out.println("O  aposento não esta disponivel para essa data!");
					return -1;
				}
				*/
				//for(int j = 0; j<reservas.size(); j++) {
					//if(reservas.get(j).getHospedes().get(i).getCodigo() == codigo) {					
						codigo_conta = codigo;
						ArrayList<Consumo> consumos = new ArrayList<Consumo>();
						
						Conta conta = new Conta(codigo_conta, valor_conta, pago_conta, consumos);
						Reserva reserva = new Reserva(codigo, dataEntrada, dataSaida, hospedes, aposento_escolhido, conta, quant_hospedes);
						reservas.add(reserva);
						
					//}
				//}
				
				
				/*for(int j = 0; j < reservas.size(); j++) {
	    			if(reservas.get(j).getCodigo() == codigo) {
	    				reservas.get(j).setHospedes(hospedes);
	    				break;
	    			}
	    		}*/	
			}
			return codigo;
			
		}//primeiro if
			
		return 0;
	}

}
