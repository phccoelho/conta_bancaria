package conta_bancaria;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		//Criar(istanciar) Objeto da Classe Conta
		Conta c1 = new Conta(1, 123, 1, "Aylla", 500000);
		
		c1.visualizar();
		//Sacar
		c1.sacar(100);
		c1.visualizar();
		//Depositar
		c1.depositar(1000);
		c1.visualizar();
		
		//Alterar a propriedade títular
		c1.setTitular("Aylla Scaglia");
		c1.visualizar();
		

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
