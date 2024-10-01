package StatoThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	/* Stato dei Thread
    	* Fare un programma che chiede all'utente due valori T ed N, dove T indica quanti Thread
    	* creare ed ogni Thread conta i valori (SENZA STAMPARE) da 0 fino ad X dove X è un 
    	* numero compreso tra 0 e N.
    	*/
    	
        Scanner input = new Scanner(System.in);

        System.out.println("Inserire numero di Thread (T):");
        int t = input.nextInt();

        System.out.println("Inserire numero massimo da contare (N):");
        int n = input.nextInt();

        input.close();

        Thread[] Thr = new Thread[t];
        Numbers[] nums = new Numbers[t];

        for (short i = 0; i < t; i++) {
            nums[i] = new Numbers(n);
            Threads obj = new Threads(nums[i]);
            Thr[i] = new Thread(obj);
        }

        // Avvia i thread dei contatori
        for (short i = 0; i < t; i++) {
            Thr[i].start();
        }

        // Avvia il thread che monitora lo stato dei thread
        Run obj = new Run(t, Thr, nums);
        Thread MainThread = new Thread(obj);
        MainThread.start();

        // Attendi che tutti i thread dei contatori finiscano
        try {
            for (short i = 0; i < t; i++) {
                Thr[i].join();
            }
            // Una volta che tutti i thread sono completati, interrompi il thread di monitoraggio
            MainThread.interrupt();
        } catch (InterruptedException e) {
        }

        System.out.println("Thread Completati!");
    }
}
