package Sept6;

/**
 * Homework #1 - Thomas Yamakaitis
 * September 6, 2016
 * Dr. Li - CPS 2232*01 ~ Data Structures
 * Kean University
 * 
 * The purpose of this program is to review the ArrayList data structure
 * and attempt different sort algorithms to conclude a final result.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListReview {
	public static ArrayList<ArrayReview> alist = new ArrayList<>();
	void sortSelection(int[] input) {
		for (int i = 0; i < input.length; i++) {
				int min = pickMin(input, i);
				if (input[min] < input[i]) {
					swap(input, i, min);
				}
		}
	}
	int pickMin(int[] input, int i) {
		int min = input[i];
		int mIndex = i;
		for (int x = i; x < input.length; x++) {
			if(input[x] < min) {
				min = input[x];
				mIndex = x;
			}
		}
		return mIndex;
	}
	void swap(int[] input, int i, int min) {
		int tmp = input[i];
		input[i] = input[min];
		input[min] = tmp;
	}
	void sortInsertion(int[] input) {
	}
	static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		int i = 0; int j = 0;
		ArrayList<Integer> merged = new ArrayList<Integer>();
		while (i < l1.size() && j < l2.size()) {
			if(l1.get(i) < l2.get(j)) {
				merged.add(l1.get(i++));
			} else merged.add(l2.get(j++));
		}
		while(i < l1.size()) {
			merged.add(l1.get(i++));
		}
		while(j < l2.size()) {
			merged.add(l2.get(j++));
		}
		return merged;
	}
	static ArrayList<Integer> sortMerge(ArrayList<Integer> arrl) {
		int size = arrl.size();
		if (size > 2) {
			ArrayList<Integer> left = new ArrayList<Integer>(arrl.subList(0, size/2));
			ArrayList<Integer> right = new ArrayList<Integer>(arrl.subList(size/2, size));
			left = sortMerge(left);
			right = sortMerge(right);
			return merge(left, right);
		} else {
			if(size == 2 && arrl.get(1)<arrl.get(0)){
					int tmp = arrl.get(0);
					arrl.set(0, arrl.get(1));
					arrl.set(1, tmp);
			}
			return arrl;
		}
	}
	public static void main(String...strings) {
		int[] arr1 = {10, 6, 42, 34, 8, 13};
		int[] arr2 = {22, 11, 7, 43};
		Integer[] arr3 = {1, -100, 16, 44,-5, -10};
		
		ArrayReview ar = new ArrayReview(arr1);
		ArrayListReview.alist.add(ar);
		ar = new ArrayReview(arr2);
		ArrayListReview.alist.add(ar);
		
		for(ArrayReview a: ArrayListReview.alist) {
			for(int i : a.getArr()) System.out.print(i + ";");
			System.out.println();
		}
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr3));
		list = sortMerge(list);
		System.out.println(list);
	}
}
