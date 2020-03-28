package itcast.day17.demo;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int ticket = 10;
    Object lockObj = new Object();
    Lock lock = new ReentrantLock();

    /**
     * 重写方法
     */
    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(50);
                // sellTic();
                sellTicUseLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sellTic(){
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在卖: " + ticket--);
    }
    public void sellTicUseLock(){
        lock.lock();
        if (ticket > 0) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在卖: " + ticket--);
        }
        lock.unlock();
    }
    public List<Map<String, Object>> mergeList
            (List<Map<String, Object>> list1, List<Map<String, Object>> LIST2, String s){
        return list1;
    }
}
