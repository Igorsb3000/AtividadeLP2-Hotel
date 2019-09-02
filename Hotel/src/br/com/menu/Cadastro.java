package br.com.menu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		int codigo_hospede, codigo_conta, opcao;
		Date dataEntrada, dataSaida;
		String nome, CPF, RG, telefone, resposta;
		
		
		System.out.println("Deseja se hospedar no " + hotel.getNome() + " ? s/n ");
		resposta = ler.nextLine();
		if(resposta.contentEquals("s")) {
			do{
				check = Reserva.checagemDeCodigo(codigo, reservas);
				codigo = rnd.nextInt(100)+1;
			}while(!check);
			
			String dataRecebida;
			System.out.println("Insira a data de entrada(dd/mm/yyyy): ");
			dataRecebida = ler.nextLine();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			dataEntrada = formato.parse(dataRecebida);
			//System.out.println("Data de entrada: " + formato.format(dataEntrada));
			System.out.println();
			
			System.out.println("Insira a data de saida(dd/mm/yyyy): ");
			dataRecebida = ler.nextLine();
			formato = new SimpleDateFormat("dd/MM/yyyy");
			dataSaida = formato.parse(dataRecebida);
			//System.out.println("Data de saida: " + formato.format(dataSaida));
			
			codigo_hospede = codigo;
			System.out.println();
			System.out.println("Insira seu nome: ");
			nome = ler.nextLine();
			System.out.println();
			System.out.println("Insira seu CPF sem espaco: ");
			CPF = ler.nextLine();
			System.out.println();
			System.out.println("Insira seu RG sem espaco: ");
			RG = ler.nextLine();
			System.out.println();
			System.out.println("Insira seu telefone (DD) 9 9999-9999: ");
			telefone = ler.nextLine();
			
			Hospede hospede = new Hospede(codigo_hospede, nome, CPF, RG, telefone, responsavel);
			
			System.out.println();
			System.out.println("***Aposentos Disponiveis*** ");
			System.out.println();
			for(int i = 0; i < aposentos_disponiveis.size(); i++) {
				int j = i+1;
				System.out.println("Aposento " + j + ": ");
				System.out.println("Desricao: " + aposentos_disponiveis.get(i).getDescricao());
				System.out.println("Numero: " + aposentos_disponiveis.get(i).getNumero());
				System.out.println("Valor da diaria: R$" + aposentos_disponiveis.get(i).getValor());
				System.out.println();
			}
			
			System.out.println("Insira o numero do aposento que deseja: ");
			opcao = ler.nextInt();
			
			Aposento aposento_escolhido = new Aposento();
			aposento_escolhido = aposentos_disponiveis.get(opcao-1);
			
			int controle = 0;
			int quantidadeReservas = 0;
			
			for(int i=0; i < reservas.size(); i++) {
				if(reservas.get(i).getAposento().getCodigo() == opcao-1) {
					quantidadeReservas++;
					//Compara se a data de entrada e saída são menores que a data de entrada
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
				System.out.println("O  aposento não esta disponível para esse período!");
				return -1;
			}
			
			//Remove o aposento escolhido da lista de aposentos disponiveis
			//aposentos_disponiveis.remove(opcao - 1); 
			
			//Vai criar uma conta para cada hospede ou só para o hospede responsável?
			codigo_conta = codigo;
			
			ArrayList<Consumo> consumos = new ArrayList<Consumo>();
			
			Conta conta = new Conta(codigo_conta, valor_conta, pago_conta, consumos);
			
			Reserva reserva = new Reserva(codigo, dataEntrada, dataSaida, hospede, aposento_escolhido, conta);
			reservas.add(reserva);		
		}
		return codigo;
	}

}
