package br.com.menu;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.hotel.Reserva;
/**
 * 
 * @author Igor Silva & Savio Silva
 *
 */
public class PagarConta {
	private static Scanner ler;
	/**
	 * 
	 * @param reservas
	 */
	public static void pagarConta(ArrayList <Reserva> reservas) {
		ler = new Scanner(System.in);
		String resposta, numero_cartao;
		double valor_aposento, valor_total, valor_conta = 0;
		int codigo, aposento = 0, senha;
		
		System.out.println("Deseja pagar sua conta ? s\n");
		resposta = ler.nextLine();
		
		if(resposta.contentEquals("s")) {
			System.out.println("Insira seu codigo: ");
			codigo = ler.nextInt();
			for(int i = 0; i < reservas.size(); i++) {
				if(reservas.get(i).getResponsavel().getCodigo() == codigo) {
					aposento = i;
					for(int j = 0; j < reservas.get(i).getConta().getConsumos().size(); j++) {
						valor_conta += reservas.get(i).getConta().getConsumos().get(j).getValorUnitario() * reservas.get(i).getConta().getConsumos().get(j).getQuantidade();
						System.out.println();
						
					}
				}
			}
			valor_aposento = reservas.get(aposento).getAposento().getValor();
			valor_total = valor_aposento + valor_conta;
			System.out.println(" ___________________ ");
			System.out.println("|                   |");
			System.out.println("|  **NOTA FISCAL**  |");
			System.out.println("|___________________|");
			System.out.println();
			System.out.println("Cliente: " + reservas.get(aposento).getResponsavel().getNome());
			System.out.println("Portador do CPF: " + reservas.get(aposento).getResponsavel().getCPF());
			System.out.println();
			System.out.println("Valor total consumido:   R$" + valor_conta);
			System.out.println("Valor total do aposento: R$" + valor_aposento);
			System.out.println("--------------------------------------");
			System.out.println("Valor Total: R$" + valor_total);
			System.out.println();
			
			System.out.println("Insira o numero do cartao de Credito: ");
			numero_cartao = ler.next();
			
			System.out.println("Insira sua senha: ");
			senha = ler.nextInt();
			
			System.out.println("Pagamento realizado com sucesso!");
			
			//Remove o hospede
			reservas.remove(aposento);
						
		}else {
			return;
		}
	}

}
