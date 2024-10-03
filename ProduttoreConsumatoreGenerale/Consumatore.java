package Generale;

public class Consumatore implements Runnable{
	private int odd;
	private int even;
	private Buffer buf;
	
	public Consumatore(Buffer buf) {
		this.odd = this.even = 0;
		this.buf = buf;
	}
	
	public void run() {
		while(true) {
			int num = buf.pop();
			
			if(num != -1) {
				if(num % 2 == 0)
					even++;
				else
					odd++;
				System.out.println("Numero letto: " + num + " | Pari: " + even + " Dispari: " + odd);
			}
		}
	}
	
}
