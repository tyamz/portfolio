package Sept6;
/**
 * Thomas Yamakaitis
 * Homework #1
 * Sept. 6, 2016
 * CPS 2232*01 ~ Data Structures
 * Dr. Li
 */
import java.util.Arrays;

public class ArrayReview {
	final static int ARRLEN = 7;
	private int[] arr = new int[ARRLEN];
	
ArrayReview() {
	for (int i = 0; i < ARRLEN; i++) {
		arr[i] = (int) Math.random()*100;
	}
}
ArrayReview(int [] a) {
	arr = a;
}

void setArr(int[] a) {
	arr = a;
}

int[] getArr() {
	return arr;
}

void setKthItem (int x, int item) {
	arr[x] = item;
}

int pickMax() {
	int m = arr[0];
	for (int i = 1; i < arr.length; i++) {
		if(arr[i] > m) {
		m = arr[i];	
		}
	}
	return m;
}
int[] sort() {
	Arrays.sort(arr);
	return arr;
}
public static void main (String [] args) {
	int[] b = {7, 13, 27, 12, 8, 45, 53};
	ArrayReview myreview = new ArrayReview(b);
	int max = myreview.pickMax();
	if (max == 53) System.out.println("well done 1!");
	else System.out.println("Failed, try again!");
	
	myreview.setKthItem(3,100);
	max = myreview.pickMax();
	if (max == 100) System.out.println("well done 2!");
	else System.out.println("Failed, try again!");
	
	b = myreview.sort();
	if (max == 100) System.out.println("well done 3!");
	else System.out.println("Failed, try again!");
	
	for (int i: myreview.getArr()) {
		System.out.println(i);
	}
}
}
