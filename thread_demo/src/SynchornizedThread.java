public class SynchornizedThread {
    public static void main(String[] args) {
        SellTicketSync sellTicket = new SellTicketSync();
        Thread t1 = new Thread(sellTicket);
        Thread t2 = new Thread(sellTicket);
        Thread t3 = new Thread(sellTicket);
        Thread t4 = new Thread(sellTicket);
        Thread t5 = new Thread(sellTicket);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class SellTicketSync implements Runnable {
    private int ticket = 100;
    private boolean loop = true;

    public synchronized void sellTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }
        if (ticket == 0) {
            loop = false;
            System.out.println("售票结束");
        }

    }
    public synchronized static void m1() {
        System.out.println("dsfasdfsdf");
    }
    public static void m2() {
        synchronized (SellTicketSync.class) {
            System.out.println("dsfasdfsdf");
        }
    }

    @Override
    public void run() {
        while (loop) {
//            sellTicket();
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                }
                if (ticket == 0) {
                    loop = false;
                    System.out.println("售票结束");
                }
            }
        }
    }
}