package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	//Criar a Collection Array List
	private ArrayList<Conta> ListaContas = new ArrayList<Conta>();
	
	//Variável para Controlar os números das Contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
	}

	@Override
	public void listarTodas() {
		for(var conta: ListaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		ListaContas.add(conta);
		System.out.println("A Conta foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		
		
	}

	@Override
	public void deletar(int numero) {
		
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		
	}
	//Métodos Auxiliares
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : ListaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
}
