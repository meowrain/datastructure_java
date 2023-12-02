import java.util.Scanner;

public class ThreadHomeWork01 {
    public static void main(String[] args) throws InterruptedException {
        /* 在main方法中启动两个线程，在第一个线程循环随机打印100以内的整数 */
        /* 直到第二个线程读取到键盘输入的Q命令 */
        A thread = new A();
        B b = new B(thread);
        b.start();
        thread.start();
        b.join();
    }
}

class A extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {
    private A a;
    Scanner sc = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入Q");
            char c = sc.next().toUpperCase().charAt(0);
            if (c == 'Q') {
                a.setLoop(false);
                System.out.println("B线程退出");
                break;
            }
        }
    }
}