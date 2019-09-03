package br.com.menu;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.hotel.Reserva;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class ListarConsumos {
	private static Scanner ler;
	/**
	 * 
	 * @param hospedagens
	 */
	public static void listarConsumos(ArrayList <Reserva> reservas) {
		ler = new Scanner(System.in);
		int codigo, i;
		double valor_conta = 0;
		boolean check = false;
		
		System.out.println("Insira o codigo do hospede: ");
		codigo = ler.nextInt();
		
		//Checando para saber se o codigo existe e é unico
		check = Reserva.checarExistencia(codigo, reservas);
		
		if(check) {
			for(i = 0; i < reservas.size(); i++) {
				if(reservas.get(i).getHospedes().get(i).getCodigo() == codigo) {
					
					for(int j = 0; j < reservas.size(); j++) { //getHospedes().getConta().getConsumos().size()
						System.out.println("Codigo do Produto: " + reservas.get(i).getConta().getConsumos().get(j).getCodigo());
						System.out.println("Descricao: " + reservas.get(i).getConta().getConsumos().get(j).getDescricao());
						System.out.println("Quant.: " + reservas.get(i).getConta().getConsumos().get(j).getQuantidade());
						System.out.println("Valor unit.: R$" + reservas.get(i).getConta().getConsumos().get(j).getValorUnitario());
						valor_conta += reservas.get(i).getConta().getConsumos().get(j).getValorUnitario() * reservas.get(i).getConta().getConsumos().get(j).getQuantidade();
					}
					System.out.println();
					System.out.println("Total a pagar: R$ " + valor_conta);
					return;
							
				}
			}	
		}
		return;
	
		
	
	
	}

}
