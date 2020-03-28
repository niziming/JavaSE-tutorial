package itcast.day19.demo04;

public interface Cook {
    void makeFood();
    public static void invokeCook(Cook c){
        c.makeFood();
    }
}
