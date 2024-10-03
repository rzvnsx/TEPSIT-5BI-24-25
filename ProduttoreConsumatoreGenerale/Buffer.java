package Generale;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Buffer {
	private LinkedList<Integer> buf;
	
	public Buffer() {
		buf = new LinkedList<Integer>();
	}
	
	public synchronized void push(int number) {
		buf.add(number);
	}
	
	public synchronized int pop() {
		int num = -1;
		
		try {
			num = buf.pop();
		}catch(NoSuchElementException e) {}
	
		return num;
	}
}
