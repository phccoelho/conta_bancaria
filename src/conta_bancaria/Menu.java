package conta_bancaria;

import conta_bancaria.model.ContaCorrente;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		
		
		//Instaciando um objeto da classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 456, 1, "Renata Negrini", 600000, 60000);
		cc1.visualizar();
		
		cc1.sacar(659000);
		cc1.visualizar();
		
		cc1.depositar(50000);
		cc1.visualizar();
		

		System.out.println(Cores.TEXT_RED_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "|====================================|");
		System.out.println("|       BANCO DO BRASIL COM Z        |");
		System.out.println("|====================================|");
		System.out.println("|                                    |");
		System.out.println("|  1-Criar Conta                     |");
		System.out.println("|  2-Listar todas as Contas          |");
		System.out.println("|  3-Busca Conta por Número          |");
		System.out.println("|  4-Atualizar Dados da Conta        |");
		System.out.println("|  5-Apagar Conta                    |");
		System.out.println("|  6-Sacar                           |");
		System.out.println("|  7-Depositar                       |");
		System.out.println("|  8-Transferir Valores entre Contas |");
		System.out.println("|  9-Sair                            |");
		System.out.println("|====================================|");
		System.out.println("|                                    |");
		System.out.println("| Entre com a opção desejada:        |");
		System.out.println("|====================================|");

	}

}
