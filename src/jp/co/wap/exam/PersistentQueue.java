package jp.co.wap.exam;

import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * <p>
 * 
 * @param <E>
 */
public class PersistentQueue<E> {

	private Entry<E> head, tail;
	private int size = 0;

	private static class Entry<E> {
		E element;
		Entry<E> next;

		Entry(E element, Entry<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	/**
	 * require default constructor.
	 */
	public PersistentQueue() {
		// modify this constructor if necessary,but do not remove default
		// constructor
		tail = head = new Entry<E>(null, null);
		size = 0;
	}

	private PersistentQueue(Entry<E> head, Entry<E> tail, int size) {
		// modify or remove this constructor if necessary
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	// add other constructor if necessary

	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue
	 * 
	 * <pre>
	 * e.g
	 * 	When this queue represents the queue (2,1,2,2,6) and we enqueue the value 4 into this queue.
	 *  this method returns a new queue (2,1,2,2,6,4)
	 *  and this object still represents the queue (2,1,2,2,6).
	 * </pre>
	 * 
	 * if the element e is null,throws IllegalArgumentException.
	 * 
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 */
	public PersistentQueue<E> enqueue(E e) {
		// TODO:make this method faster
		if (e == null) {
			throw new IllegalArgumentException();
		}
		if (tail.next == null) {
			tail.next = new Entry<E>(e, null);
		}
		if (tail.next.element.equals(e)) {
			return new PersistentQueue<E>(head, tail.next, size + 1);
		} else {
			Entry<E> newHead, newTail, tmp;
			int newSize = 0;
			newTail = newHead = new Entry<E>(null, null);
			tmp = head;
			while (newSize < size) {
				newTail.next = new Entry<E>(tmp.next.element, null);
				newTail = newTail.next;
				tmp = tmp.next;
				newSize++;
			}
			newTail.next = new Entry<E>(e, null);
			newTail = newTail.next;
			newSize++;
			return new PersistentQueue<E>(newHead, newTail, newSize);
		}
	}

	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue.
	 * 
	 * <pre>
	 * e.g
	 * 	When this queue represents the queue(7,1,3,3,5,1),
	 * 	this method returns a new queue (1,3,3,5,1)
	 *  and this object still represents the queue (7,1,3,3,5,1).
	 * </pre>
	 * 
	 * if this queue is empty,throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public PersistentQueue<E> dequeue() {
		// TODO:make this method faster
		if (empty()) {
			throw new NoSuchElementException();
		}
		return new PersistentQueue<E>(head.next, tail, size - 1);
	}

	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g
	 *  When this queue represents the queue(7,1,3,3,5,1),
	 *  this method returns 7 and this object still represents the queue (7,1,3,3,5,1)
	 * </pre>
	 * 
	 * if the queue is empty,throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException.
	 */
	public E peek() {
		// modify this method if needed
		if (empty()) {
			throw new NoSuchElementException();
		}
		return head.next.element;
	}

	/**
	 * Returns the number of objects in this queue. *
	 * 
	 * @return
	 */
	public int size() {
		// modify this method if necessary.
		return size;
	}

	private boolean empty() {
		if (size() > 0)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Entry<E> cur = head;
		int curSize = 0;
		while (curSize < size) {
			sb.append(cur.next.element).append(" ");
			cur = cur.next;
			curSize++;
		}
		return sb.toString();
	}
}