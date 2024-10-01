package IngressoGruppi;

public class Discoteca {
	private Lista listaDiscoteca;
	
	public Discoteca(Lista listaDiscoteca) {
		this.listaDiscoteca = listaDiscoteca;
	}
	
	public void entra(Gruppo i) {
		Thread d = new Thread(i);
		d.start();
	}
	
	public int getPersone() {
		return listaDiscoteca.get();
	}
}