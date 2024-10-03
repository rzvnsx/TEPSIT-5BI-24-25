package Priorità;

public class Main {

	public static void main(String[] args) {
		/* Variante priorità
		 * Modifica il codice in modo tale 
		 * che i numeri PRIMI sono i primi
		 * ad essere estratti dal buffer,
		 * stampare per ogni valore estratto
		 * dal buffer il suo tempo di 
		 * permanenza all'interno del buffer
		 */
		
		Buffer buffer = new Buffer();
		Produttore produttore = new Produttore(buffer);
		Consumatore consumatore = new Consumatore(buffer);
		
		Thread p = new Thread(produttore);
		Thread c = new Thread(consumatore);
		
		p.start();
		try {
			Thread.sleep(100); 
		}catch(InterruptedException e) {}
		c.start();
	}

}
