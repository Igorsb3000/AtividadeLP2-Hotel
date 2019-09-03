package br.com.menu;
import java.util.ArrayList;

import br.com.hotel.Reserva;

public class ListarHospedes {
	/**
	 * 
	 * @param reservas
	 */
	public static void listar(ArrayList<Reserva> reservas) {
		for(int i = 0; i< reservas.size(); i++) {System.out.println("entrou");
			for(int j=0; j<reservas.get(i).getQuantidadeHospedes()-1; j++) {System.out.println("entrou 2");
				System.out.println("Nome:" + reservas.get(i).getHospedes().get(j).getNome());
				System.out.println("CPF: " + reservas.get(i).getHospedes().get(j).getCPF());
				System.out.println();
				
			}
			
		}
	}

}
