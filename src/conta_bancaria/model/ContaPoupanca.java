package conta_bancaria.model;

public class ContaPoupanca extends Conta{
	
	private int data;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int data) {
		super(numero, agencia, tipo, titular, saldo);
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	//Verifica se a data está entre 1 e 31
	public boolean verificaData(int data) {
		if(data > 31 || data < 1) {
			return false;
		}
		return true;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Data de Aniversário: " + this.data);
	}
	
	
	
	
}
