package exception;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringJoiner;

public class EntendConstructTest {

	public static void main(String[] args) {
//		new Extend();
//		String s = "/home/../foo/";
//		String[] ds = s.split("/");
//		System.out.println(Arrays.toString(ds));
//		Stack<String> stack = new Stack<>();
//		stack.pop();
//		
		System.out.println( -1 >> 1);
//		System.out.println(hammingWeight(2147483648l));
		
	}
	
	  public static int hammingWeight(long n) {
	        int count = 0;
	        while(n != 0){
	            if((n & 1) == 1){
	                count++;
	            }
	            n = n >>> 1;
	        }
	        return count;
	    }

	static class Base {
		private String name = "base";

		public String getName() {
			return name;
		}

		Base() {
			System.out.println("base name = " + name + "  this.name:" + this.getName());
			print();
			tell();
			System.out.println("Base this:" + this.toString());
		}

		public void print() {
			System.out.println("Base print " + name);
		}

		public void tell() {
			System.out.println("Base tell " + name);
		}
	}

	static class Extend extends Base {
		private String name = "extend";

		public String getName() {
			return name;
		}

		Extend() {
			System.out.println("Extend name:" + name);
			print();
			tell();
			System.out.println("Extend this:" + this.toString());
		}

		public void print() {
			System.out.println("Extend print " + name);
		}

		public void tell() {
			System.out.println("Extend tell " + name);
		}
	}
}
