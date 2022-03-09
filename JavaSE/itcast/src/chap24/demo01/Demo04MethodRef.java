package chap24.demo01;

public class Demo04MethodRef {
    public static void main(String[] args) {
        MethodRefObject methodRefObject = new MethodRefObject();
        printString(methodRefObject::printUpperCase);
    }

    public static void printString(Printable lambda) {
        lambda.print("hello");
    }

}
