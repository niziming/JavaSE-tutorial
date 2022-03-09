package chap11.demo1;

public class User {
    final String USERNAME;
    User () {
        USERNAME = "ziming";
    }

    public static void main(String[] args) {
        System.out.println(
                new User().USERNAME
        );
    }
}
