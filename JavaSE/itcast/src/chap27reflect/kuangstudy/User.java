package chap27reflect.kuangstudy;

import lombok.Data;

@Data
public class User extends Person{
    private String name;
    Integer id;

    public static void main(String[] args) {
        User user = new User();
        System.out.println("user = " + user);
        try {
            // 获取class的三种方式
            Class<?> aClass = Class.forName("itcast.chap27reflect.kuangstudy.User");
            Class<User> userClass = User.class;
            Class<? extends User> aClass3 = new User().getClass();
            Class<Integer> type = Integer.TYPE;
            Class<?> superclass = aClass.getSuperclass();
            System.out.println("superclass = " + superclass);

            Class<?> aClass1 = Class.forName("itcast.chap27reflect.kuangstudy.User");
            Class<?> aClass2 = Class.forName("itcast.chap27reflect.kuangstudy.User");
            System.out.println("aClass = " + aClass);
            System.out.println("aClass = " + aClass1.hashCode());
            System.out.println("aClass = " + aClass2.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person {

}
