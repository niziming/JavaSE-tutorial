package chap27reflect.kuangstudy;

public class User extends Person{
    private String name;
    Integer id;

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println("user = " + user);
        try {
            // 获取class的三种方式
            Class<?> aClass = Class.forName("chap27reflect.kuangstudy.User");
            Class<User> userClass = User.class;
            Class<? extends User> aClass3 = new User().getClass();
            Class<Integer> type = Integer.TYPE;
            Class<?> superclass = aClass.getSuperclass();
            System.out.println("superclass = " + superclass);

            Class<?> aClass1 = Class.forName("chap27reflect.kuangstudy.User");
            Class<?> aClass2 = Class.forName("chap27reflect.kuangstudy.User");
            System.out.println("aClass = " + aClass);
            System.out.println("aClass = " + aClass1.hashCode());
            System.out.println("aClass = " + aClass2.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

class Person {

}
