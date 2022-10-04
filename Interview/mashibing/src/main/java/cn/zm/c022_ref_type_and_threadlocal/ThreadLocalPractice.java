package cn.zm.c022_ref_type_and_threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ThreadLocalPractice {
    static ThreadLocal<Person> tlp = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(() -> {
            tlp.set(new Person("jermaine"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try { 
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("tlp.get() = " + tlp.get());
        }).start();

        // 如果线程池拿的线程最好做以下操作
        tlp.remove();
        tlp = null;

    }

}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Person {
    private String name;
}