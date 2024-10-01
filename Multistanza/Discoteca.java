package Multistanza;

public class Discoteca {
	private Lista listaDiscoteca;
	private int numeroPiste;
	
	public Discoteca(Lista listaDiscoteca) {
		this.listaDiscoteca = listaDiscoteca;
		this.numeroPiste = listaDiscoteca.getLunghezza();
	}
	
	public void entra(Gruppo i) {
		Thread th = new Thread(i);
		th.start();
	}
	
	public void getPersone() {
		for(int i = 0; i < numeroPiste; i++)
			System.out.print("Lista " + i + " -> " + listaDiscoteca.get(i) + " ");
		System.out.println();
	}
}