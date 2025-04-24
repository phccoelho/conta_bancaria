package conta_bancaria;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

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
