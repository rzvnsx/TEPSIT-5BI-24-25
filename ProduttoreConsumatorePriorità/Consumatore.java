package Priorità;

public class Consumatore implements Runnable{
	private int even;
	private int odd;
	private Buffer buf;
	
	public Consumatore(Buffer buf) {
		this.odd = this.even = 0;
		this.buf = buf;
	}
	
	public void run() {
		while(true) {
			int[] returnedNumber = buf.pop();
			int num = returnedNumber[0];
			
			if(num != -1) {
				if(num % 2 == 0)
					even++;
				else
					odd++;
				System.out.println("Numero letto: " + num + " nel buffer da: " + returnedNumber[1]); 
				System.out.println("Pari: " + even + " Dispari: " + odd);
			}
		}
	}
}
