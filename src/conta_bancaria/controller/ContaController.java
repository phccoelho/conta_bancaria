package conta_bancaria.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public void listarPorTitular(String titular) {
		
		List<Conta> listaTitulares = ListaContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		
		if(listaTitulares.isEmpty())
			System.out.printf("\nNenhuma conta foi encontrada com base no critério: %s" , titular);
		
		for(var conta: listaTitulares)
			conta.visualizar();
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
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		Optional <Conta >conta = buscarNaCollection(numero);
				
		if(conta.isPresent()) {
			if(conta.get().sacar(valor) ==  true)
				System.out.printf("\nO saque no valor de %s, foi efetuado com sucesso na conta número %d!",nfMoeda.format(valor), numero);
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
				
	}

	@Override
	public void depositar(int numero, float valor) {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		Optional <Conta >conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf("\nO Depósito no valor de %s, foi efetuado com sucesso na conta número %d!",nfMoeda.format(valor), numero);
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
				
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		Optional <Conta >contaOrigem = buscarNaCollection(numeroOrigem);
		Optional <Conta >contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem.isPresent() && contaDestino.isPresent()) {
			if(contaOrigem.get().sacar(valor) ==  true) {
				contaDestino.get().depositar(valor);
				System.out.println("\nA transferência no valor de " + nfMoeda.format(valor) +  " da Conta " + numeroOrigem + " para a conta "+ numeroDestino +" foi efetuada com sucesso! ");
			}
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
				
		
		
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
