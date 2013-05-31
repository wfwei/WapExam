package jp.co.wap.exam;

public class TestPersistentQueue<E> {

	public static void main(String[] args) {
		PersistentQueue<String> queue = new PersistentQueue<String>();
		PersistentQueue<String> a = queue.enqueue("hello").enqueue(" world");
		System.out.println(a.enqueue(":").enqueue("wfw"));
		System.out.println(a.enqueue("?").dequeue().dequeue().enqueue("ok")
				.dequeue());
		System.out.println(a);
	}

}