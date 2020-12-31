package itcast.chap16.demo4;

// 定义Thread类的子类，
public class ThreadUsed extends Thread{
    ThreadUsed (){}
    ThreadUsed (String name){
        super(name);
    }
    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "线程正在执行");
        }
    }
    public static void main(String[] args) {
        ThreadUsed threadUsed = new ThreadUsed("1");
        threadUsed.run();
    }

}
