package format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleFormatTest {
	public static void main(String[] args) {
		 SimpleDateFormat sdf = new SimpleDateFormat("ydday年sdffdsadd日 H:mm");
	     System.out.println(sdf.format(new Date()));
	}
}
