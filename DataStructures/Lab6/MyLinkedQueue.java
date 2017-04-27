package Lab6;

public class MyLinkedQueue<E> {
	E element;
	QueueNode<E> head;
	QueueNode<E> tail;
	int size;
	
	MyLinkedQueue() {}
	MyLinkedQueue(E[] objects){
		for (E e: objects) {
			offer(e);
			size++;
		}
	}
	
	public void offer(E e) {
		QueueNode<E> temp = new QueueNode<>(e);
		if(this.isEmpty()) {
			head = temp;
			tail = temp;
			size++;
		} else {
			temp.previous = tail;
			tail = temp;
			size++;
		}
	}
	public E poll() {
		if (this.isEmpty()) { return null; }
		QueueNode<E> temp = head;
		head = head.next;
		return temp.element;
	}
	public E peek() {
		if(this.isEmpty()) { return null; }
		return head.element;
	}
	public boolean isEmpty() {
		if(size < 1) { return true; }
		return false;
	}
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;
		QueueNode<E> previous;
		
		QueueNode() {}
		QueueNode(E element) {
			this.element = element;
		}
		QueueNode(E e, QueueNode<E> ptr) {
			this.element = e;
			this.next = ptr;
		}
		public String toString() {
			return element.toString();
		}
	}
}
