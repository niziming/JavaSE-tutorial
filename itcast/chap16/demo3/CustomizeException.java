package itcast.chap16.demo3;

public class CustomizeException extends Exception{
    public <E> CustomizeException (E e) {
        super(e.toString());
    }

    public static void main(String[] args) {
        try {
            boolean c = customizeTest("未注册");
            boolean c1 = customizeTest("已注册");
        } catch (CustomizeException e) {
            e.printStackTrace();
        }


    }

    public static boolean customizeTest (String name) throws CustomizeException {
        if (name.equals("已注册")){
            throw new CustomizeException("您已注册");
        }
        return true;
    }
}

