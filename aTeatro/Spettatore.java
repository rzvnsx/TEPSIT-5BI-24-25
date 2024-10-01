package aTeatro;

public class Spettatore implements Runnable {
    private Teatro teatro;
    private String nome;

    // Costruttore corretto (da "spettatore" a "Spettatore")
    public Spettatore(Teatro teatro, String nome) {
        this.teatro = teatro;
        this.nome = nome;
    }

    @Override
    public void run() {
        // Prova a prenotare un posto
        teatro.prendiposto(nome);
    }
}
