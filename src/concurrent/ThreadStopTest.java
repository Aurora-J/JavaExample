package concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * future actually 
 * @author aurora
 *
 */
public class ThreadStopTest {
	
	public static void main(String[] args) {
		threadStop();
	}
	
	public static void threadStop() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (true) {
					System.out.println("print");
				}
			}
			
		});
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
		//停止是可以直接停止的，在sleep时也可以停止。
		thread.stop();
	}

	public static void taskStop() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		Future future = executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Start");
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Done");
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		future.cancel(true);
	}
}
