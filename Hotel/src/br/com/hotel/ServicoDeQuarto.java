package br.com.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;


public class ServicoDeQuarto {
	private static Date data;
	private Hospedagem hospedagem;
	private Camareiro camareiro;
	private static boolean realizado;
	private static Scanner ler;
	
	
	public Date getData() {
		return data;
	}
	public static void setData(Date data) {
		ServicoDeQuarto.data = data;
	}
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	public Camareiro getCamareiro() {
		return camareiro;
	}
	public void setCamareiro(Camareiro camareiro) {
		this.camareiro = camareiro;
	}
	public static boolean isRealizado() {
		return realizado;
	}
	public static void setRealizado(boolean realizado) {
		ServicoDeQuarto.realizado = realizado;
	}
	/**
	 * Os parametros dos tipos Hospedagem e Camareiro indicam relacao de DEPENDENCIA entre
	 * ServicoDeQuarto -> Hospedagem & ServicoDeQuarto -> Camareiro.
	 */
	
	public static void realizarServicoQuarto(ArrayList <Hospedagem> hospedagens, ArrayList <Camareiro> camareiro) {
		if(isRealizado()) {
			System.out.println("Nao existe servico pendente!");
		}else {
			int codigo, j;
			System.out.println("Insira o codigo do hospede: ");
			codigo = ler.nextInt();
			
			for(int i = 0; i < hospedagens.size(); i++) {
				if(hospedagens.get(i).getHospede().getCodigo() == codigo) {
					j = i;
				}
			}
			Date entrada, saida, dataServico;
			
			
			
			//System.out.println("Realizando servico na hospedagem " + hospedagens.getCodigo());
			System.out.println("Para concluir o servico digite qualquer tecla e pressione enter.");
			String concluir_servico = ler.nextLine();
			System.out.println("Servico realizado com sucesso!");
			setRealizado(true);
		}	
	}
	
	
	public static void agendarServicoQuarto(Hospedagem hospedagem, Camareiro camareiro) throws ParseException {
		ler = new Scanner(System.in);
		int contador = 0;
		String dataRecebida;
		Date dataServico;
		
		System.out.println("Insira a data para execucao do servio(dd/mm/yyyy): ");
		dataRecebida = ler.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		dataServico = formato.parse(dataRecebida);
		
		if(hospedagem.getDataEntrada().compareTo(dataServico) < 0) {
			contador++;
			if(hospedagem.getDataSaida().compareTo(dataServico) > 0) {
				contador++;
				if(contador == 2) {
					System.out.println();
					System.out.println("Servico agendado com sucesso!");
					System.out.println();
					System.out.println("No dia " + formato.format(dataServico)+ " o(a) camareiro(a) " + camareiro.getNome() + " ira ate seu quarto!");
					return;
				}
			}
		}
		System.out.println("Data invalida!");

		//setRealizado(false);
	}
	
}
