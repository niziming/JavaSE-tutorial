package liangyong.capture30;

public class Client {
	void someMethod() {
		TaskClass task = new TaskClass();
		Thread thread = new Thread(task);
		thread.start();
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.someMethod();
	}
}
