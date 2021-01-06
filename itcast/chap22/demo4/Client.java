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
        cbos.close();
        s.close();
    }

    public static void main(String[] args) {
        System.out.println("客户端启动");
        ExecutorService service = Executors.newFixedThreadPool(1);
        // try (
        //     Socket s = new Socket("", 6666);
        //     BufferedOutputStream cbos = new BufferedOutputStream(s.getOutputStream());
        // ) {
        //     cbos.write("hello".getBytes());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        while (true) {
            service.submit(() -> {
                Client client = new Client("", 6666);
                try {
                    client.sendMsg("hello");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        // Client client3 = new Client("", 6666);
        // Client client4 = new Client("", 6666);
        // client1.sendMsg("1");
        // client2.sendMsg("2");
        // client3.sendMsg("3");
        // client4.sendMsg("4");
        // while (true) {
        //     Double random = Math.random() * 10.0;
        //     Client client = new Client("", 6666);
        //
        //     service.submit(() -> {
        //         client.sendMsg(random.toString());
        //     });
        //     try {
        //         Thread.sleep(6000);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     client.sendMsg("关闭连接");
        // }
    }
}
