package IngressoSingolo;

public class Main {

	public static void main(String[] args) {
		/* Si va a ballare! Ingresso Singolo
		 * Creare un programma che simula una persona che entra ed esce da una discoteca
		 * ogni Thread rappresenta una persona che entra in discoteca, resta per un tempo
		 * casuale, poi esce e rientra all'infinito. 
		 * Il sistema deve stampare ogni secondo il numero di persone all'interno della
		 * discoteca.
		 */
		
		lista listaDisco = new lista();
		discoteca disco = new discoteca(listaDisco);
		
		long delta = System.currentTimeMillis();
		
		while(true) {
			long currentTime = System.currentTimeMillis();
			if(currentTime - delta >= 1000) {
				delta = System.currentTimeMillis();
				System.out.println(disco.getPersone());
			}
			
			disco.entra(new Persona(listaDisco));
			
		}
	}

}