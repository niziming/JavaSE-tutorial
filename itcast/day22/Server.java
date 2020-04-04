package itcast.day22;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1080];
        int len;
        while ((len = inputStream.read(bytes)) != -1)
            System.out.print(new String(bytes));
        accept.close();
        serverSocket.close();
        inputStream.close();

    }
}
