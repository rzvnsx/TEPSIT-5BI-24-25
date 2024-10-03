package Multicast;

public class Produttore implements Runnable {
	
	Buffer buffer;
	
	Produttore(Buffer buf){
		buffer = buf;
	}
	
	
	public void run(){
		while(true) {
			int r = (int) ((Math.random() * 2047) - 1024);
			
			try {
				Thread.sleep(r>0?r/100*50:200);
			} catch (InterruptedException e) {}
			
			buffer.push(r);
		}
	}
}