package br.com.menu;
import java.util.ArrayList;

import br.com.hotel.Reserva;

public class ListarHospedes {
	
	public static void listar(ArrayList<Reserva> reservas) {
		for(int i =0; i< reservas.size(); i++) {
			System.out.println("Nome:" + reservas.get(i).getHospedes().get(i).getNome());
			System.out.println("CPF: " + reservas.get(i).getHospedes().get(i).getCPF());
			System.out.println();
		}
	}

}
