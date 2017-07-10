package exception;

import java.util.ArrayList;

public class TryCatchTest {
	
	public void testFinally() {
		try {
			ArrayList<String> list = new ArrayList<>();
			list.get(0);
		} catch (Exception e) {
			System.out.println();
			return;
		}finally {
			System.out.println("finally");
		}
		
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		new TryCatchTest().testFinally();
	}
}
