public class Thread01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
        for(int i = 0;i<100;i++) {
            System.out.println("Nice one");
        }
    }
}

class T1 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + (++count));
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10) {
                System.out.println("子线程1结束");
                break;
            }
        }

    }
}

class T2 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + (++count));
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 50) {
                System.out.println("子线程2结束");
                break;
            }
        }
    }
}