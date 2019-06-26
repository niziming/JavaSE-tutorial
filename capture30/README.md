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
