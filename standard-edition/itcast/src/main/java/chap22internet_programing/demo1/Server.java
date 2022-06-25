package chap22internet_programing.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket accept = ss.accept();
        try (
                InputStream sis = accept.getInputStream();
                OutputStream sos = accept.getOutputStream();
            ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = sis.read(bytes)) != -1) {
                System.out.print("服务器接收: ");
                System.out.println(new String(bytes));
                sos.write("server response".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
