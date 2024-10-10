package Pizzeria;

public class Pizzaiolo implements Runnable {

	private Buffer pizzeIN;
	private Buffer pizzeOUT;
	private int ordini;
	
	public Pizzaiolo(Buffer pizzeIN, Buffer pizzeOUT, int ordini) {
		this.pizzeIN = pizzeIN;
		this.pizzeOUT = pizzeOUT;
		this.ordini = ordini;
	}
	
	@Override
	public void run() {
		while(ordini != 20) {
			pizzeOUT.push(pizzeIN.pop());
			ordini++;
			System.out.println("Ordine Completato ->" + ordini);
		}
	}

}