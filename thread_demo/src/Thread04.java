public class Thread04 {
    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        T04 t04 = new T04();
        t04.setName("meowrain线程");
        t04.setPriority(Thread.MIN_PRIORITY);
        t04.start();
        System.out.println(  t04.getName() + "\t 优先级" + t04.getPriority());
        System.out.println(main.getName() + "\t 优先级" + main.getPriority());
        Thread.sleep(4000);
        t04.interrupt();
    }
}

class T04 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 正在运行");
        }
        try {
            System.out.println(Thread.currentThread().getName() + "休眠中");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " 被唤醒");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
            e.printStackTrace();
        }
    }
}