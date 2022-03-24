package cn.zm.basis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class Generics<T> {
  private T key;
  public Generics(T key) {
    this.key = key;
  }

  public T getKey(){
    return this.key;
  }

  // 泛型接口
  public interface Generator<T> {
    public T method();
  }

  // 实现泛型接口
  class GeneratorImpl<T> implements Generator<T> {
    @Override
    public T method() {
      return null;
    }
  }

  // 泛型方法 指定类型
  class GeneratorImpl1 implements Generator<String> {

    @Override
    public String method() {
      return "hello";
    }


  }

  // 泛型方法
  public static <E> void printArray(E[] inArr) {
    for (E e : inArr) {
      System.out.printf("%s ", e);
    }
    System.out.println();
  }


  public static void main(String[] args) {

    //region 泛型方法使用
    Integer[] inArr = {1, 2, 3};
    String[] strs = {"ada", "vx"};
    printArray(inArr);
    printArray(strs);
    //endregion

    //region 泛型实例化
    Generics<Integer> instence = new Generics<>(1111);
    System.out.println(instence.getKey());
    //endregion

    //region 泛型擦除
    List<Integer> list = new ArrayList<>();

    list.add(12);
    // 这里直接添加会报错
    // list.add("a");
    Class<? extends List> clazz = list.getClass();
    // 但是通过反射添加是可以的
    // 这就说明在运行期间所有的泛型信息都会被擦掉
    try {
      Method add = clazz.getDeclaredMethod("add", Object.class);
      add.invoke(list, "kl");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    System.out.println(list);
    // list.forEach(e -> {
    //   System.out.println(e.getClass().getName());
    // });
    //endregion
  }
}
