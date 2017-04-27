package Lab5;

public class TestMyList {
	public static void main(String...strings) {
		MyArrayList<String> mals = new MyArrayList<>(new String[]{"NY", "Union", "Dallas"});
		System.out.println(mals);
		mals.remove("NY");
		System.out.println(mals);
		System.out.println(mals.contains("Union"));
		
		MyLinkedList<String> mlls = new MyLinkedList<>(new String[]{"NY", "Union", "Dallas"});
		
		System.out.println(mlls.size());
	}
}
