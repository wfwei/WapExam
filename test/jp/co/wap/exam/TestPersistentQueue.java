package jp.co.wap.exam;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPersistentQueue<E> {

	@BeforeClass
	public static void bf() {
		System.out.println("test on Problem1");
	}

	@Before
	public void overhead() {
		// intervals.clear();
	}

	@Test
	public void test(){
		
	}
	
	public static void main(String[] args) {
		PersistentQueue<String> queue = new PersistentQueue<String>();
		PersistentQueue<String> a = queue.enqueue("hello").enqueue(" world");
		System.out.println(a.enqueue(":").enqueue("wfw"));
		System.out.println(a.enqueue("?").dequeue().dequeue().enqueue("ok")
				.dequeue());
		System.out.println(a);
	}

}