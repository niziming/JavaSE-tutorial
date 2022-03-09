package chap22;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {
    // 定义线程池

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[16];
            int len;
            int count = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                for (byte aByte : bytes) {
                    System.out.printf("%02x ", aByte);
                }
                System.out.print(' ');
                for (byte aByte : bytes) {
                    count++;
                    System.out.printf("%c", aByte > 33 ? (char) aByte : '·');
                }
                if (count % 16 == 0) System.out.println();
            }
            accept.close();
            serverSocket.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
