package cn.zm.basis;

public class EqualsAndHashCode {
  public static void main(String[] args) {
    Obj obj = new EqualsAndHashCode.Obj();
    Obj obj1 = new EqualsAndHashCode.Obj();
    System.out.println(obj.hashCode());
    System.out.println(obj1.hashCode());
    System.out.println(obj.equals(obj1));
  }

  static class Obj {
    private String code = "";
    private String name = "";
    private Integer age = 0;

    public Obj() {}

    @Override
    public int hashCode() {
      if (this.code != null) {
        return this.code.hashCode();
      }
      return 0;
    }

    @Override
    public boolean equals(Object obj) {
      Obj o = (Obj) obj;
      return o.hashCode() == this.hashCode() && this.name.equals(o.getName()) && this.age.equals(o.getAge());
    }


    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }
  }

}
