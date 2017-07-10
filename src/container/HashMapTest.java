package container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapTest {
	private HashMap<String, Boolean> map = new HashMap<>();

	public void isAllowNull() {
		// null is allowed to be value
		map.put("1", null);
		// null is allowed to be value
		map.put(null, true);

		System.out.println("map.containsKey(1) :" + map.containsKey("1"));
		System.out.println("map.containsKey(null) :" + map.containsKey(null));
	}

	public void threadSafe() {
		Lock lock = new ReentrantLock();
		boolean[] first = new boolean[2];

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					map.put(i + "", false);
				}
				first[0] = true;
				if (first[0] && first[1]) {
					new Thread(new Runnable() {

						@Override
						public void run() {

							for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
								Entry<String, Boolean> entry = (Entry<String, Boolean>) iterator.next();
								System.out.println(entry.getKey() + ":" + entry.getValue());
							}
						}
					}).start();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					map.put(i + "", true);
				}
				first[1] = true;
				if (first[0] && first[1]) {
					new Thread(new Runnable() {

						@Override
						public void run() {

							for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
								Entry<String, Boolean> entry = (Entry<String, Boolean>) iterator.next();
								System.out.println(entry.getKey() + ":" + entry.getValue());
							}
						}
					}).start();
				}
			}
		}).start();

	}

	public static void main(String[] args) {
		new HashMapTest().isAllowNull();
		LinkedHashMap<Long, Long> map;
	}

}
