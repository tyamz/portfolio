package CPS_3962;

import java.util.LinkedList;

public class A {
	int a;
	
	A() {}
	
	A(int x) {
		this.a = x;
	}
	
	public static void main(String[] args) {
		LinkedList<A> list = new LinkedList<A>();
		
		for(int i = 0; i < 10; i++) {
			A listItem = new A();
			list.add(listItem);
		}
	}
}
