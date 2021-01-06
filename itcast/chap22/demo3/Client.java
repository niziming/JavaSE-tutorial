package itcast.chap22.demo3;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");
        // 1.创建流对象
        Socket socket = new Socket("", 6666);
        // 1.1 创建输入流,读取本地文件
        // BufferedInputStream cbis = new BufferedInputStream(socket.getInputStream());
        // 1.2 创建输出流,写到服务端
        BufferedOutputStream cbos = new BufferedOutputStream(socket.getOutputStream());
        cbos.write("客户端消息".getBytes());
        // 4.释放资源
        cbos.close();
        socket.close();
    }
}
