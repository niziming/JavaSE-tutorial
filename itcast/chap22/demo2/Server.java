package itcast.chap22.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket accept = ss.accept();
        try (
                InputStream sis = accept.getInputStream();
                BufferedInputStream sbis = new BufferedInputStream(sis);
                BufferedOutputStream sbos = new BufferedOutputStream(
                        new FileOutputStream("itcast/chap22/demo2/new.html")
                );
            ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = sbis.read(bytes)) != -1) {
                System.out.print("服务器接收: " + len + "字节");
                sbos.write(bytes, 0, len);
                sbos.flush();
            }
            sbos.write("服务器接收完毕".getBytes());
            System.out.println("服务器接收完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
