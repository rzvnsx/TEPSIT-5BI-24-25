package Pizzeria;

public class Ordine {
	
	private int id;
	private int pizze;
	
	public Ordine(int id, int pizze) {
		this.id = id;
		this.pizze = pizze;
	}
	
	public int getID() {
		return id;
	}
	
	public int getPizze() {
		return pizze;
	}
}