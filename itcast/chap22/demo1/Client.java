package itcast.chap22.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("", 6666);

        try (
                OutputStream cos = socket.getOutputStream();
                InputStream cis = socket.getInputStream();
        ) {
            byte[] bytes = new byte[1024];
            cos.write("HelloTest Java network programing".getBytes());
            cis.read(bytes);
            System.out.print("接收服务器响应: ");
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
