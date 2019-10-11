/**
 * 
 * A class to represent a generic queue.
 * It implements GenericQueueInterface.
 * 
 * @author Sashi Raj Amatya
 * ICS 440 - 01 - The art of multiprocessor programming (Summer 2019)
 * Programming Assignement 2
 * Instructor: Ryan Hankins
 *
 * Source: ICS 240-01 (Introduction to data structure) class 
 *
 */

import java.util.NoSuchElementException;

public class Queue<T> implements GenericQueueInterface<T>{
	private GenericNode<T> front;
	private GenericNode<T> rear;
	private int manyNodes;
	
	//constructor
	public Queue(){
		this.manyNodes = 0;
		this.front = null;
		this.rear = null;
	}
		
	@Override
	public void enqueue(T item) {
		if (isEmpty()){
			//insert first item
			front = new GenericNode<T>(item,null);
			rear = front;
		}else{
			rear.addNodeAfter(item);
			rear = rear.getLink();
		}
		manyNodes++;	
	}

	@Override
	public T dequeue() {
		T answer;
		
		if (manyNodes == 0) 
			throw new NoSuchElementException("Queue Underflow");
		answer = front.getData();
		front = front.getLink();
		manyNodes--;
		if (manyNodes == 0)
			rear = null;
		return answer;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			System.exit(1);
		}
		return front.getData();
	}
	
	@Override
	public int size() {
		return this.manyNodes;
	}
	
	@Override
	public boolean isEmpty() {
		return (this.manyNodes == 0);
	}
	
	@Override
	public String toString(){
		
		String output  = "[\t";
		
		GenericNode<T> cursor = front;
		
		while (cursor != null){
			output += cursor.getData()+"\t";
			cursor = cursor.getLink();
		}
		
		output +="]";
		return output;
	}	
	

	
}
