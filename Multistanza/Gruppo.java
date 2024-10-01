package Multistanza;

public class Gruppo implements Runnable{
	private int timer;
	private int persone;
	private int posizionePista;
	private int numeroPiste;
	private Lista listaDiscoteca;
	
	public Gruppo(int limitePersone, Lista listaDiscoteca) {
		this.persone = (int)((Math.random() * (limitePersone - 2)) + 2);
		this.listaDiscoteca = listaDiscoteca;
		this.timer = (int)((Math.random() * (150 - 1)) + 1);
		this.numeroPiste = listaDiscoteca.getLunghezza();
		this.posizionePista = posizioneRandom(numeroPiste-1);
	}
	
	private int posizioneRandom(int max) {
		return (int)((Math.random() * (max)));
	}
	
	public void run() {
		int volte = 0;
		do {
			listaDiscoteca.inc(persone, posizionePista);
			
			try {
				Thread.sleep(timer);
			} catch(InterruptedException e) { }
			
			listaDiscoteca.dec(persone, posizionePista);
			this.posizionePista = posizioneRandom(numeroPiste);
		}while(posizionePista != numeroPiste && volte++ < 3);	
	}
}