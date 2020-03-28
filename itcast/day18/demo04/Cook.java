package itcast.day18.demo04;

public interface Cook {
    void makeFood();
    public static void invokeCook(Cook c){
        c.makeFood();
    }
}
