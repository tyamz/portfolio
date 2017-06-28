package Lab6;

import java.util.NoSuchElementException;

public class MyLinkedStack<E> {
	E element;
	StackNode<E> stackTop;
	
	MyLinkedStack(){}
	MyLinkedStack(E[] objects){
		for (E e: objects) {
			push(e);
		}
	}
	
	public E pop() throws NoSuchElementException {
		if (this.isEmptyStack()) throw new NoSuchElementException();
		StackNode<E> tmp = stackTop;
		stackTop = stackTop.next;
		return tmp.element;
	}
	
	private class StackNode<E> {
		E element = null;
		StackNode<E> next = null;
		StackNode() {}
		StackNode(E e) {element = e;}
		StackNode(E e, StackNode<E> ptr) {
			element = e;
			next = ptr;
		}
		public String toString() {
			return element.toString();
		}
	}

	public void push(E e) {
		StackNode<E> tmp = stackTop;
		StackNode<E> current = new StackNode<E>(e);
		stackTop = current;
		stackTop.next = tmp;
	}

	public boolean isEmptyStack() {
		if (stackTop == null) {
			return true;
		}
		return false;
	}
}
