package Sept19;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTime {
	public static int fibonacci(int n) {
		if (n <= 1) { return n; }
        else { return fibonacci(n-1) + fibonacci(n-2); }
	}
	public static <E> boolean isPalindrome(Collection<E> c) {
		List<E> tmp = new LinkedList<E>(c);
		Collections.reverse((List<E>) c);
		if(tmp.equals(c)) { return true; } else { return false; }
	}
	public static void main(String...strings) {
		Integer[] arr = {42,7,17,20,50,19,38,25,36,16,23,49,48,47,46,45,44,43,42,41,40};
		PriorityQueue<Integer> lli = new PriorityQueue<Integer>(Arrays.asList(arr));
		long current = System.nanoTime();
		for (int i = 0; i < 20; i++) {
			lli.offer(300);
			lli.poll();
			System.out.println(lli);
			// reverse traversal
			LinkedList<Integer> dq = new LinkedList<Integer>(Arrays.asList(arr));
			// Deque<Integer> dq = new Deque<Integer>();
			while (!dq.isEmpty()) {
				System.out.print(dq.getLast()+";");
				dq.removeLast();
			}
		}
		System.out.println();
		System.out.println(System.nanoTime() - current);
		if (PriorityQueueTime.fibonacci(3) == 2) { System.out.println("Successful 1!"); }
		Integer[] arr2 = {1,3,1};
		LinkedList<Integer> ll2 = new LinkedList<Integer>(Arrays.asList(arr2));
		if(isPalindrome(ll2)) { System.out.println("Successful 2!"); }
	}
}
