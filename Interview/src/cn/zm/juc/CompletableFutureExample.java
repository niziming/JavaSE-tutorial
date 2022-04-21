package cn.zm.juc;

import com.sun.deploy.util.StringUtils;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
    // thenApply();
    // thenApply();
    // thenAccept();
    // thenRun();
    // whenComplete();
    // handle();
    // exceptionally();
    // thenCompose();
    completableFutureBatch();
  }


  /**
   * 并行运行多个 CompletableFuture
   */
  public static void completableFutureBatch() throws ExecutionException, InterruptedException {
    String[] tasks = {"task1", "task2", "task3", "task4"};
    CompletableFuture<Void>[] completableFutures = new CompletableFuture[tasks.length];

    for (int i = 0; i < tasks.length; i++) {
      final int THREAD_NUM = i;
      CompletableFuture<Void> task = CompletableFuture.runAsync(() -> System.out.println(tasks[THREAD_NUM]));
      completableFutures[i] = task;
    }

    CompletableFuture<Void> future = CompletableFuture.allOf(completableFutures);
    future.join();
    System.out.println("all done");

    List<CompletableFuture<Void>> collect = Arrays.stream(tasks).map(s -> CompletableFuture.runAsync(() -> System.out.println(s))).collect(Collectors.toList());
    CompletableFuture<Void>[] completableFutures1 = collect.toArray(new CompletableFuture[]{});
    CompletableFuture.allOf(completableFutures1).join();
    System.out.println("all done");
  }
  /**
   * 使用 thenCompose() 按顺序链接两个 CompletableFuture 对象。
   * thenCompose() 可以两个 CompletableFuture 对象，
   * 并将前一个任务的返回结果作为下一个任务的参数，它们之间存在着先后顺序。
   * thenCombine() 会在两个任务都执行完成后，把两个任务的结果合并。
   * 两个任务是并行执行的，它们之间并没有先后依赖顺序。
   */
  public static void thenCompose() throws ExecutionException, InterruptedException {
    CompletableFuture<String> future = CompletableFuture
      .supplyAsync(() -> {
        System.out.println("supplyAsync");
        return "user_info>";
      })
      .thenCombine(CompletableFuture.supplyAsync(
          () -> {
            System.out.println("thenCombine>CompletableFuture.supplyAsync");
            return ">查询数据库!";
          }),
        (s1, s2) -> {
          System.out.println("s1 = " + s1);
          System.out.println("s2 = " + s2);
          return s1 + s2;
        })
      .thenCompose(s -> {
        System.out.println("thenCompose");
        System.out.println("s = " + s);
        return CompletableFuture.supplyAsync(() -> {
          System.out.println("thenCompose -> CompletableFuture.supplyAsync");
          return s + "auth";
        });
      });

    System.out.println("future = " + future.get());

  }

  /**
   * 还可以通过 exceptionally() 方法来处理异常情况。
   */
  public static void exceptionally() throws ExecutionException, InterruptedException {
    // CompletableFuture.supplyAsync(() -> {
    //     if (true) throw new RuntimeException("Computation error!");
    //     return "success";
    //   }
    // ).exceptionally(ex -> {
    //   ex.printStackTrace();
    //   return "failed";
    // });

    //想让 CompletableFuture 的结果就是异常的话，可以使用 completeExceptionally() 方法为其赋值。
    CompletableFuture<String> completableFuture = new CompletableFuture<>();
    // ...
    completableFuture.completeExceptionally(
      new RuntimeException("Calculation failed!"));
    // ...
    completableFuture.get(); // ExecutionException
  }

  /**
   * 异常处理
   * 你可以通过 handle() 方法来处理任务执行过程中可能出现的抛出异常的情况。
   */
  public static void handle() throws ExecutionException, InterruptedException {
    CompletableFuture future = CompletableFuture
      .supplyAsync(() -> new String[]{"result", "foo"})
      .handle((res, ex) -> {
        if (Objects.nonNull(ex)) ex.printStackTrace();
        return res != null ? res : "world";
      });

    boolean world = Objects.equals("world", future.get());

    System.out.println(future.get().getClass().getName());

    System.out.println("world = " + world);
  }

  /**
   * whenComplete() 的方法的参数是 BiConsumer<? super T, ? super Throwable> 。
   * 相对于 Consumer ， BiConsumer 可以接收 2 个输入对象然后进行“消费”。
   */
  public static void whenComplete() throws ExecutionException, InterruptedException {
    CompletableFuture<String[]> future = CompletableFuture
      .supplyAsync(() -> {
        System.out.println("supplyAsync");
        return "result";
      })
      .thenApplyAsync(r -> {
        System.out.println("thenApplyAsync");
        return r.split("");
      })
      .whenComplete((res, ex) -> {
        System.out.println("whenComplete");
        System.out.println(res);
        System.out.println(ex);
      });
    String[] strings = future.get();
    System.out.println(Arrays.toString(strings));
    System.out.println("done");
  }

  /**
   * thenRun() 如果你不需要从回调函数中获取返回结果，可以使用 thenAccept() 或者 thenRun()。
   * 这两个方法的区别在于 thenRun() 不能访问异步计算的结果。
   */
  public static void thenRun() throws ExecutionException, InterruptedException {
    CompletableFuture<String> resultFuture = CompletableFuture.supplyAsync(() -> String.valueOf(21), ThreadPool.getThreadPool());
    resultFuture.thenRun(() -> System.out.println(1231));
  }

  /**
   * thenApply() 方法接受一个 Function 实例，用它来处理结果。
   */
  public static void thenAccept() throws ExecutionException, InterruptedException {
    CompletableFuture<String> resultFuture = CompletableFuture.supplyAsync(() -> String.valueOf(21), ThreadPool.getThreadPool());
    resultFuture.thenAccept(System.out::println);
    resultFuture.thenAcceptAsync(System.out::println);
    System.out.println("resultFuture.isDone()");
  }

  /**
   * thenApply() 方法接受一个 Function 实例，用它来处理结果。
   */
  public static void thenApply() throws ExecutionException, InterruptedException {
    CompletableFuture<String> resultFuture = CompletableFuture.supplyAsync(() -> String.valueOf(21), ThreadPool.getThreadPool());

    CompletableFuture<Person> future = resultFuture.thenApply(r -> {
        Person person = new Person();
        person.setAge(Integer.valueOf(r));
        return person;
      })
      .thenApplyAsync(p -> {
        p.setAddress("成都");
        return p;
      })
      .thenApplyAsync(p -> {
        p.setName("jermaine");
        return p;
      });

    System.out.println(future.get());

  }

  //region Person
  @Data
  public static class Person {
    private String name;
    private String address;
    private Integer age;

  }
  //endregion


  /**
   * runAsync
   */
  public static void runAsync() {
    // 执行一个异步 无返回值, 因为是Runnable接口
    CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("21231"));
    voidCompletableFuture.join();

  }

  /**
   * supplyAsync
   */
  public static void supplyAsync() {
    // 供给一个异步 有返回值, Supplier接口
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "1231", ThreadPool.getThreadPool());
    String s = null;
    try {
      s = future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("s = " + s);

  }


  /**
   * complete
   */
  public static void complete() throws ExecutionException, InterruptedException {
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
