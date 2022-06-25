package chap17.demo6;

public class StateTest implements Runnable{
    StateTest () {
        System.out.println(Thread.currentThread().getState());
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getState());
    }

    public static void main(String[] args) {
        StateTest stateTest = new StateTest();
        new Thread(stateTest).start();
    }
}
