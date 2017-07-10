package string;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSort {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("第123");
		list.add("第23");
		list.add("你");
		list.add("你哦");
		list.add("ab");
		list.add("aa");
		list.add("aaa");
		

		
		Collections.sort(list, Collator.getInstance(java.util.Locale.CHINA));
		
		System.out.println(list.toString());
	}
}
