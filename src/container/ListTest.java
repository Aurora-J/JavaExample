package container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		String[] l = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(l));
//		String[] m = (String[]) list.toArray();
//		System.out.println(Arrays.toString(m));
		
		
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			list2.add(i);
		}
		
		System.out.println(System.currentTimeMillis());
		list2.add(10000, 1);
		System.out.println(System.currentTimeMillis());
		
		
		
//		List<B> la = new ArrayList<>();
//		la.add(new B());
//		name(la);
	}
	
	
	
	public static void name(C[] list) {
		
	}
	
	static class A{
		
	}
	
	static class B extends A implements C{
		
	}
	
	interface C {
		
	}
}
