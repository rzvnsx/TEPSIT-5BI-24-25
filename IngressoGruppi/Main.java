package IngressoGruppi;

public class Main {

	public static void main(String[] args) {
		/*Si va a ballare!
		 *Creare un programma che simula le persone che entrano ed escono da una
		 *discoteca, ogni Thread rappresenta un gruppo di N persone che entra in
		 *discoteca, resta per un tempo casuale, poi esce e poi rientra all'
		 *infinito. 
		 * Il sistema deve stampare ogni 2s il numero di persone all'interno 
		 * della discoteca.
		 */

		Lista listaDisco = new Lista();
		Discoteca disco = new Discoteca(listaDisco);
		
		long delta = System.currentTimeMillis();
		
		while(true) {
			long currentTime = System.currentTimeMillis();
			if(currentTime - delta >= 1000) {
				delta = System.currentTimeMillis();
				System.out.println(disco.getPersone());
			}
			
			disco.entra(new Gruppo(10, listaDisco));
			
		}
	}
}