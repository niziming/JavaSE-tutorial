package capture30;

public class PrintChar implements Runnable {

	private char charToPoint;
	private int times;

	public PrintChar(char c, int t) {
		charToPoint = c;
		times = t;
	}

	@Override
	public void run() {
		for (int i = 0; i <= times; i++) {
			System.out.print(charToPoint);
		}
	}
}
