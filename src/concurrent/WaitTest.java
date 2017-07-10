package concurrent;

import java.util.concurrent.ConcurrentSkipListMap;

public class WaitTest {
	public static void main(String[] args) {
		testTwo();
	}

	private void testOne() {
		Object o = new Object();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (WaitTest.class) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread1睡醒了");

					synchronized (o) {
						try {
							System.out.println("thread1开始Wait");
							o.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (WaitTest.class) {
					System.out.println("thread2开始执行");
				}
			}
		});
		thread1.start();
		thread2.start();
	}

	private static void testTwo() {
		Object o = new Object();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread1睡醒了");
					
					try {
						System.out.println("thread1开始Wait");
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (o) {
					System.out.println("thread2开始执行");
				}
			}
		});
		thread1.start();
		thread2.start();
		
		
		
	}

}
