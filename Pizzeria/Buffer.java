package Pizzeria;

import java.util.LinkedList;

public class Buffer {
	private LinkedList<Ordine> buf;
	
	public Buffer() {
		buf = new LinkedList<Ordine>();
	}
	
	public synchronized void push(Ordine ordine) {
		buf.add(ordine);
	}
	
	public synchronized Ordine pop() {
		while(buf.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		notify();
		
		return buf.remove();
	}
	
	public synchronized Ordine popID(int ID) {
		while(buf.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		for(Ordine item: buf) {
			if(item.getID() == ID) {
				buf.remove(item);
				notify();
				return item;
			}
		}
		notify();
		return null;
	}
	
}