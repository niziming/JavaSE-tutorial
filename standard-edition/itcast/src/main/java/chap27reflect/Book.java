package chap27reflect;

public class Book {
    String name; // 书名
    int id, price; // 书id, 书价格
    // private int id, price; // 书id, 书价格

    public Book() {} //无参构造

    // 全参构造
    public Book(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    // 带可变参数的构造方法
    public Book(String... strings) {
        if (strings.length > 0) id = Integer.valueOf(strings[0]);
        if (strings.length > 1) id = Integer.valueOf(strings[1]);
    }

    // 输出图书信息
    public void print(){
        System.out.println("name=" + name);
        System.out.println("id=" + id);
        System.out.println("price=" + price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
