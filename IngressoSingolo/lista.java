package IngressoSingolo;

public class lista{
	private int numeroInseriti;
	
	public lista(){
		this.numeroInseriti = 0;
	}
	
	public synchronized void inc() {
		numeroInseriti++;
	}
	
	public synchronized void dec() {
		numeroInseriti--;
	}
	
	public synchronized int get() {
		return numeroInseriti;
	}
	
	
	
}