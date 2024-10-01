package StatoThread;

public class Run implements Runnable {
    private int t;
    private Thread[] Thr;
    private Numbers[] nums;

    Run(int t, Thread[] TH, Numbers[] nums) {
        this.t = t;
        this.Thr = TH;
        this.nums = nums;
    }

    public void run() {
        boolean alldead;
        while (!Thread.currentThread().isInterrupted()) {
            alldead = true;
            for (short i = 0; i < t; i++) {
                if (Thr[i].isAlive()) {
                    System.out.println(Thr[i].getId() + " STILL ALIVE : " + nums[i].getCounter());
                    alldead = false;
                } else {
                    System.out.println(Thr[i].getId() + " COMPLETATO");
                }
            }
            if (alldead) {
                break;  // Esce dal ciclo se tutti i thread sono terminati
            }
            try {
                Thread.sleep(1000);  // Attende un secondo tra le stampe
            } catch (InterruptedException e) {
                // Uscita quando il thread principale interrompe questo thread
                Thread.currentThread().interrupt();
            }
        }
    }
}
