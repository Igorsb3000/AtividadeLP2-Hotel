package br.com.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


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
	
	public static void realizarServicoQuarto(Hospedagem hospedagem, Camareiro camareiro) {
		if(isRealizado()) {
			System.out.println("Não existe serviço pendente!");
		}else {
			System.out.println("Realizando servico na hospedagem " + hospedagem.getCodigo());
			System.out.println("Para concluir o serviço digite qualquer tecla e pressione enter.");
			String concluir_servico = ler.nextLine();
			System.out.println("Serviço realizado com sucesso!");
			setRealizado(true);
		}	
	}
	
	public static void agendarServicoQuarto(Hospedagem hospedagem, Camareiro camareiro) throws ParseException {
		ler = new Scanner(System.in);
		String dataRecebida;
		System.out.println("Realizando servico no aposento " + hospedagem.getCodigo());
		System.out.println("Insira a data para execução do serviço(dd/mm/yyyy): ");
		dataRecebida = ler.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//tentei formatar a data e acabei não conseguindo
		Date dataServico = formato.parse(dataRecebida);
		setData(dataServico);
		System.out.println("No dia " + dataServico + " o camareiro " + camareiro.getNome() + " irá executar o serviço!");
		setRealizado(false);
	}
}
