package cn.zm.basis;

import java.io.*;

public class Serialization {
  static class Employee implements Serializable {

    private String name;
    private int age;
    private transient int SSN;

    {
      System.out.println("Employee constructor");
    }

    @Override
    public String toString() {
      return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", SSN=" + SSN +
        '}';
    }
  }

  /**
   * 序列化
   * @param o
   * @param <O>
   */
  static <O extends Serializable> void write (O o) {
    try (
      FileOutputStream stream = new FileOutputStream("employee.ser");
      ObjectOutputStream out = new ObjectOutputStream(stream)) {
      out.writeObject(o);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * 反序列化
   * @param <O>
   */
  static <O extends Serializable> O read (String fileName) {
    O o = null;
    try (
      final FileInputStream inStream = new FileInputStream(fileName);
      final ObjectInputStream in = new ObjectInputStream(inStream)
    ) {
      o = (O) in.readObject();
      return o;
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
    return o;
  }

  public static void main(String[] args) {
    Employee employee = new Employee();
    employee.age = 20;
    employee.name = "zhangsan";
    employee.SSN = 123456789;
    System.out.println("序列化前 " + employee);
    write(employee);
    Employee e = read("employee.ser");
    System.out.println("反序列化 " + e);
  }

}
