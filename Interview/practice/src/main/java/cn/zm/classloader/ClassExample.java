package cn.zm.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassExample {
  //region ClassLoaderExample
  public static class ClassLoaderExample {
    // AppClassLoader的父类加载器为ExtClassLoader，
    // ExtClassLoader的父类加载器为 null，null 并不代表ExtClassLoader没有父类加载器，
    // 而是 BootstrapClassLoader 。
    public static void main(String[] args) {
      ClassLoader classLoader = ClassLoaderExample.class.getClassLoader();
      System.out.println("classLoader = " + classLoader);

      ClassLoader parent = classLoader.getParent();
      System.out.println("classLoader parent = " + parent);

      ClassLoader grandParent = parent.getParent();
      System.out.println("grandParent = " + grandParent);
    }

  }
  //endregion

  //region Impl ClassLoader
  public class MyClassLoader extends ClassLoader {

    //磁盘上类的路径
    private String codePath;

    public MyClassLoader(ClassLoader parent, String codePath) {
      super(parent);
      this.codePath = codePath;
    }

    public MyClassLoader(String codePath) {
      this.codePath = codePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

      BufferedInputStream bis = null;
      ByteArrayOutputStream baos = null;

      //完整的类名
      String file = codePath + name + ".class";
      try {

        //初始化输入流
        bis = new BufferedInputStream(new FileInputStream(file));
        //获取输出流
        baos = new ByteArrayOutputStream();

        int len;
        byte[] data = new byte[1024];
        while ((len = bis.read(data)) != -1) {
          baos.write(data, 0, len);
        }

        //获取内存中的字节数组
        byte[] bytes = baos.toByteArray();

        //调用defineClass将字节数组转换成class实例
        Class<?> clazz = defineClass(null, bytes, 0, bytes.length);
        return clazz;

      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          baos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      return null;
    }
  }
  //endregion
}
