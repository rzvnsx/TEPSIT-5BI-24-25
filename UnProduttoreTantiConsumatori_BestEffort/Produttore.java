package BestEffort;

public class Produttore  implements Runnable {
	
	Buffer buffer;
	
	Produttore(Buffer buf){
		buffer = buf;
	}
	
	
	public void run(){
		while(true) {
			int r = (int) ((Math.random() * 2047) - 1024);
			buffer.push(r);
		}
	}
}


