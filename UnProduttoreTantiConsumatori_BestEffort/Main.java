package BestEffort;

public class Main {

	public static void main(String[] args) {
		/* Best Effort
		 * Modificare il programma in modo
		 * tale che il produttore non sia MAI
		 * messo in attesa, acettando la 
		 * possibilità di perdere dei dati
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