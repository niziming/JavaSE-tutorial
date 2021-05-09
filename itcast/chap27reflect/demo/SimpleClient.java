package itcast.chap27reflect.demo;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 8001);
        // 输出流
        OutputStream os = socket.getOutputStream();
        // 输出对象
        ObjectOutputStream oos = new ObjectOutputStream(os);
        // 输入流
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        // 创建一个远程调用对象
        Call c = new Call("itcast.chap26reflect.demo9.HelloService", "echo", new Class[] {String.class}, new Object[] {"Java"});
        // 向服务器发送对象
        oos.writeObject(c);
        // 接受服务器返回的对象,包含了方法执行结果的Call对象
        c = (Call) ois.readObject();
        System.out.println(c.getResult());
        ois.close();
        oos.close();
        socket.close();
    }

    public static void method() {

    }

}
