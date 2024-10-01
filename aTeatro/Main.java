package aTeatro;

public class Main {

	public static void main(String[] args) {
	/*
	A Teatro
	Considerare uno scenario in cui in un cinema gli spettatori arrivano per comprare dei biglietti 
	per un film, il cinema è composto da 15 file ogniuna con 46 posti. Ogni spettatore prova a 
	prenotare i posti centrali, e la biglietteria gli fornisce sempre i posti più vicini.
	Definire quali sono le entità attiva e quali sono le risorse (entità passive) del sistema e creare 
	un programma che simula con la creazione di 7 Thread la prenotazione dei posti. La 
	simulazione deve prevedere che lo spettacolo può iniziare una volta passati 10 secondi e deve 
	mostrare il numero di posti disponibili rimasti nel cinema.
	La simulazione deve garantire che lo stesso posto viene venduto a due spettatori diversi e che 
	non vengono venduti più posti di quelli disponibili.
	La simulazione deve utilizzare delle stampe a video per far capire l’implementazione dello 
	scenario
	*/

		Teatro teatro = new Teatro(15, 46); // Corretto da "teatro" a "Teatro"

		Thread[] spettatori = new Thread[7];
		for (int i = 0; i < spettatori.length; i++) {
		    spettatori[i] = new Thread(new Spettatore(teatro, "Spettatore: " + (i + 1)));
		}

		// Avvio dei thread degli spettatori
		for (Thread spettatore : spettatori) {
			spettatore.start();
		}

		// Attendere 10 secondi prima di iniziare lo spettacolo
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("Lo spettacolo sta per iniziare");

		// Aspettare che tutti i thread degli spettatori abbiano terminato
		for (Thread spettatore : spettatori) {
			try {
				spettatore.join();
		    } catch (InterruptedException e) {
		    }
		}

		// Mostra la mappa dei posti e il numero di posti rimasti
		teatro.mappaPosti();
		System.out.println("Posti disponibili: " + teatro.postiavanzati());
		}
}
