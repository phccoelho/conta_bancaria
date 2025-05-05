package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	//Criar a Collection Array List
	private ArrayList<Conta> ListaContas = new ArrayList<Conta>();
	
	//Variável para Controlar os números das Contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		Optional <Conta >conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().visualizar();
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
		Optional <Conta >buscaConta = buscarNaCollection(conta.getNumero());
				
		if(buscaConta.isPresent()) {
			ListaContas.set(ListaContas.indexOf(buscaConta.get()), conta);
			System.out.printf("\nA conta número %d foi atualizada com sucesso!", conta.getNumero());
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", conta.getNumero());
			
	}

	@Override
	public void deletar(int numero) {
		Optional <Conta >conta = buscarNaCollection(numero);
				
		if(conta.isPresent())
			if(ListaContas.remove(conta.get()) == true)
				System.out.printf("\nA conta número %d não foi excluída com sucesso!", numero);
		else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		
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
	
	public Optional<Conta> buscarNaCollection(int numero) {
		for(var conta : ListaContas) {
			if(conta.getNumero() == numero) {
				return Optional.of(conta);
			}
		}
		return Optional.empty();
	}
	
}
