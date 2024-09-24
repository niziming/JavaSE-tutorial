package capture30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithoutSyncUsingLock {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <100 ; i++){
            System.out.println(i);
            executorService.execute(new AddAPennyTask());
        }
        executorService.shutdown();

        while (!executorService.isTerminated()){

        }
        System.out.println("余额为?" + account.getBalance());
    }

    // 为账户添加一个便士的线程
    private static class AddAPennyTask implements Runnable{
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    // 账户实体类
    private static class Account {
        // 创建一个锁
        private static Lock lock = new ReentrantLock();
        private int balance = 0;

        public int getBalance(){
            return balance;
        }
        public void deposit(int amount) {
            // 加锁
            lock.lock();
            try{
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }finally {
                // 解锁
                lock.unlock();
            }

        }
    }
}
