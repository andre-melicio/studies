

public class Conta {
//privado para esta classe, não pode ser lido ou acessado por outras classes
    private double saldo;
    int agencia;
    int numero;
    Cliente titular;

    public void deposita(double valor) {
    	this.saldo += valor;
    	
    }
    
    public boolean saca(double valor){
    	if(this.saldo >= valor) {
    		this.saldo-=valor;
    		
    		return true;
    	}else {
    		return false;
    	}
    	
    	
    }
    
    public boolean transfere(double valor,Conta destino) {
    	if(this.saldo >= valor) {
    		this.saldo -= valor;
    		destino.deposita(valor);
    		
    		return true;
    	}
//    	return para o codigo neste ponto, else opcional
    		return false;
    	
    }
    
    public double getSaldo() {
    	return this.saldo;
    }
    
    
    
}
