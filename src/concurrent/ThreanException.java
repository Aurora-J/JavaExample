package concurrent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreanException {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		int[] s = new int[1];
		s[0] = 0;
		for (int i = 0; i < 100; i++) {
			AtomicInteger integer = new AtomicInteger(0);
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String num = ++s[0] + "";
					list.add(0, num);
					System.out.println(num);
				}
			}).start();
		}
		
		System.out.println("打印" + list.get(0));
		
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// try {
		// String str = null;
		// new File(str);
		// } catch (Exception e) {
		// e.printStackTrace();
		// // TODO: handle exception
		// }
		// }
		// }).start();
	}
}
