package Main.java;

public class Entry {
	int key;
	Object value;
	Entry next;
	
	Entry(int key , Object value){
		this.key = key;
		this.value = value;
		next = null;
	}
	
	Entry(){
		next = null;
	}
	
	public int getKey() {return this.key;}
	public Object getValue() {return this.value;}
}
