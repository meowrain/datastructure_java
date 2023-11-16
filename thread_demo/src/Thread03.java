public class Thread03 {
    public static void main(String[] args) throws InterruptedException {

        T t = new T();
        t.start();
        System.out.println("主线程休眠10s");
        Thread.sleep(10000);
        t.setLoop(false);
        System.out.println("主线程运行完璧");

    }
}

class T extends Thread {
    boolean loop =  true;
    @Override
    public void run() {
        int count = 0;
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "is running" + "\t " + count++);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}