package chap22internet_programing.demo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动.....");
        // 1. 创建服务端ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2. 循环接收,建立连接
        while (true) {
            Socket accept = serverSocket.accept();
           /*
           3. socket对象交给子线程处理,进行读写操作
               Runnable接口中,只有一个run方法,使用lambda表达式简化格式
            */
            new Thread(() -> {
                try (
                    BufferedInputStream sbis = new BufferedInputStream(accept.getInputStream());
                ) {
                    byte[] b = new byte[64];
                    sbis.read(b);
                    System.out.println("服务器接收: " + new String(b));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
