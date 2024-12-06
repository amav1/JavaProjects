//Adriana Mavila CS 210

public class LinkedBasedList implements ListADT {
	private int size; 
	private Node head; 
	
	public boolean add(int index, String s) {
	    if (index < 0 || index > size) {
	        throw new IndexOutOfBoundsException("Index is invalid: " + index);
	    } //exception if index is bigger than list size or negative
	    
	    Node newNode = new Node(s);

	    if (index == 0) { 
	        newNode.setNext(head); //sets next pointer to head, the first node in list
	        head = newNode; //instantiates head with newNode, making newNode the first in the list 
	    } else {
	        Node current = head;
	        for (int i = 0; i < index - 1; i++) { //iterates through list from head
	            current = current.getNext(); //updates value for each step/index in the list and retrieves next node until 1 
	        }
	        newNode.setNext(current.getNext());  //links the newNode to the next node (for the whole list)
	        current.setNext(newNode); //inserts newNode into list, links current to newNode
	    }
	    size++; 
        return true;
	}

	    public String remove(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index is invalid: " + index);
	        }

	        String removed;

	        if (index == 0) {
	            removed = head.getItem(); //
	            head = head.getNext();
	        } else {
	            Node current = head;
	            for (int i = 0; i < index - 1; i++) {
	                current = current.getNext();
	            }
	            removed = current.getNext().getItem(); //sets removed to item at specified index
	            current.setNext(current.getNext().getNext()); //removes node at that index
	        }

	        size--; //reduces size of list for every iteration
	        return removed; 
	    }
	
	public void clear() {
		head = null;
		size = 0;
	}
	
	public String print(String sep) {
	    String result = ""; //to separate the items in list by an empty string
	    Node current = head; //sets current node to first node of list 

	    
	    while (current != null) {
	        result += current.getItem();  //adds item of current node to empty string if node is not empty

	       
	        current = current.getNext(); //looks at next node
	        if (current != null) { //if node after current is not empty
	            result += sep; //method to separate each node
	        }
	    }

	    return result; 
	}
	

    public String getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getItem(); 
    }
	
	public int size(){
		return size;
	}
}
