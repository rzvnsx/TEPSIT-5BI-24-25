package IngressoSingolo;

public class discoteca{
	private lista listaDiscoteca;
	
	public discoteca(lista listaDiscoteca) {
		this.listaDiscoteca = listaDiscoteca;
	}
	
	public void entra(Persona i) {
		Thread d = new Thread(i);
		d.start();
	}
	
	public int getPersone() {
		return listaDiscoteca.get();
	}
}