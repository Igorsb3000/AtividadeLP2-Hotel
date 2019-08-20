package br.com.menu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

import br.com.clientes.Consumo;
import br.com.clientes.Conta;
import br.com.clientes.Hospede;
import br.com.hotel.Aposento;
import br.com.hotel.Hospedagem;
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
	 * @param hospedagens
	 * @return
	 * @throws ParseException
	 */
	public static int cadastro(ArrayList <Aposento> aposentos_disponiveis, Hotel hotel, ArrayList <Hospedagem> hospedagens) throws ParseException {
		double valor_conta = 0;
		boolean pago_conta = false;
		ler = new Scanner(System.in);
		Random rnd = new Random();
		int codigo = rnd.nextInt(100)+1;  //Codigo unico de cada hospede
		boolean check = true;
		String resposta;
		Date dataEntrada, dataSaida;
		int codigo_hospede, codigo_conta, opcao;
		String nome, CPF, RG, telefone;
		
		System.out.println("Deseja se hospedar no " + hotel.getNome() + " ? s/n ");
		resposta = ler.nextLine();
		if(resposta.contentEquals("s")) {
			check = Hospedagem.checagemDeCodigo(codigo, hospedagens);
			while(!check) {
				check = Hospedagem.checagemDeCodigo(codigo, hospedagens);
				codigo = rnd.nextInt(100)+1;
			}
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
			
			Hospede hospede = new Hospede(codigo_hospede, nome, CPF, RG, telefone);
			
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
			
			//Remove o aposento escolhido da lista de aposentos disponiveis
			aposentos_disponiveis.remove(opcao - 1); 
			
			codigo_conta = codigo;
			
			ArrayList<Consumo> consumos = new ArrayList<Consumo>();
			
			Conta conta = new Conta(codigo_conta, valor_conta, pago_conta, consumos);
			
			Hospedagem hospedagem = new Hospedagem(codigo, dataEntrada, dataSaida, hospede, aposento_escolhido, conta);
			hospedagens.add(hospedagem);		
		}
		return codigo;
	}

}
