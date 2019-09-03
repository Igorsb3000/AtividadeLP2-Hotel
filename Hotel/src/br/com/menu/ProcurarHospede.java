package br.com.menu;
import java.util.ArrayList;

import br.com.hotel.Reserva;

public class ProcurarHospede {
	
	public static void procurarHospede(int codigo, ArrayList<Reserva> reservas) {
		for(int i = 0; i<reservas.size(); i++) {
			if(reservas.get(i).getHospedes().get(i).getCodigo() == codigo) {
				System.out.println("***Hospede Encontrado***");
				System.out.println();
				System.out.println("Nome: " + reservas.get(i).getHospedes().get(i).getNome());
				System.out.println("CPF: " + reservas.get(i).getHospedes().get(i).getCPF());
				System.out.println("Codigo: " + reservas.get(i).getHospedes().get(i).getCodigo());
				System.out.println();
				break;
			}
			else {
				System.out.println("Hospede nao existe!");
			}
		}
		
		
	}
}
