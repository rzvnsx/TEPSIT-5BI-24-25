package Multicast;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	int C;
	Queue<Integer>[] multicast;
	
	
	Buffer(int C){
		 this.C = C;
		 multicast = new LinkedList[C];
	}
	
	public void push(int val) {
		for(Queue<Integer> i : multicast)
			i.add(val);
	}
	
	
	public synchronized int pop(int iD) {
		
		
		/* controllo lista vuota list.isempty() nn va
		 * 						 catch(NoSuchElementException) not found
		 */
		
		return multicast[iD].remove();
		
	}
	
}