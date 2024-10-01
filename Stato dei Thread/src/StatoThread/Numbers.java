package StatoThread;

public class Numbers {
    private int n, x, counter;

    Numbers(int n) {
        this.n = n;
        x = (int) (Math.random() * n);  // X è il limite casuale fino al quale contare
    }

    public int getN() {
        return n;
    }

    public int getX() {
        return x;
    }

    public synchronized int increaseCounter() {
        counter = counter + 1;
        return counter;
    }

    public synchronized int getCounter() {
        return counter;
    }
}
