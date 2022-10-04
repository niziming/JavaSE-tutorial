package cn.zm.c022_ref_type_and_threadlocal;


import java.io.IOException;

public class P01_NormalReference {
    public static void main(String[] args) {
        Obj obj = new Obj();
        obj = null;
        System.gc(); // DisableExceptionGC
        System.out.println("obj = " + obj);
        try {
            System.in.read(); // 阻塞线程 给垃圾回收线程时间执行
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
