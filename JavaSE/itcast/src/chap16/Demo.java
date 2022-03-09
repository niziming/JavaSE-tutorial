package chap16;

import javax.security.auth.login.LoginException;

public class Demo {
    static String[] names = {"bill", "hill", "hjll"};
    public static void main(String[] args) {
        try {
            checkUserNAME("hjll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean checkUserNAME(String uname) throws LoginException, RegisterException {
        for (String name : names) {
            if (name.equals(uname)) {
                throw new RegisterException(name + "已被注册");
            }
        }
        return true;
    }
}
