package itcast.chap22.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    Socket s;
    int clientId = 0;
    OutputStream cos;
    InputStream cis;
    Client (String host, int port) {
        clientId +=1;
        try {
            s = new Socket(host, port);
            cos = s.getOutputStream();
            cis = s.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OutputStream getCos() throws IOException {
        return s.getOutputStream();
    }

    public InputStream getCis() throws IOException {
        return s.getInputStream();
    }

    void sendMsg (String msg) {
        try {
            // client send
            cos.write(new String(clientId + ": " + msg).getBytes());
            byte[] bytes = new byte[1024];
            // recover server msg
            System.out.print("接收服务器响应: ");
            cis.read(bytes);
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Double random = Math.random()*10.0;
            System.out.println(random);
            service.submit(() -> {
                new Client("", 6666).sendMsg(new String(random.toString()));
            });
        }
    }
}
