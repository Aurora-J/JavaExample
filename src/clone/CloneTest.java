package clone;

import java.util.Iterator;

public class CloneTest implements Cloneable{
	String s;
	TestClassB testClassB;
	
	
	
	

	public CloneTest(String s, TestClassB testClassB) {
		super();
		this.s = s;
		this.testClassB = testClassB;
	}
	
	@Override
	public String toString() {
		return hashCode() + "   " + s + "   " + testClassB;
	}

	public static void main(String[] args) {
		
		CloneTest testClassA = new CloneTest("aaa", new TestClassB());
		
		try {
			CloneTest newTestClassA = (CloneTest) testClassA.clone();
			
			System.out.println(testClassA.toString());
			System.out.println(newTestClassA.toString());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		testClassB = (TestClassB) testClassB.clone();
		return super.clone();
	}
	
	
	public static class TestClassB implements Cloneable{
		String b;
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
	}
}
