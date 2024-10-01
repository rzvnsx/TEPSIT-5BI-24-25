package IngressoGruppi;

public class Gruppo implements Runnable{
	private int timer;
	private int persone;
	private Lista listaDiscoteca;
	
	public Gruppo(int limitePersone, Lista listaDiscoteca) {
		this.persone = (int)((Math.random() * (limitePersone - 2)) + 2);
		this.listaDiscoteca = listaDiscoteca;
		this.timer = (int)((Math.random() * (1000 - 100)) + 100);
	}
	public void run() {
		listaDiscoteca.inc(persone);
		
		try {
			Thread.sleep(timer);
		} catch (InterruptedException e) { }
		
		listaDiscoteca.dec(persone);
	}
	
}