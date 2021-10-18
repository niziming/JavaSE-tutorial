package chap20.demo6;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOEHandle {
    public static void main(String[] args) throws IOException{
        // 实际开发 ，建议使用 try...catch...finally
        FileWriter fw = null;
        try {
            fw = new FileWriter("itcast/chap20/demo6/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // jdk7 try-with-resource 该语句确保了每个资源在语句结束时关闭。所谓的资源
        // （resource）是指在程序完成后，必须关闭的对象。
        try (FileWriter fw1 = new FileWriter("itcast/chap20/demo6/test.txt");){
            // do
            fw1.write("ziming");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JDK9的改进(扩展知识点了解内容)
        // JDK9中 try-with-resource 的改进，对于引入对象的方式，支持的更加简洁。被引入的对象，同样可以自动关闭，
        // 无需手动close，我们来了解一下格式。
        // 改进前格式：
        // 被final修饰的对象
        // final Resource resource1 = new Resource("resource1");
        // // 普通对象
        // Resource resource2 = new Resource("resource2");
        // // 引入方式：创建新的变量保存
        // try (Resource r1 = resource1;
        //      Resource r2 = resource2) {
        //     // 使用对象
        // }
        // 改进后格式：
        // 被final修饰的对象
        // final Resource resource1 = new Resource("resource1");
        // // 普通对象
        //         Resource resource2 = new Resource("resource2");
        // // 引入方式：直接引入
        //         try (resource1; resource2) {
        //      // 使用对象
        //         }

        FileWriter fw2 = new FileWriter("itcast/chap20/demo6/test.txt");
        FileReader fr = new FileReader("itcast/chap20/demo6/test.txt");
        //
        // try (fw2; fr){
        //     // do
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

    }
}
