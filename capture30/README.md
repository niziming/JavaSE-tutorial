# 第30章 多线程和并行程序设计
## 30.1 引言
Java最重要的功能之一:在一个程序中运行多个任务;

## 30.2 线程的概念
一个程序可能包含可以同时运行的多个任务,线程是指一个任务从头至尾的执行流程,在java中每个任务都是Runable接口的一个实例,也称为可运行对象.
线程从本质上讲就是便于任务执行的对象.

## 30.3创建任务和线程
一个任务必须实现Runable接口,任务必须从线程运行.

Runable接口非常简单,只包含了一个run方法.需要实现这个方法告诉系统线程将如何运行.

### 程序清单30-1给出一个程序,创建并运行三个任务的线程;
- 打印A字母100次;
- 打印B字母100次;
- 打印1-100的整数;
如果运行该程序,则三线程将共享CPU,并在控制台上轮流打印字母和数字.

TaskThreadDemo.java

## 30.4Thread类
Thread包含了线程的构造方法,以及控制线程的方法.

~~~ java
public class Thread implements Runnable {
//创建一个空线程
+Thread()

//为指定的任务创建一个线程
+Thread(task)

//开始一个线程,JVM调用run()
+start(): void

//线程是否在运行
+isAlive(): boolean

//设置优先级 值(1-10)
+setPriority(p: int): void 

//等待该线程结束
+join():void 

//让一个线程指定休眠时间(毫秒)
+sleep(millis: long): void
 
//引发一个线程暂停并允许其他线程执行
+yield(): void

//中断该线程
+interrupt(): void

}
~~~
# 30.5闪烁的文本

# 30.6线程池
Java提供Executor接口来执行线程池中的任务,提供ExecutorService接口来管理和控制任务.
ExecutorService是Executor的子接口.

## 程序清单
ExecutorDemo.java

# 30.7 线程同步
线程同步用于协调相互依赖的线程的执行
如果一个共享资源被多个线程的同时访问,可能会遭到破坏.
## 程序清单30-4
AccountWithoutSync.java

线程同步语句使用
~~~ java
public synchronized void xMethod(){

}
~~~
等价于
~~~ java
public void xMethod(){
    synchronize (this){
    }
~~~

# 30.8利用加锁同步
可以显式的采用加锁和状态来同步线程
在程序清单30-4中,100个任务向同一个账户并发存储一个便士,会造成冲突.在deposit方法中
使用synchronized关键字可以避免这种情况.
public synchronized void deposit(double amount)
同步的实例方法都是隐式地需要一个加在实例上的锁.
java可以显示的加锁,这位协调线程带来了更多的控制功能.
一个锁是一个lock接口的实例,它定义了加锁和释放锁的方法.

## 程序清单30-5
AccountWithoutSyncUsingLock.java

# 30.9线程间协作





