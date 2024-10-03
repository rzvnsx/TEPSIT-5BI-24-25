package BestEffort;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
	Queue<Integer> list;
	
	
	Buffer(){
		 list = new LinkedList<>();
	}
	
	public void push(int val) {
		try {
			list.add(val);
		}catch(IllegalStateException e) {
			System.out.print("!!perso dato");
		}
	}
	
	
	public synchronized int pop() {
		
		/* controllo lista vuota list.isempty() nn va
		 * 						 catch(NoSuchElementException) not found
		 */
		
		return list.remove();
		
	}
	
}