package itcast.day16;

import java.io.FileNotFoundException;

public class ExceptionDemo {
    public static void main(String[] args) throws Exception {
        try {
            read("atxt");
            return;
        } catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println("无论怎么样都会执行");
        }
        System.out.println("over");
    }

    private static void read(String path) throws FileNotFoundException{
        if (!path.equals("a.txt"))
            throw new FileNotFoundException("文件不存在");
    }

    public static void getEle(int[] arr, int index){
        if (index < 0 || index > arr.length - 1)
            throw new ArrayIndexOutOfBoundsException("越界了");
    }
}
