package cn.zm.basis;

/**
 * 深浅拷贝示例
 */
public class DeepAndShallowCopy {
  public static void main(String[] args) {

    // 浅拷贝 内部对象共用, 并没有对内部对象进行单独的拷贝
    Address address = new Address("成都");
    PersonShallowCopy person = new PersonShallowCopy(address);
    PersonShallowCopy person1 = person.clone();
    System.out.println(person == person1);
    System.out.println(person.getAddress() == person1.getAddress());

    System.out.println("------------------");

    // 深拷贝 内部对象独立拷贝
    PersonDeepCopy person3 = new PersonDeepCopy(address);
    PersonDeepCopy person4 = person3.clone();
    System.out.println(person3 == person4);
    System.out.println(person3.getAddress() == person4.getAddress());

  }

  public static class Address implements Cloneable{
    String name;

    public Address(String name) {
      this.name = name;
    }

    public Address() {}

    @Override
    public Address clone() {
      try {
        Address clone = (Address) super.clone();
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return clone;
      } catch (CloneNotSupportedException e) {
        throw new AssertionError();
      }
    }


    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  /**
   * 浅拷贝
   */
  public static class PersonShallowCopy implements Cloneable {
    Address address;

    public PersonShallowCopy(Address address) {
      this.address = address;
    }

    @Override
    public PersonShallowCopy clone() {
      try {
        return (PersonShallowCopy) super.clone();
      } catch (CloneNotSupportedException e) {
        throw new AssertionError();
      }
    }

    public Address getAddress() {
      return address;
    }

    public void setAddress(Address address) {
      this.address = address;
    }
  }

  /**
   * 深拷贝
   */
  public static class PersonDeepCopy implements Cloneable {
    Address address;

    public PersonDeepCopy(Address address) {
      this.address = address;
    }

    @Override
    public PersonDeepCopy clone() {
      try {
        PersonDeepCopy clone = (PersonDeepCopy) super.clone();
        this.address = clone.getAddress().clone();
        return clone;
      } catch (CloneNotSupportedException e) {
        throw new AssertionError();
      }
    }

    public Address getAddress() {
      return address;
    }

    public void setAddress(Address address) {
      this.address = address;
    }
  }

}
