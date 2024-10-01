package aTeatro;

public class Teatro {
    private boolean[][] posti;
    private int file;
    private int postiPerFila;

    // Corretto il costruttore da "teatro" a "Teatro"
    public Teatro(int file, int postiPerFila) {
        this.file = file;
        this.postiPerFila = postiPerFila;
        posti = new boolean[file][postiPerFila];
        // Inizializza tutti i posti come disponibili (true)
        for (int i = 0; i < file; i++) {
            for (int j = 0; j < postiPerFila; j++) {
                posti[i][j] = true;
            }
        }
    }

    // Conta i posti disponibili
    public int postiavanzati() {
        int postiDisponibili = 0;
        for (int i = 0; i < file; i++) {
            for (int j = 0; j < postiPerFila; j++) {
                if (posti[i][j]) {
                    postiDisponibili++;
                }
            }
        }
        return postiDisponibili;
    }

    // Prenotazione sincronizzata per evitare conflitti di accesso
    public synchronized void prendiposto(String nome) {
        int filaCentro = file / 2;
        int postoCentro = postiPerFila / 2;
        // Cerca di trovare i posti centrali più vicini disponibili
        for (int jmp = 0; jmp <= Math.max(filaCentro, postoCentro); jmp++) {
            for (int i = Math.max(0, filaCentro - jmp); i <= Math.min(file - 1, filaCentro + jmp); i++) {
                for (int j = Math.max(0, postoCentro - jmp); j <= Math.min(postiPerFila - 1, postoCentro + jmp); j++) {
                    if (posti[i][j]) {
                        posti[i][j] = false;
                        System.out.println(nome + " Ha prenotato il posto: Fila " + (i + 1) + ", Posto " + (j + 1));
                        return;
                    }
                }
            }
        }
    }

    // Stampa la mappa dei posti (O per disponibili, X per occupati)
    public void mappaPosti() {
        for (int i = 0; i < file; i++) {
            for (int j = 0; j < postiPerFila; j++) {
                if (posti[i][j]) {
                    System.out.print("O "); // Posto disponibile
                } else {
                    System.out.print("X "); // Posto occupato
                }
            }
            System.out.println();
        }
    }
}
