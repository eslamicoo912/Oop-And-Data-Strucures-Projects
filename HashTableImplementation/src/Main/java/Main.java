package Main.java;

public class Main {

	public static void main(String[] args) {
		HashTableArray<String> hash = new HashTableArray<String>(10);
		hash.put(11, "Eslam");
		hash.put(17, "esraa");
		hash.put(21, "Ahmed");
		hash.put(27, "Ali");
		System.out.print(hash.get(27));
	}

}
