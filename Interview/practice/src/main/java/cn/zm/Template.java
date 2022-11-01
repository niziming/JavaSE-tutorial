package cn.zm;

import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class Template {
    public static int findRepeatNumber(int[] nums) {
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;

            if (ints[nums[i]] >= 2) return nums[i];
        }
        return -1;

    }

    // static volatile int state;
    //
    // public static void main(String[] args) {
    //     CountDownLatch latch = new CountDownLatch(1);
    //     CountDownLatch latch1 = new CountDownLatch(1);
    //
    //     Thread thread = new Thread(() -> {
    //         System.out.print(" A ");
    //         latch.countDown();
    //     });
    //     Thread thread1 = new Thread(() -> {
    //         try {
    //             thread.join();
    //         } catch (InterruptedException e) {
    //             throw new RuntimeException(e);
    //         }
    //         System.out.print(" B ");
    //         latch.countDown();
    //     });
    //     Thread thread2 = new Thread(() -> {
    //         try {
    //             thread1.join();
    //         } catch (InterruptedException e) {
    //             throw new RuntimeException(e);
    //         }
    //         System.out.print(" C ");
    //         latch.countDown();
    //     });
    //
    //     thread.start();
    //     thread1.start();
    //     thread2.start();
    // }


    // @Data
    // static class Department {
    //     private Long id;
    //     private String name;
    //     List<Department> departments;
    // }
    //
    // public static void main(String[] args) {
    //     Department department = new Department();
    //     String lesson = "课程";
    //     searchLesson(department,lesson );
    //
    // }
    //
    // private static List searchLesson(Department department, String lesson) {
    //     ArrayList<Long> ids = new ArrayList<>();
    //     if (lesson.equals(department.name)) ids.add(department.getId());
    //     if (!department.getDepartments().isEmpty()) {
    //         List<Long> collect = department.getDepartments().stream().filter(dep -> !dep.getName().equals(lesson)).map(dep -> dep.getId()).collect(Collectors.toList());
    //         List<Department> departments = department.getDepartments();
    //         for (Department department1 : departments) {
    //             searchLesson(department1, lesson).addAll(collect);
    //         }
    //     }
    //     return ids;
    // }


}
