package efficienc;

public class TimeComplexity {
	public static void main(String[] args) {
		equalStringTest();
	}
	
	public static void equalStringTest() {
		int a = 0;
		int count = 100000;
		int[] array = new int[count];
		String[] strArray = new String[count];
		for (int i = 0; i < count; i++) {
			array[i] = (int) (Math.random() * 1000000);
			strArray[i] = String.valueOf(array[i]);
		}
		
		System.out.println("start");
		long tm = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			"1234567".equals(strArray[i]);
		}
		System.out.println("end 耗时:" + (System.currentTimeMillis() - tm));
	}
}
