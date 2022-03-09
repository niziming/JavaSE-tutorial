package chap22;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerResponseHtml {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        // 转换流读取浏览器的请求消息
        BufferedReader readWb = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String requst = readWb.readLine();
        // 取出请求资源的路径
        String[] strArr = requst.split(" ");
        // 去掉web前面的/
        // String path = strArr[1].substring(1);
        String path = "itcast/chap22/index.html";
        // 读取客户端请求的资源文件
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len = 0;
        // 字节输出流,将文件写会客户端
        OutputStream out = socket.getOutputStream();
        // 写入HTTP协议响应头,固定写法
        out.write("HTTP/1.1 200 OK\r\n".getBytes());
        out.write("Content‐Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        out.write("\r\n".getBytes());
        while ((len = fis.read(bytes)) != -1){
            out.write(bytes, 0, len);
        }
        socket.close();
        serverSocket.close();
        inputStream.close();
    }
}
