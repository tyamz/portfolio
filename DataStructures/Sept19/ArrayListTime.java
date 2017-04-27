package Sept19;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTime {
	public static void main(String...strings) {
		Integer[] arr = {42,7,17,20,50,19,38,25,36,16,23};
		ArrayList<Integer> ali = new ArrayList<Integer>(Arrays.asList(arr));
		long current = System.nanoTime();
		ali.add(5, 300);
		ali.remove(5);
		System.out.println(ali);
		System.out.println(System.nanoTime()-current);
	}
}
