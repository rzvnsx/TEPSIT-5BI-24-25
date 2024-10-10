package Pizzeria;

public class Cameriere implements Runnable {
	
	private Sala sala;
	private Buffer ordini;
	private Buffer pizzaioloIN;
	private Buffer fornoOUT;
	private Buffer consegne;
	private int id;
	
	public Cameriere(Sala sala, Buffer ordini, Buffer pizzaioloIN, Buffer fornoOUT, Buffer consegne, int id) {
		this.sala = sala;
		this.ordini = ordini;
		this.pizzaioloIN = pizzaioloIN;
		this.fornoOUT = fornoOUT;
		this.consegne = consegne;
		this.id = id;
	}
	
	@Override
	public void run() {
		while(!sala.isEmpty()) {
			pizzaioloIN.push(ordini.pop());
			System.out.println(id + " -> Ordine mandato al pizzaiolo");
			consegne.push(fornoOUT.pop());
			System.out.println(id + " -> Ordine mandato al tavolo");
		}
	}
}