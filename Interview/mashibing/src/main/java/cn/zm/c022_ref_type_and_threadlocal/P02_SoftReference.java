package cn.zm.c022_ref_type_and_threadlocal;

import java.lang.ref.SoftReference;

public class P02_SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> sr = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println("sr.get() = " + sr.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sr.get() = " + sr.get());
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println("sr.get() = " + sr.get());
        // VM Options  -Xms20M -Xmx20M
    }
}
