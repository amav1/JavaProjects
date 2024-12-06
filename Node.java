
public class Node {
	
	private String item;
	private Node Next;
		
	Node(String item){
		this.item = item;
		this.Next = null;
	}
	Node(String item, Node Next){
		this.item = item;
		this.Next = Next;
	}
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public Node getNext() {
		return Next;
	}
	public void setNext(Node Next) {
		this.Next = Next;
	}
	
	public boolean hasNext() { 
		if (Next != null) {
			return true;
		}else {
			return false; 
		}
	}
}