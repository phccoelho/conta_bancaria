package conta_bancaria;

import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        ContaController contas = new ContaController();
        
        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite;
        
        //Dados para teste
        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);

               
        while(true) {
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
	
	        System.out.printf("\n");
	        opcao = leia.nextInt();
	        System.out.println(Cores.TEXT_RESET);
	       
	
	        if (opcao == 9) {
	            System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND +
	                    "\nPrograma finalizado!\n");
	            sobre();
	            leia.close();
	            System.exit(0);
	        }
	
	        switch (opcao) {
	            case 1:
	                System.out.println("Criar Conta\n");
	                
	                System.out.println("Digite o número da Agência: ");
	                agencia = leia.nextInt();
	                
	                System.out.println("Digite o nome do Titular: ");
	                leia.skip("\\R");
	                titular = leia.nextLine();
	                
	                System.out.println("Digite o Tipo da Conta: ( 1 - CC || 2 - CP) ");
	                tipo = leia.nextInt();
	                
	                System.out.println("Digite o saldo inicial da Conta: ");
	                saldo = leia.nextFloat();
	                
	                switch(tipo) {
		                case 1 ->{
		                			System.out.println("Digite o limite da Conta: ");
		                			limite = leia.nextFloat();
		                			contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
		                		}
		                case 2 ->{
			            			System.out.println("Digite o dia de aniversário da Conta: ");
			            			aniversario = leia.nextInt();
			            			contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
            		}
	                }
	                
	                keyPress();
	                break;
	            case 2:
	                System.out.println("Listar todas as Contas\n");
	                contas.listarTodas();
	                keyPress();
	                break;
	            case 3:
	                System.out.println("Consultar dados da Conta - por número\n");
	                
	                System.out.println("Digite o número da Conta: ");
	                numero = leia.nextInt();
	                
	                contas.procurarPorNumero(numero);
	                
	                keyPress();
	                break;
	            case 4:
	                System.out.println("Atualizar dados da Conta\n");
	                keyPress();
	                break;
	            case 5:
	                System.out.println("Apagar a Conta\n");
	                keyPress();
	                break;
	            case 6:
	                System.out.println("Saque\n");
	                keyPress();
	                break;
	            case 7:
	                System.out.println("Depósito\n");
	                keyPress();
	                break;
	            case 8:
	                System.out.println("Transferência entre Contas\n");
	                keyPress();
	                break;
	            default:
	                System.out.println("\nOpção Inválida!\n");
	                keyPress();
	                break;
	        }
	
	        
        }
}

    public static void sobre() {
        System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "==============================================");
        System.out.println("║         Projeto Desenvolvido por:          ║");
        System.out.println("║                                            ║");
        System.out.println("║   Pedro Coelho - phcoelho2004@gmail.com    ║");
        System.out.println("║      https://github.com/phccoelho          ║");
        System.out.println("==============================================");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao tentar ler o teclado");
        }
    }
}


