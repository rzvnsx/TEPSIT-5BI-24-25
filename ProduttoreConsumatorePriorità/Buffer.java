package Priorità;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Buffer {
	private LinkedList<Integer> buf;
	private LinkedList<Integer> primeBuf;
	
	private LinkedList<Integer> bufTime;
	private LinkedList<Integer> primeBufTime;
	
	public Buffer() {
		this.buf =  new LinkedList<Integer>();
		this.primeBuf = new LinkedList<Integer>();
		this.bufTime =  new LinkedList<Integer>();
		this.primeBufTime = new LinkedList<Integer>();
	}
	
	private boolean isPrime(int number) {
		if(number <= 1)
			return false;
		for(int i = 2; i < number; i++) {
			if(number % i == 0)
				return false;
		}
		
		return true;
	}
	
	public synchronized void push(int number) {
		if(isPrime(number)) {
			primeBuf.add(number);
			primeBufTime.add((int)System.currentTimeMillis());
		}else {
			buf.add(number);
			bufTime.add((int)System.currentTimeMillis());
		}
			
	}
	
	public synchronized int[] pop() {
		int[] returnNumber = new int[2];
		
		int num = -1;
		int time = -1;
		try {
			num = primeBuf.pop();
			time = primeBufTime.pop();
		}catch(NoSuchElementException e) { 
			try {
				num = buf.pop();
				time = bufTime.pop();
			}catch(NoSuchElementException ee) { }
		}
		
		returnNumber[0] = num;
		returnNumber[1] = (int)System.currentTimeMillis() - time;
		
		return returnNumber;
	}
}