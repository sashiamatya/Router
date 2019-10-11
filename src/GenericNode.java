/**
 * 
 * A class to represent a node of the linked list
 * 
 * @author Sashi Raj Amatya
 * ICS 440 - 01 - The art of multiprocessor programming (Summer 2019)
 * Programming Assignement 2
 * Instructor: Ryan Hankins
 *
 * Source: ICS 240-01 (Introduction to data structures)
 */
public class GenericNode<T> {	
	private T data;
	private GenericNode<T> link;	
	
	public GenericNode(T data, GenericNode<T> link) {		
		this.data = data;
		this.link = link;
	}
	
	public T getData() {
		return this.data; 
	}
	
	public GenericNode<T> getLink() {
		return this.link;
	}
	
	public void setData(T element) {
		this.data = element; 
	}
	
	public void setLink(GenericNode<T> link) {
		this.link = link; 
	}
	
	public void addNodeAfter(T element) {
		this.link = new GenericNode<T> (element, this.link);
	}
	
	public void removeNodeAfter() {		
		this.link = this.link.link;
	}	
}
