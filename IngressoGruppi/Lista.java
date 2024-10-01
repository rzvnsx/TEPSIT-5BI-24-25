package IngressoGruppi;

public class Lista{
	private int numeroInseriti;
	
	public Lista(){
		this.numeroInseriti = 0;
	}
	
	public synchronized void inc(int N) {
		numeroInseriti += N;
	}
	
	public synchronized void dec(int N) {
		numeroInseriti -= N;
	}
	
	public synchronized int get() {
		return numeroInseriti;
	}
	
	
	
}