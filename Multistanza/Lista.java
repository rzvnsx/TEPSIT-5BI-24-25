package Multistanza;

public class Lista {
	private int elementi;
	private int liste[];
	
	public Lista(int elementi) {
		this.elementi = elementi;
		liste = new int[elementi];
	}
	
	public synchronized void inc(int numero, int indiceLista) {
		liste[indiceLista] += numero;
	}
	
	public synchronized void dec(int numero, int indiceLista) {
		liste[indiceLista] -= numero;
	}
	
	public synchronized int get(int indiceLista) {
		return liste[indiceLista];
	}
	public synchronized int getLunghezza(){
		return elementi;
	}
	
	
}