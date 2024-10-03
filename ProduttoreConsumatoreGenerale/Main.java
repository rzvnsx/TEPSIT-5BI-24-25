package Generale;

public class Main {

	public static void main(String[] args) {
		/* Produttore e Consumatore
		Fare un programma che crea un Produttore 
		e un Consumatore con il seguente ruolo:
		- Produttore: genera all'infinito un
		numero casuale tra 100 e 1000.
		- Consumatore: deve consumare i numeri
		generati dal Produttore e ogni volta che
		li consuma stampa il numero letto e stampa
		una statistica dei numeri pari e dei numeri
		dispari letti
		
		Il programma deve garantire che i dati 
		prodotti vengano consumati in ordine FIFO
		e che non vi devono essere perdite dei dati
		prodotti dal Consumatore.	
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
