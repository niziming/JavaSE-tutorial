package cn.zm.juc;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
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

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 供给一个异步 有返回值, Supplier接口
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "1231", ThreadPool.getThreadPool());
    String s = future.get();
    System.out.println("s = " + s);

    // 执行一个异步 无返回值, 因为是Runnable接口
    CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("21231"));
    voidCompletableFuture.join();

    CompletableFuture<RpcResponse<Object>> resultFuture = new CompletableFuture<>();
    // 要想检查是否执行完成, 使用isDone
    boolean done = resultFuture.isDone();

    // complete() 方法只能调用一次，后续调用将被忽略。
    boolean complete = resultFuture.complete(new RpcResponse());

    CompletableFuture<String> future1 = CompletableFuture.completedFuture("hello");
    future1.join();
    System.out.println("equals = " + "hello".equals(future1.get()));

  }

  @Data
  private static class RpcResponse<T> {
    private String name;
  }
}
