package chap22internet_programing.demo4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器已启动");
        ServerSocket ss = new ServerSocket(6666);
        // 线程池
        ExecutorService service = Executors.newFixedThreadPool(4);
        while (true) {
            Socket accept = ss.accept();
            service.submit(() -> {
                try (
                        InputStream inputStream = accept.getInputStream();
                        BufferedInputStream sbis = new BufferedInputStream(inputStream);
                    ) {
                    byte[] bytes = new byte[64];
                    int len = sbis.read(bytes);
                    System.out.println(Thread.currentThread().getName() + ":" + new String(bytes, 0, len));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
    static void getAccept (Socket accept) {
        try {
            BufferedInputStream sbis = new BufferedInputStream(accept.getInputStream());
            byte[] bytes = new byte[128];
            sbis.read(bytes);
            System.out.println(Thread.currentThread().getName() + new String(bytes));
            if (Pattern.matches(".*关闭连接.*", new String(bytes))) {
                sbis.close();
                accept.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
