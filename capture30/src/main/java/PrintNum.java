public class PrintNum implements Runnable{
	private int num;

	//构造函数
	public PrintNum(int n){
		num = n;
	}

	@Override
	public void run(){
		Thread thread4 = new Thread(new PrintChar('C', 40));
		thread4.start();
		try {
			for (int i = 0; i <= num; i++) {
				System.out.print(i + " ");
				while (i == 50) {
					thread4.join();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
