package Sept19;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTime {
	public static void main(String...strings) {
		Integer[] arr = {42,7,17,20,50,19,38,25,36,16,23};
		LinkedList<Integer> lli = new LinkedList<Integer>(Arrays.asList(arr));
		long current = System.nanoTime();
		for(int i = 0; i < 100; i++) {
			lli.add(5, 300);
			lli.remove(5);
			System.out.println(lli);
		}
		for(int i = lli.size()-1; i > -1; i--) {
			System.out.print(lli.get(i)+";");
		}
		System.out.println();
		System.out.println(System.nanoTime()-current);
	}
}
