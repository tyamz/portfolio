package Lab6;

public class MyArrayStack<E> {
	public static final int block = 20;
	E[] mystack = (E[]) new Object[block];
	int top = 0;
	
	MyArrayStack(){}
	MyArrayStack(E[] objects) {
		for (E e: objects) {
			push(e);
		}
	}
	
	void push(E e) {
		mystack[top] = e;
		top++;
	}
	
	E pop() {
		if (isEmptyStack()) {
			return null;
		}
		E e = mystack[top];
		mystack[top] = null;
		top--;
		return e;
	}
	boolean isEmptyStack() {
		if (top <= 0) return true;
		return false;
	}
}
