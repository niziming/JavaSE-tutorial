package cn.zm.juc;

import java.util.function.Consumer;

/**
 * Java 8 才被引入的一个非常有用的用于异步编程的类。
 * <p>
 * Future 接口有 5 个方法：
 * <p>
 * boolean cancel(boolean mayInterruptIfRunning) ：尝试取消执行任务。
 * boolean isCancelled() ：判断任务是否被取消。
 * boolean isDone() ： 判断任务是否已经被执行完成。
 * get() ：等待任务执行完成并获取运算结果。
 * get(long timeout, TimeUnit unit) ：多了一个超时时间。
 */
public class CompletableFutureExample {

  public static void main(String[] args) {
  }

}
