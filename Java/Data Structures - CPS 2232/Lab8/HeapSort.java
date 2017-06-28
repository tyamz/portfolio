package Lab8;

import java.util.Scanner;

public class HeapSort {
	private static int N;
	Heap<Integer> myheap = new Heap(N);
	
	HeapSort() {
		
	}
	
	HeapSort(int[] arr) {
		Integer[] newarr = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newarr[i] = arr[i];
		}
		this.myheap = new Heap(newarr);
	}
	
	/* Sort Function */
	public void sort() {
		for (int i = N; i > 0; i--) {
			// poll the top and reset the heap
			this.myheap.swap(this.myheap.getArray(), 0, i);
			N=N-1;
			this.myheap.maxheap(this.myheap.getArray(), 0);
		}
	}
	
	public static void main(String...strings) {
		Scanner scan = new Scanner( System.in );
		System.out.println("Heap Sort Test\n");
		int n, i;
		/* Accept number of elements */
		System.out.println("Enter number of integer elements");
		n = scan.nextInt();
		/* Make array of n elements */
		int arr[] = new int[n];
		/* Accept elements */
		System.out.println("\nEnter " + n + " integer elements");
		for (i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		/* Call method sort */
		HeapSort hs = new HeapSort(arr);
		hs.sort();
		Integer[] arr2 = (Integer[]) hs.myheap.getArray();
		/* Print sorted Array */
		System.out.println("\nElements after sorting");
		for (i = 0; i < n; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
	}
}
