package Pizzeria;

public class Main {

	public static void main(String[] args) {
		Buffer ordini = new Buffer();
		Buffer pizzeIN = new Buffer();
		Buffer pizzeOUT = new Buffer();
		Buffer consegna = new Buffer();
		Sala sala = new Sala();
		
		int tavoli = 20;
		int camerieri = 3;
		int maxPersoneTavolo = 5;
		
		for(int i = 0; i < tavoli; i++)
			new Thread(new Tavolo(ordini,consegna,maxPersoneTavolo, i, sala)).start();
		
		int ordiniDaFare = sala.getNum();
		
		new Thread(new Pizzaiolo(pizzeIN,pizzeOUT,ordiniDaFare)).start();
		
		for(int i = 0; i < camerieri; i++) {
			new Thread(new Cameriere(sala,ordini,pizzeIN,pizzeOUT,consegna, i)).start();
		}
		
		while(!sala.isEmpty()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) { }
			System.out.println(sala.getPersone());
		}
	}

}