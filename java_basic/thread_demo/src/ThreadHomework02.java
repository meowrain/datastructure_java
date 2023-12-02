
public class ThreadHomework02 {
    public static void main(String[] args) {
        threadLock lock = new threadLock();
        Thread thread1 = new Thread(lock);
        Thread thread02 = new Thread(lock);
        thread1.start();
        thread02.start();


    }
}

class threadLock implements Runnable {
    private static int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("Money is not enough");
                    break;
                } else {
                    money -= 1000;
                    System.out.println(Thread.currentThread().getName() + "取了1000块钱，当前剩余" + money + "元");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
