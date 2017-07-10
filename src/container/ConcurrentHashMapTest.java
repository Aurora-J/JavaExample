package container;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

	private void testTraversal() {
		for (int i = 0; i < 1000; i++) {
			map.put(String.valueOf(i), String.valueOf(i));
		}
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				Set<Entry<String, String>> set = map.entrySet();
				for (Entry<String, String> entry : set) {
					System.out.println("thread1 " + ++i + "");
				}
			}
		});
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread1.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("thread2 remove" + i);
					map.remove(String.valueOf(i));
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		new ConcurrentHashMapTest().testTraversal();
	}
}
