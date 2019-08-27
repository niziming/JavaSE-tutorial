import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
    private static Account account = new Account();
    // 主函数
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            executorService.execute(new AddAPennyTask());
        }
        executorService.shutdown();

        // 等待所有任务完成
        while (!executorService.isTerminated()) {}
        System.out.println("余额是多少?" + account.getBalance());

    }
    // 为账户添加一个便士的线程
    private static class AddAPennyTask implements Runnable{
        @Override
        public void run() {
            synchronized (account){
                account.deposit(1);
            }
        }
    }
    // 账户实体类
    private static class Account {
        private int balance = 0;
        public int getBalance() {
            return balance;
        }
        public void deposit(int amount) {
            int newBalance = balance + amount;
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            balance = newBalance;
        }
    }
}
