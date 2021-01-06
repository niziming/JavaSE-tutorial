package itcast.chap22.demo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket accept = ss.accept();
        // 线程池
        ExecutorService service = Executors.newFixedThreadPool(4);

        try {
            while (true) {
                service.submit(() -> {
                    try {
                        getAccept(ss);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void getAccept (ServerSocket ss) throws IOException {
        Socket accept = ss.accept();
        OutputStream sos = accept.getOutputStream();
        InputStream sis = accept.getInputStream();
        BufferedOutputStream sbos = new BufferedOutputStream(sos);
        BufferedInputStream sbis = new BufferedInputStream(sis);
        byte[] bytes = new byte[128];
        int len;
        while ((len = sbis.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.println(Thread.currentThread().getName() + ": " + s);
            if (s.equals("关闭连接")) {
                closeAll(sbis, sbos, sis, sos);
            }
        }
    }

    private static void closeAll(
            BufferedInputStream sbis,
            BufferedOutputStream sbos,
            InputStream sis,
            OutputStream sos
    ) {
        try {
            sbis.close();
            sbos.close();
            sis.close();
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
