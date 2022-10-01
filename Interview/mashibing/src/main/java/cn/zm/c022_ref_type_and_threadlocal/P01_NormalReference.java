package cn.zm.c022_ref_type_and_threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class P01_NormalReference {
    public static void main(String[] args) {
        Obj obj = new Obj();
        obj = null;
        System.gc(); // DisableExceptionGC
        log.info(String.valueOf(obj));
        try {
            System.in.read(); // 阻塞线程 给垃圾回收线程时间执行
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
