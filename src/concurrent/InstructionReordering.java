package concurrent;

public class InstructionReordering {
//	private static boolean bool;
	
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			final int finali = i;
			new Thread(){
				boolean bool = false;
				
				@Override
				public void run() {
					bool = true;
					if(bool){
//						System.out.println(finali);
//						break;
					}else {
						System.out.println(false);
					}
				}
			}.start();
		}
	}
}
