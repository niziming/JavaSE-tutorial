package cn.zm.c022_ref_type_and_threadlocal;

import java.lang.ref.WeakReference;

public class P03_WeakReference {
    public static void main(String[] args) {
        WeakReference<Obj> wr = new WeakReference<>(new Obj());
        System.out.println("wr.get() = " + wr.get());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("wr.get() = " + wr.get());

        ThreadLocal<Obj> tl = new ThreadLocal<>();
        tl.set(new Obj());
        tl.remove();

    }
}
