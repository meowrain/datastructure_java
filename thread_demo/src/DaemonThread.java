public class DaemonThread {
    public static void main(String[] args) {
        ThreadTest23 test = new ThreadTest23();
        test.setDaemon(true);
        //设置为守护线程,设置守护线程要在启动线程之前设置
        //守护线程，设置子线程为守护线程，那么会在主线程结束后结束子线程
        test.start();
        for(int i = 0;i<10;i++) {
            System.out.println("Main Thread running!");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("主线程中断");
            }
        }

    }
}

class ThreadTest23 extends Thread{
    @Override
    public void run() {
        while(true) {
            System.out.println("Thread Test running!");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("z子线程中断");
            }
        }
    }
}
