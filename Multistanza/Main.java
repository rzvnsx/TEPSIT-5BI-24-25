package Multistanza;

public class Main {

	public static void main(String[] args) {
		/*Si va a ballare! Multi-Stanza
		 * Creare un programma che simula le persone che entrano ed escono da una
		 * discoteca, ogni Thread rappresenta un gruppo di N persone che entra in discoteca,
		 * in una delle quattro piste, resta per un tempo casuale, poi esce
		 * (poi rientra se già uscito) o cambia pista all'infinito.
		 * Il sistema deve stampare ogni 500ms il numero di persone all'interno
		 * di ogni stanza della discoteca ed il programma deve garantire
		 * un massimo numero di operazioni in parallelo
		 */
		
		Lista listaDisco = new Lista(4);
		Discoteca disco = new Discoteca(listaDisco);
		
		long delta = System.currentTimeMillis();
		
		while(true) {
			long currentTime = System.currentTimeMillis();
			if(currentTime - delta >= 500) {
				delta = System.currentTimeMillis();
				disco.getPersone();
			}
			if(currentTime - delta >= 100)
				disco.entra(new Gruppo(10, listaDisco));
		}
	}

}