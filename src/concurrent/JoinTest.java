package concurrent;

public class JoinTest {
	public static void main(String[] args) {
		Thread thread1, thread2, thread3;
		
		thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					thread1.join();
					System.out.println("thread2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	
		thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					thread1.join();
					System.out.println("thread3");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println(thread2.getState() + " " + thread2.getState());
	}

}
