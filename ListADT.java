
public interface ListADT {
	boolean add(int index, String s);
	String remove(int index);
	void clear();
	String print(String sep);
	String getIndex(int index);
	int size();
}

