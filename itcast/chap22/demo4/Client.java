package itcast.chap22.demo4;

import java.io.*;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    String clientId;
    Socket s;
    BufferedOutputStream cbos;
    Client(String host, int port) {
        clientId = UUID.randomUUID().toString();
        try {
            s = new Socket(host, port);
            cbos = new BufferedOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendMsg(String msg) throws IOException {
        System.out.println(clientId + "发送" + msg);
        cbos.write(new String(clientId + ": " + msg).getBytes());

    }

    void close () throws IOException{
        System.out.println("客户端关闭");
        cbos.close();
        s.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");
        ExecutorService service = Executors.newFixedThreadPool(4);
        while (true) {
            service.submit(() -> {
                Client client = new Client("", 6666);
                try {
                    client.sendMsg("hello");
                    client.close();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
