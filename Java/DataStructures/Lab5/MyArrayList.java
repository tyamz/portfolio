package Lab5;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {
	public static final int block = 8;
	E[] data = (E[]) new Object[block];
	
	MyArrayList() {
		data = (E[]) new Object[block];
		size = 0;
	}
	
	MyArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++) add(i, objects[i]);
		size = objects.length;
	}

	@Override
	public void add(int index, E e) {
		ensureCapacity();
		for (int i = size-1; i >= index; i--) {
			data[i+1] = data[i];
		}
		data[index] = e;
		size++;
	}
	void ensureCapacity() {
		if(size >= data.length) {
			E[] newData = (E[])(new Object[size*2+1]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	@Override
	public void clear() {
		data = (E[]) new Object[block];
		size = 0;		
	}

	@Override
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index " + index + " out of bounds");
		}
	}

	@Override
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if(e.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		for (int i = size - 1; i > -1; i--) {
			if (e.equals(data[i])) { return i; }
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		E e = data[index];
		for (int i = index; i < size; i++) {
			data[i] = data[i+1];
		}
		data[size-1] = null;
		size--;
		return e;
	}
	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E old = data[index];
		data[index] = e;
		return old;
	}
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			result.append(data[i]);
			if (i<size-1) { result.append(", "); }
		}
		return result.toString() + "]";
	}
	public void trimToSize() {
		if (size != data.length) {
			E[] newData = (E[]) (new Object[size]);
			System.arraycopy(data,0,newData,0,size);
			data = newData;
		}
	}
	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}
	private class MyArrayListIterator implements java.util.Iterator<E> {
		private int current = 0;
		public boolean hasNext() {
			return (current < size);
		}
		public E next() {
			return data[current++];
		}
		public void remove() {
			MyArrayList.this.remove(current);
		}
	}
}