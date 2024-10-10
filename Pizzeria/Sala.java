package Pizzeria;

public class Sala {

	private int numeroTavoli;
	private int numeroPersoneTOT;
	
	public Sala() {
		numeroTavoli = 0;
		numeroPersoneTOT = 0;
	}
	
	public synchronized void inc() {
		numeroTavoli++;
	}
	
	public synchronized void dec() {
		numeroTavoli--;
	}
	
	public synchronized void add(int num) {
		numeroPersoneTOT += num;
	}
	
	public synchronized void dec(int num) {
		numeroPersoneTOT -= num;
	}
	
	public synchronized int getPersone() {
		return numeroPersoneTOT;
	}
	
	public synchronized int getNum() {
		return numeroTavoli;
	}
	
	public synchronized boolean isEmpty() {
		return numeroTavoli == 0? true : false;
	}
}