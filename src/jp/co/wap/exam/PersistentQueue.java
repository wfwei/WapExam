package jp.co.wap.exam;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * <p>
 * TODO 同步问题
 * 
 * @param <E>
 */
public class PersistentQueue<E> {
	private int head, tail;
	private List<E> queue;

	/**
	 * require default constructor.
	 */
	public PersistentQueue() {
		// modify this constructor if necessary,but do not remove default
		// constructor
		queue = new LinkedList<E>();
		head = 0;
		tail = 0;
	}

	private PersistentQueue(List<E> queue, int head, int tail) {
		// modify or remove this constructor if necessary
		this.queue = queue;
		this.head = head;
		this.tail = tail;
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
		List<E> queueRef = queue;
		if (queue.size() > tail) {
			if (!queue.get(tail).equals(e)) {
				queueRef = new LinkedList<E>(queue.subList(head, tail));
				queueRef.add(e);
			}
		} else {
			queueRef.add(e);
		}
		return new PersistentQueue<E>(queueRef, head, tail + 1);
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
		return new PersistentQueue<E>(queue, head + 1, tail);
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
		return queue.get(head);
	}

	/**
	 * Returns the number of objects in this queue. *
	 * 
	 * @return
	 */
	public int size() {
		// modify this method if necessary.
		return tail - head;
	}

	private boolean empty() {
		if (size() > 0)
			return false;
		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = head; i < tail; i++) {
			sb.append(queue.get(i)).append("\t");
		}
		return sb.toString();
	}
}