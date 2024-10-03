package Generale;


public class Consumatore implements Runnable {
	
	Buffer buffer;
	int negnum,n,posnum,posnumcounter;
	
	Consumatore(Buffer buf){
		buffer = buf;
		negnum = 0;
	}
	
	public void run(){
		while(true) {
			
			n = buffer.pop();
				
			if (n<=0) negnum++;
			
			else {
				posnumcounter += n;
				posnum++;
			}
			
			if(posnum == 5) {
				posnum = 0;
				posnumcounter /= 5;
			}
			
			System.out.println("numeri negativi : " + negnum +
					           " | media valori pos : " + posnumcounter );
			
			posnum = posnum ==5 ? 0:posnum;
			
		}
	}
}