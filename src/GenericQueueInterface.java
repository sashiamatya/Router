

/**
 * 
 * An interface for the generic queue
 * 
 * @author Sashi Raj Amatya
 * ICS 440 - 01 - The art of multiprocessor programming (Summer 2019)
 * Programming Assignement 2
 * Instructor: Ryan Hankins
 *
 * Source: ICS 240-01 (Introduction to data structure)
 * @param <E>
 */

public interface GenericQueueInterface<T>{
	/**
	 * Accessor method to determine the number of items in this queue.
	 * @return the number of items in this queue
	 * **/ 
	public int size();
	
	/**adds a new item to this queue. 
	 *  @param item - the item to be inserted into this queue 
	 **/ 
	public void enqueue(T item);
	
	/** Get the front item and remove it from this queue.
	 * @return The return value is the front item of this queue 
	 **/
	public T dequeue();
	
	
	
	/**Determine whether this queue is empty.
	 * @return true if this queue is empty and false otherwise. 
	 */
	public boolean isEmpty();
	
	/** convert the queue to a printable string
	 * @return	a string representing the queue
	 **/
	public String toString();
	
	public T peek();
	
	
}
