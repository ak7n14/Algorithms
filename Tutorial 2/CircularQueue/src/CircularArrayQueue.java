import java.util.*;

public class CircularArrayQueue implements MyQueue{
	private int[] queueArray;
	private int head;
	private int tail;
	
	public CircularArrayQueue() {
		queueArray = new int[2];
		head = 0;
		tail = 0;
	}
	
	public void enqueue(int in) {
		if((tail + 1) % queueArray.length == head) {
			int[] doubleQueueArray = new int[queueArray.length * 2];
			int tempHead = head;
			for(int i = 0; i < noItems(); i++) {
				doubleQueueArray[i] = queueArray[tempHead];
				tempHead = (tempHead + 1) % queueArray.length;
			}
			tail = noItems();
			head = 0;
			queueArray = doubleQueueArray;
		}
		queueArray[tail] = in;
		tail = (tail + 1) % queueArray.length;
	}

	public int dequeue() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		int result = queueArray[head];
		head = (head + 1) % queueArray.length;
		return result;
	}

	public int noItems() {
		if(tail >= head)
			return tail - head;
		else
			return queueArray.length - head + tail;
	}

	public boolean isEmpty() {
		if(head == tail)
			return true;
		return false;
	}
	
	public int getCapacityLeft() {
		return queueArray.length - noItems() - 1;
	}
}
