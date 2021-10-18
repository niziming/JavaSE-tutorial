package chap27reflect.demo;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SimpleServer {
    private Map remoteObjs = new HashMap(); // 存放远程对象的缓存
    // 存
    public void register(String className, Object remoteObj){
        remoteObjs.put(className, remoteObj);
    }
    public void service() throws Exception{
        ServerSocket serverSockek = new ServerSocket(8001);
        System.out.println("服务器已启动");
        while (true) {
            Socket accept = serverSockek.accept();// 监听
            InputStream is = accept.getInputStream();
            OutputStream os = accept.getOutputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            // 接受客户端对象
            Call c = (Call) ois.readObject();

            System.out.println(c);
            // 调用相关对象方法
            c = invoke(c);
            oos.writeObject(c);
            ois.close();
            oos.close();
            accept.close();
        }
    }

    private Call invoke(Call c) {
        Object result = null;
        try {
            String className = c.getClassName();
            String methodName = c.getMethodName();
            Object[] params = c.getParams();
            Class[] paramTypes = c.getParamTypes();
            Class<?> classType = Class.forName(className);
            // System.out.println("methodName" + methodName);
            // System.out.println("paramTypes" + Arrays.toString(paramTypes));
            // 获取方法对象
            Method method = classType.getMethod(methodName, paramTypes);
            // 缓存中取出相关的远程对象
            Object o = remoteObjs.get(className);
            if (o == null) throw new Exception(className + "的远程对象不存在");
            else result = method.invoke(o, params);
        } catch (Exception e) {
            result = e;
        }
        // 设置方法的执行结果
        c.setResult(result);
        return c;
    }

    public static void main(String[] args) throws Exception {
        SimpleServer server = new SimpleServer();
        // 把事先创建的HelloServiceImpl对象加入服务器缓冲中
        server.register("itcast.chap26reflect.demo9.HelloService", new HelloServiceImpl());
        server.service();
    }
}
