package LIFO;

public class Main {

	public static void main(String[] args) {
		/* Variante LIFO
		 * Modificare il codice in modo tale
		 * che i dati nel buffer siano LIFO
		 */
		
		Buffer buffer = new Buffer();
		Consumatore consumatore = new Consumatore(buffer);
		Produttore produttore = new Produttore(buffer);
		
		Thread p = new Thread(produttore);
		Thread c = new Thread(consumatore);
		
		p.start();
		c.start();
	}

}
