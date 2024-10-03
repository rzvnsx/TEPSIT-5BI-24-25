package Generale;

public class Main {

	public static void main(String[] args) {
		/* Fare un programma che crea un 
		 * Produttore ed un valore C di
		 * Consumatore con il seguente ruolo:
		 * - Produttore: genera all'infinito
		 * un numero casuale R tra -1024 e
		 * 1023 e attende R/100*50ms se 
		 * positivo, altrimenti 200ms
		 * - Consumatore: ogni consumatore 
		 * deve contare i numeri negativi e
		 * calcolare la media degli ultimi 5
		 * valori positivi. Ogni volta che 
		 * consuma un valore stampa la 
		 * statistica aggiornata e poi aspetta 
		 * 100ms
		 */

		int C = 7;
		
		Buffer buf = new Buffer();
		
		Thread thr[] = new Thread[C];
		
		for(Thread t : thr) {
			
			t = new Thread(new Consumatore(buf));
			
			t.start();
			
		}
		
		Thread tmp = new Thread(new Produttore(buf));
		
		tmp.start();

	}

}
