package format;

public class DurationTest {
	public static void main(String[] args) {
		long millis = 600000;
		long hour = millis / 3600000;
        long minute = (millis % 3600000) / 60000;
        java.text.DecimalFormat df = new java.text.DecimalFormat("00");
        System.out.println(df.format(hour) + ":" + df.format(minute));
	}
}
