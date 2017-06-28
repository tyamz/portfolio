package Lab7;

import java.util.Arrays;

public class SortingExercise {
	static void RecursiveSelectionSort(int[] a) {
		recursiveSelSort(a, 0, a.length);
	}
	
	static void recursiveInsertionSort(int[] list) {
		int[] sorted = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			int min = list[0];
			if(list[i] < min) {
				min = list[i];
			}
		}
	}
	
	private static void recursiveSelSort(int[] list, int low, int high) {
			if (low < high) {
				int indexOfMin = low;
				int min = list[low];
				for (int i = low+1; i<=high; i++) {
					if (list[i] < min) {
						min=list[i];
						indexOfMin = i;
					}
				}
				list[indexOfMin] = list[low];
				list[low] = min;
				recursiveSelSort(list, low+1, high);
			}
	}
	
	static void recursiveQuickSort(int[] a, int left, int right) {
		 if(left < right)
	        {
	            int pivot = partition(a, left, right);
	 
	            if(pivot > 1)
	                recursiveQuickSort(a, left, pivot - 1);
	 
	            if(pivot + 1 < right)
	                recursiveQuickSort(a, pivot + 1, right);
	        }
	}
	
	private static int partition(int[] a, int start, int stop) {
		int up = start, down = stop - 1, part = a[stop]; 
		if (stop <= start) return start; 
		while (true) { 
			while (isLess(a[up], part)) up++; 
			while (isLess(part, a[down]) && (up < down)) down--; 
			if (up >= down) break; 
			swap(a, a[up], a[down]); 
			up++; down--; 
		} 
		swap(a, a[up], a[stop]); 
		return up;
	}

	private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

	private static boolean isLess(int i, int part) {
		if (i < part) {
			return true;
		}
		return false;
	}
	
	static void nonRecursiveSelSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            swap(a, i, index);
        }
		
	}
	
	static void nonRecursiveInsSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int currentElement = list[i];
			int k;
			for (k = i-1; k >= 0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
			}
			list[k+1] = currentElement;
		}
	}
	static void nonRecursiveQuickSort(int[] a, int start, int stop) {
		int i, s = 0;
		int[] stack = new int[stop*2]; 
		stack[s++] = start; stack[s++] = stop; 
		while ( s > 0) { 
			stop = stack[--s]; 
			start = stack[--s]; 
			if (start >= stop) continue; 
			i = partition(a, start, stop); 
			if (i - start > stop - i) { 
				stack[s++] = start; stack[s++] = i - 1; 
				stack[s++] = i + 1; stack[s++] = stop; 
			} else { 
				stack[s++] = i + 1; stack[s++] = stop; 
				stack[s++] = start; stack[s++] = i - 1; 
			} } 
	}
	static void nonRecursiveBubbleSort(int[] a) {
	    for (int j = 0; j < a.length; j++) {
	        for (int i = 0; i < a.length; i++) {
	            int current = a[i];
	            if (i + 1 < a.length) {
	                if (current > a[i + 1]) {
	                    a[i] = a[i + 1];
	                    a[i + 1] = current;
	                }
	            }
	        }
	    }
	}
	static void recursiveBubbleSort(int[] a, int i, int j) {
		if( i  > 0 )
			if( j < i) {
				if( a[j] > a[j+1] ) { 
					swap(a,j,j+1);
				}
				recursiveBubbleSort(a,i,j+1);
			} else {
				recursiveBubbleSort(a,i-1,0);
			}
	}
	static void nonRecursiveMergeSort() {
		
	}
	static void recursiveMergeSort() {
		
	}
	public static void testCaseSelection(int[] a) {
		int[] b = Arrays.copyOf(a, a.length);
		long current = System.nanoTime();
		RecursiveSelectionSort(b);
		current = System.nanoTime() - current;
		System.out.println("The recursive execution time is " + current);
		for (int i : b) System.out.print(i+":");
		System.out.println();
		int[] c = Arrays.copyOf(a, a.length);
		current = System.nanoTime();
		nonRecursiveSelSort(c);
		current = System.nanoTime() - current;
		System.out.println("The non-recursive execution time is " + current);
		for (int i : c) System.out.print(i+":");
	}	
	public static void main(String... strings) {
		int[] a = {12, 3, 5, -4, 7, 20, 54, 6};
		testCaseSelection(a);
		int[] c = new int[5000];
		for (int i = 0; i < 5000; i++) {
			c[i] = (int) (Math.random()*5000);
		}
		testCaseSelection(c);
	}
}
