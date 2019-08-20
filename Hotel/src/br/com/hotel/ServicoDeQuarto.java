package br.com.hotel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
//import java.util.ArrayList;


public class ServicoDeQuarto {
	private Date data;
	private Hospedagem hospedagem;
	private Camareiro camareiro;
	private boolean realizado;
	
	//private LocalDate dataAtual = LocalDate.now();
	private static Scanner ler;
	
	public ServicoDeQuarto(Date data, Hospedagem hospedagem, Camareiro camareiro, boolean realizado) {
		this.data = data;
		this.hospedagem = hospedagem;
		this.camareiro = camareiro;
		this.realizado = realizado;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	public boolean getRealizado() {
		return realizado;
	}
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	
	/**
	 * Os parametros dos tipos Hospedagem e Camareiro indicam relacao de DEPENDENCIA entre
	 * ServicoDeQuarto -> Hospedagem & ServicoDeQuarto -> Camareiro.
	 */
	
	public static void realizarServicoQuarto(Hospedagem hospedagem, Camareiro camareiro, ServicoDeQuarto servicoDeQuarto) {
		//Date dataAtual = new Date();
		LocalDate dataAtual_formatada = LocalDate.now();
		int contador = 0;
		//boolean servicoRealizado = true;
		
		if(hospedagem.getDataEntrada().compareTo(servicoDeQuarto.getData()) < 0 || hospedagem.getDataEntrada().compareTo(servicoDeQuarto.getData()) == 0) {
			contador++;
			if(hospedagem.getDataSaida().compareTo(servicoDeQuarto.getData()) > 0 || hospedagem.getDataSaida().compareTo(servicoDeQuarto.getData()) == 0 ) {
				contador++;
				if(contador == 2) {
					servicoDeQuarto.setRealizado(true);
					System.out.println();
					System.out.println("Ainda hoje o(a) camareiro(a) " + camareiro.getNome() + " ira ate seu quarto!");
					//ServicoDeQuarto servicoDeQuarto = new ServicoDeQuarto(dataAtual, hospedagem, camareiro, servicoRealizado);
					if(servicoDeQuarto.getRealizado()) {
						System.out.println();
						System.out.println("***Servico Realizado***");
						System.out.println();
						System.out.println("Data: " + dataAtual_formatada);
						System.out.println("Aposento: " + hospedagem.getAposento().getNumero());
						System.out.println("Camareiro(a) responsável: " + camareiro.getNome());
						System.out.println();
						return;
					}
				}
			}
		}
		System.out.println("Data invalida!");
		
	}
	
	
	public static void agendarServicoQuarto(Hospedagem hospedagem, Camareiro camareiro) throws ParseException {
		ler = new Scanner(System.in);
		Date dataAtual = new Date();
		int contador = 0;
		boolean servicoRealizado = false; 
		String dataRecebida, dataAtual_string;
		Date dataServico;
		
		System.out.println("Insira a data para execucao do servico(dd/mm/yyyy): ");
		dataRecebida = ler.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		dataAtual_string = formato.format(dataAtual); 
		dataServico = formato.parse(dataRecebida);
		dataAtual = formato.parse(dataAtual_string);
		
		if(hospedagem.getDataEntrada().compareTo(dataServico) <= 0) {
			contador++;
			if(hospedagem.getDataSaida().compareTo(dataServico) >= 0) {
				contador++;
				if(contador == 2) {
					System.out.println();
					System.out.println("Servico agendado com sucesso!");
					System.out.println();
					System.out.println("No dia " + formato.format(dataServico)+ " o(a) camareiro(a) " + camareiro.getNome() + " ira ate seu quarto!");
					ServicoDeQuarto servicoDeQuarto = new ServicoDeQuarto(dataServico, hospedagem, camareiro, servicoRealizado);

					if(dataAtual.compareTo(dataServico) == 0) {
						ServicoDeQuarto.realizarServicoQuarto(hospedagem, camareiro, servicoDeQuarto);
					}
					
				}
			}
		}else {
			System.out.println("Data invalida!");
		}
	}
	

	
}
