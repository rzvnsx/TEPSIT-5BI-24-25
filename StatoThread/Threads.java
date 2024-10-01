package StatoThread;

public class Threads implements Runnable {
    Numbers n;

    public Threads(Numbers n) {
        this.n = n;
    }

    public void run() {
        int x = n.getX();  // Numero massimo fino al quale contare
        while (n.getCounter() < x) {
            n.increaseCounter();
            try {
                Thread.sleep(120);  // Pausa di 120ms tra gli incrementi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
