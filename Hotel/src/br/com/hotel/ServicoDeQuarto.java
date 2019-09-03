package br.com.hotel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
//import java.util.ArrayList;

import br.com.clientes.Hospede;
import br.com.funcionarios.Camareiro;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class ServicoDeQuarto {
	private Date data;
	private Hospede hospede;
	private Camareiro camareiro;
	private boolean realizado;
	private static Scanner ler;
	/**
	 * 
	 * @param data
	 * @param Reserva
	 * @param camareiro
	 * @param realizado
	 */
	public ServicoDeQuarto(Date data, Reserva reserva, Camareiro camareiro, boolean realizado) {
		this.data = data;
		this.setHospede(hospede);
		this.camareiro = camareiro;
		this.realizado = realizado;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	 * Os parametros dos tipos Reserva e Camareiro indicam relacao de DEPENDENCIA entre
	 * ServicoDeQuarto -> Reserva & ServicoDeQuarto -> Camareiro.
	 */
	/**
	 * 
	 * @param Reserva
	 * @param camareiro
	 * @param servicoDeQuarto
	 */
	public static void realizarServicoQuarto(Reserva reserva, Camareiro camareiro, ServicoDeQuarto servicoDeQuarto) {
		LocalDate dataAtual_formatada = LocalDate.now();
		int contador = 0;
		
		if(reserva.getDataEntrada().compareTo(servicoDeQuarto.getData()) <= 0) {
			contador++;
			if(reserva.getDataSaida().compareTo(servicoDeQuarto.getData()) >= 0) {
				contador++;
				if(contador == 2) {
					servicoDeQuarto.setRealizado(true);
					System.out.println();
					System.out.println("Ainda hoje o(a) camareiro(a) " + camareiro.getNome() + " ira ate seu quarto!");
		
					if(servicoDeQuarto.getRealizado()) {
						System.out.println();
						System.out.println("***Servico Realizado***");
						System.out.println();
						System.out.println("Data: " + dataAtual_formatada);
						System.out.println("Aposento: " + reserva.getAposento().getNumero());
						System.out.println("Camareiro(a) respons�vel: " + camareiro.getNome());
						System.out.println();
						return;
					}
				}
			}
		}
		System.out.println("Data invalida!");
		
	}
	
	/**
	 * 
	 * @param Reserva
	 * @param camareiro
	 * @throws ParseException
	 */
	public static void agendarServicoQuarto(Reserva reserva, Camareiro camareiro) throws ParseException {
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
		
		if(reserva.getDataEntrada().compareTo(dataServico) <= 0) {
			contador++;
			if(reserva.getDataSaida().compareTo(dataServico) >= 0) {
				contador++;
				if(contador == 2) {
					System.out.println();
					System.out.println("Servico agendado com sucesso!");
					System.out.println();
					System.out.println("No dia " + formato.format(dataServico)+ " o(a) camareiro(a) " + camareiro.getNome() + " ira ate seu quarto!");
					ServicoDeQuarto servicoDeQuarto = new ServicoDeQuarto(dataServico, reserva, camareiro, servicoRealizado);

					if(dataAtual.compareTo(dataServico) == 0) {
						ServicoDeQuarto.realizarServicoQuarto(reserva, camareiro, servicoDeQuarto);
					}
					
				}
			}
		}else {
			System.out.println("Data invalida!");
		}
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	

	
}
