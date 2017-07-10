package concurrent;

public class BlockedTest {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				func();
			}
		});
		
	   Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				func();
			}
		});
	   
	   
//	   thread1.start();
//	   thread2.start();
//	   System.out.println(thread1.getState() + " " + thread2.getState());
//	   System.out.println(fruit(4));
	}
	
	public static synchronized void func() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static int fruit(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		return fruit(n - 3) + fruit(n - 2) + fruit(n - 1);
	}
}
