public class TaskThreadDemo {
	public static void main(String[] args) {
		PrintChar PrintA = new PrintChar('A', 100);
		PrintChar PrintB = new PrintChar('B', 100);
		PrintNum printNum = new PrintNum(100);

		Thread threadA = new Thread(PrintA);
		Thread threadB = new Thread(PrintB);
		Thread threadNum = new Thread(printNum);

		//threadA.start();
		//threadB.start();
		threadNum.start();

		//threadA.run();
		//threadB.run();
		//threadNum.run();

	}
}
