package cn.zm;

public class ConstantPool {
  public static void main(String[] args) {

    Integer i1 = 40;
    Integer i2 = new Integer(40);
    System.out.println(i1==i2);

    Integer i3 = 22240;
    Integer i4 = new Integer(22240);
    System.out.println(i3==i4);


  }
}
