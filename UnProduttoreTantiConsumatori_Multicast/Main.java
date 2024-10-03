package Multicast;

public class Main {

	public static void main(String[] args) {
		/* Multicast
		 * Buffer modificato in modo da
		 * garantire che ogni valore
		 * prodotto arrivi a TUTTI i
		 * Consumatori
		 */
		
		int C = 7;
		
		Buffer buf = new Buffer(C);
		
		Thread thr[] = new Thread[C];
		
		for(int i = 0; i < C; i++) {
			
			thr[i] = new Thread(new Consumatore(buf,i));
			
			thr[i].start();
			
		}
		
		Thread tmp = new Thread(new Produttore(buf));
		
		tmp.start();

	}

}

