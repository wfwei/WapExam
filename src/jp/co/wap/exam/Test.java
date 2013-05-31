package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		List<String> unmodifiable = Collections.unmodifiableList(strings);
//		unmodifiable.add("New string"); // will fail at runtime
		strings.add("Aha!"); // will succeed
		strings.add("oh,shit");
		System.out.println(unmodifiable);
	}
}
