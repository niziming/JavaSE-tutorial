package chap22.demo2;

import java.io.*;
import java.net.Socket;

// 文件上传demo
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("", 6666);
        try (
            OutputStream cos = socket.getOutputStream();
            BufferedOutputStream cbos = new BufferedOutputStream(cos);
            BufferedInputStream cbis = new BufferedInputStream(
                new FileInputStream("itcast/chap22/demo2/index.html")
            );
        ) {
            byte[] bytes = new byte[8*1024];
            int len;
            while ((len = cbis.read(bytes)) != -1) {
                cbos.write(bytes, 0, len);
                cbos.flush();
            }
            System.out.println("客户端文件发送完毕!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
