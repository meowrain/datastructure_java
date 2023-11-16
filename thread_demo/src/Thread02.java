public class Thread02 {
    public static void main(String[] args) {
//        SellTicket st1 = new SellTicket();
//        SellTicket st2 = new SellTicket();
//        SellTicket st3 = new SellTicket();
//        st1.start();
//        st2.start();
//        st3.start();
        SellTicket2 st = new SellTicket2();
        new Thread(st).start();
        new Thread(st).start();
        new Thread(st).start();
    }
}

class SellTicket extends Thread {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
                ticket--;
            }
            if (ticket <= 0) {
                System.out.println("售票结束");
                break;
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SellTicket2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
            ticket--;
            if (ticket <= 0) {
                System.out.println("售票结束");
                break;
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
