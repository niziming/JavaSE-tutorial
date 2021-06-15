package atguigu.chap8multi_thread.尚硅谷_宋红康_第8章_多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//创建并使用多线程的第四种方法：使用线程池
class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}

class MyThread1 extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": MyThread1.run");
	}
}

public class ThreadPool {
	public static void main(String[] args) {
		// poolTest();
		new MyThread1().start();

	}

	private static void poolTest() {
		// 1.调用Executors的newFixedThreadPool(),返回指定线程数量的ExecutorService
		ExecutorService pool = Executors.newFixedThreadPool(10);
		// 2.将Runnable实现类的对象作为形参传递给ExecutorService的submit()方法中，开启线程
		// 并执行相关的run()
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		// 3.结束线程的使用
		pool.shutdown();
	}
}
