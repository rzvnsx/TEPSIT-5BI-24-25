package IngressoSingolo;

public class Persona implements Runnable{
	int timer;
	lista listaDiscoteca;

	public Persona(lista listaDiscoteca) {
		this.timer = (int)((Math.random() * (1000 - 100)) + 100);
		this.listaDiscoteca = listaDiscoteca;
	}
	
	public void run() {
		listaDiscoteca.inc();
		
		try {
			Thread.sleep(timer);
		} catch (InterruptedException e) { }
		
		listaDiscoteca.dec();
	}
}


