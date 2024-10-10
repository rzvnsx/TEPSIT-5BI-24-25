package Pizzeria;

public class Tavolo implements Runnable {
	private Sala sala;
	private Buffer bufOrdini;
	private Buffer pizzePronte;
	private int persone;
	private Ordine ordine;
	private int id;
	
	public Tavolo(Buffer bufOrdini, Buffer pizzePronte, int maxPersone, int id, Sala sala) {
		this.bufOrdini = bufOrdini;
		this.pizzePronte = pizzePronte;
		persone = (int) (Math.random() * maxPersone);
		this.id = id;
		ordine = new Ordine(this.id, persone);
		this.sala = sala;
	}
	
	@Override
	public void run() {
		if(persone > 0) {
			bufOrdini.push(ordine);
			sala.inc();
			sala.add(persone);
			System.out.println("Tavolo " + id + "-> ordine eseguito");
			while(pizzePronte.popID(id) == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			}
			sala.dec();
			sala.dec(persone);
			System.out.println("Tavolo " + id + "-> pizze ricevute");
		}
	}
}