package jp.co.wap.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPersistentQueue<E> {

	PersistentQueue<String> queue = new PersistentQueue<String>();

	@BeforeClass
	public static void bf() {
		System.out.println("test on PersistentQueue");
	}

	@Test
	public void testCase() {
		PersistentQueue<Double> q = new PersistentQueue<Double>();
		for (int i = 0; i < 100000; i++) {
			q = q.enqueue(Math.random());
			if (Math.random() > 0.5 && q.size() > 0)
				q = q.dequeue();
//			System.out.println(q.size());
		}
//		assertEquals("hello world ", "hello world ");
	}

	@Test
	public void testCase0() {
		PersistentQueue<String> a = queue.enqueue("hello").enqueue("world");
		PersistentQueue<String> b = a.dequeue().dequeue().enqueue("wfw");
		PersistentQueue<String> c = a.enqueue("!");
		PersistentQueue<String> d = a.enqueue("!").dequeue();
		assertEquals(a.toString(), "hello world ");
		assertEquals(b.toString(), "wfw ");
		assertEquals(c.toString(), "hello world ! ");
		assertEquals(d.toString(), "world ! ");
	}

	@Test
	public void testCase1() {
		PersistentQueue<String> q1 = new PersistentQueue<String>()
				.enqueue("aaa").enqueue("bbb").enqueue("ccc");
		PersistentQueue<String> q2 = q1.enqueue(new String("ddd"));
		Assert.assertEquals("1", "aaa", q2.peek());
		Assert.assertEquals("1", "bbb", q2.dequeue().peek());
		Assert.assertEquals("1", "ccc", q2.dequeue().dequeue().peek());
		Assert.assertEquals("1", "ddd", q2.dequeue().dequeue().dequeue().peek());
		// Assert.assertEquals("1","ddd",
		// q2.dequeue().dequeue().dequeue().dequeue().peek());
	}

	@Test
	public void testCase2() {
		PersistentQueue<String> q1 = new PersistentQueue<String>();
		PersistentQueue<String> q2 = q1.enqueue("ddd");
		PersistentQueue<String> q3 = q2.enqueue("eee");
		Assert.assertEquals("1", "ddd", q3.peek());
		Assert.assertEquals("1", "eee", q3.dequeue().peek());
		// Assert.assertEquals("1","eee", q3.dequeue().dequeue().peek());

	}

	@Test
	public void testCase3() {
		PersistentQueue<String> q1 = new PersistentQueue<String>();
		PersistentQueue<String> q2 = q1.enqueue("ddd");
		PersistentQueue<String> q3 = q2.enqueue("eee");
		Assert.assertEquals("1", "ddd", q3.peek());
		Assert.assertEquals("1", "eee", q3.dequeue().peek());
	}

}
