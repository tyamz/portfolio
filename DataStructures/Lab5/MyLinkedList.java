package Lab5;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;
	
	public MyLinkedList() {}
	public MyLinkedList(E[] objects) {
		super(objects);
	}
	
	public E getFirst() {
		if (size == 0) { return null; }
		else return head.element;
	}
	public E getLast() {
		if (size == 0) { return null; }
		else return tail.element;
	}
	public void addFirst(E e) {
		  Node<E> newNode = new Node<>(e);
		  newNode.next = head;
		  head = newNode;
		  size++;
		  if (tail == null) {
		    tail = head;
		  }
	}
	public void addLast(E e) {
		if (tail == null) {
			head = tail = new Node<>(e);
		} else {
			tail.next = new Node<>(e);
			tail = tail.next;
		}
		size++;
	}
	@Override
	public void add(int index, E e) {
		if (index == 0) { addFirst(e); }
		else if (index >= size) { addLast(e); }
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}
	public E removeFirst() {
		if (size == 0) { return null; }
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) { tail = null; }
			return temp.element;
		}
	}
	public E removeLast() {
		if(size == 0) { return null; }
		else if(size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			 Node<E> current = head;
			 for (int i = 0; i < size-2; i++) {
				 current = current.next;
			 }
			 Node<E> temp = tail;
			 tail = current;
			 tail.next = null;
			 size--;
			 return temp.element;
		}
	}
	public E remove(int index) {
		if(index < 0 || index >= size) { return null; }
		else if (index == 0) { return removeFirst(); }
		else if (index == size - 1) { return removeLast();}
		else {
			Node<E> last = head;
			for (int i = 1; i < index; i++) {
				last = last.next;
			}
			Node<E> current = last.next;
			last.next = current.next;
			size--;
			return current.element;
		}
	}
	@Override
	public void clear() {
		size = 0;
		head = tail = null;
	}
	@Override
	public boolean contains(E e) {
		Node<E> current = head;
		for(int i = 0; i < size()-1; i++) {
			if (current.element == e) {
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}
	@Override
	public E get(int index) {
		Node<E> current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.element;
	}
	@Override
	public int indexOf(E e) {
		if (this.contains(e)) {
			Node<E> current = head;
			int j = 0;
			for(int i = 0; i < size()-1; i++) {
				if (current == e) {
					j = i;
					return j;
				} else {
				current = current.next;
				}
			}
			return j;
		} else {
			return -1;
		}
	}
	@Override
	public int lastIndexOf(E e) {
		if (this.contains(e)) {
			Node<E> current = head;
			int j = 0;
			for(int i = 0; i < size()-1; i++) {
				if (current == e) {
					j = i;
				} else {
				current = current.next;
				}
			}
			return j;
		} else {
			return -1;
		}
	}
	@Override
	public E set(int index, E e) {
		Node<E> current = head.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		E old = current.element;
		Node<E> temp = new Node<>(e);
		current = temp;
		return old;
	}
	@Override
	public Iterator<E> iterator() {
		return null;
	}
}
class Node<E> {
	E element;
	Node<E> next;
	
	public Node(E element) {
		this.element = element;
	}
}