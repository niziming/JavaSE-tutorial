package itcast.chap26annotation;

@MyInherited
public class TestInherited {
    public static void main(String[] args) {
        System.out.println(TestInherited.class.getAnnotation(MyInherited.class));
        System.out.println(TestB.class.getAnnotation(MyInherited.class));
        System.out.println(TestC.class.getAnnotation(MyInherited.class));
    }
    class TestB extends TestInherited {

    }
    class TestC extends TestInherited {

    }
}
