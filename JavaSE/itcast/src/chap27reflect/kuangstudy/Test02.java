package chap27reflect.kuangstudy;

public class Test02 {
    static {
        System.out.println("Test02.instance initializer");
    }

    public static void main(String[] args) {
        // 主动引用
        // Son son = new Son();
        // System.out.println("son = " + son);

        // 反射
        // try {
            // Class<?> aClass = Class.forName("itcast.chap27reflect.kuangstudy.Son");
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }

        // 被动引用, 不会产生类初始化的引用
        System.out.println("Son.father.b = " + Son.b);

        // Son[] arr = new Son[5];

        // System.out.println("Son.m = " + Son.M);


    }
}

class Father {
    static int b = 2;
    static
    {
        System.out.println("Father.static initializer");
    }
}

class Son extends Father {
    static {
        System.out.println("Son.static initializer");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;

}